/*
 * Copyright 2013 Jocki Hendry.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wordpress.thesolidsnake.bahasaku.target.jvm;

import com.wordpress.thesolidsnake.bahasaku.grammar.BahasaKuBaseVisitor;
import com.wordpress.thesolidsnake.bahasaku.grammar.BahasaKuParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.objectweb.asm.*;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.*;
import java.lang.invoke.MethodType;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class BahasaKuVisitor extends BahasaKuBaseVisitor {

    private ClassWriter cw;
    private ClassVisitor cv;
    private MethodVisitor mv;
    private Label label0;
    private boolean enableTrace;
    private File sourceFile;
    private String namaSourceFile;

    private List<String> namaVariabel;

    private static final Handle OPERATOR_HANDLE;
    private static final Handle CONSTRUCTOR_HANDLE;
    private static final Handle METHODCALL_HANDLE;

    static {
        OPERATOR_HANDLE = new Handle(H_INVOKESTATIC,
            "com/wordpress/thesolidsnake/bahasaku/target/jvm/OperatorBootstrap",
            "bootstrap",
            "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;");
        CONSTRUCTOR_HANDLE = new Handle(H_INVOKESTATIC,
            "com/wordpress/thesolidsnake/bahasaku/target/jvm/MethodCallBootstrap",
            "constructorBootstrap",
            "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;)Ljava/lang/invoke/CallSite;");
        METHODCALL_HANDLE = new Handle(H_INVOKESTATIC,
            "com/wordpress/thesolidsnake/bahasaku/target/jvm/MethodCallBootstrap",
            "methodCallBootstrap",
            "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;I)Ljava/lang/invoke/CallSite;");
    }

    public BahasaKuVisitor(File sourceFile) {
        this(sourceFile, false);
    }
    public BahasaKuVisitor(File sourceFile, boolean enableTrace) {

        this.sourceFile = sourceFile;
        if (!sourceFile.getName().endsWith(".baku")) {
            throw new RuntimeException("Nama source file [" + sourceFile.getName() + "] tidak diakhiri dengan .baku");
        }
        this.namaSourceFile = sourceFile.getName().substring(0, sourceFile.getName().lastIndexOf('.'));
        this.enableTrace = enableTrace;
        this.namaVariabel = new ArrayList<>();

        cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        if (enableTrace) {
            cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        } else {
            cv = cw;
        }

        // Membuat sebuah class public dengan nama (tanpa package) sesuai dengan namaFile
        cv.visit(V1_7, ACC_PUBLIC + ACC_SUPER, namaSourceFile, null, "java/lang/Object", null);

        // Membuat method static void main(String[] args).
        // Seluruh implementasi kode program BahasaKu akan ada di method ini.
        mv = cv.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        label0 = new Label();
        mv.visitLabel(label0);

    }

    @Override
    public Object visitAngka(@NotNull BahasaKuParser.AngkaContext ctx) {
        Integer angka = Integer.valueOf(ctx.getText());
        mv.visitTypeInsn(NEW, "java/lang/Integer");
        mv.visitInsn(DUP);
        mv.visitIntInsn(BIPUSH, angka);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Integer", "<init>", "(I)V");
        return angka;
    }

    @Override
    public Object visitString(@NotNull BahasaKuParser.StringContext ctx) {
        String str = ctx.getText().substring(1, ctx.getText().length()-1);
        mv.visitLdcInsn(str);
        return str;
    }

    @Override
    public Object visitBooleanTrue(@NotNull BahasaKuParser.BooleanTrueContext ctx) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        return Boolean.TRUE;
    }

    @Override
    public Object visitBooleanFalse(@NotNull BahasaKuParser.BooleanFalseContext ctx) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        return Boolean.FALSE;
    }

    @Override
    public Object visitTampilkan(@NotNull BahasaKuParser.TampilkanContext ctx) {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        visit(ctx.expr());
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V");
        return null;
    }

    @Override
    public Object visitAssignment(@NotNull BahasaKuParser.AssignmentContext ctx) {
        String nama= ctx.IDENTIFIER().getText();
        int index = namaVariabel.indexOf(nama) + 1;
        if (index <= 0) {
            namaVariabel.add(nama);
            index = namaVariabel.size();
        }
        visit(ctx.expr());
        mv.visitVarInsn(ASTORE, index);
        return null;
    }

    @Override
    public Object visitIdentifier(@NotNull BahasaKuParser.IdentifierContext ctx) {
        String nama = ctx.IDENTIFIER().getText();
        int index = namaVariabel.indexOf(nama)+1;
        if (index <= 0) {
            throw new RuntimeException("Coba cek program-mu! Ada variabel yang tak dikenal, yaitu: [" + nama + "]");
        }
        mv.visitVarInsn(ALOAD, index);
        return nama;
    }

    @Override
    public Object visitPembagian(@NotNull BahasaKuParser.PembagianContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        mv.visitInvokeDynamicInsn("bagi", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", OPERATOR_HANDLE);
        return null;
    }

    @Override
    public Object visitPerkalian(@NotNull BahasaKuParser.PerkalianContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        mv.visitInvokeDynamicInsn("kali", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", OPERATOR_HANDLE);
        return null;
    }

    @Override
    public Object visitPenjumlahan(@NotNull BahasaKuParser.PenjumlahanContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        mv.visitInvokeDynamicInsn("tambah", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", OPERATOR_HANDLE);
        return null;
    }

    @Override
    public Object visitPengurangan(@NotNull BahasaKuParser.PenguranganContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        mv.visitInvokeDynamicInsn("kurang", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", OPERATOR_HANDLE);
        return null;
    }

    @Override
    public Object visitBuatObject(@NotNull BahasaKuParser.BuatObjectContext ctx) {
        String namaClass = ctx.qualifiedName().getText();
        int jumlahArgumen = 0;
        if (ctx.arguments().exprList()!=null) {
            jumlahArgumen = ctx.arguments().exprList().expr().size();
        }
        mv.visitTypeInsn(NEW, namaClass.replace('.', '/'));
        mv.visitInsn(DUP);
        visit(ctx.arguments());
        mv.visitInvokeDynamicInsn("buat", MethodType.genericMethodType(jumlahArgumen).toMethodDescriptorString(),
            CONSTRUCTOR_HANDLE, namaClass);
        return null;
    }

    @Override
    public Object visitPanggilMethod(@NotNull BahasaKuParser.PanggilMethodContext ctx) {
        String namaMethod = ctx.IDENTIFIER().getText();
        int jumlahArgumen = 0;
        if (ctx.arguments().exprList()!=null) {
            jumlahArgumen = ctx.arguments().exprList().expr().size();
        }
        visit(ctx.expr());
        visit(ctx.arguments());
        int type = (ctx.op.getType() == BahasaKuParser.SELF)? 1: 0;
        mv.visitInvokeDynamicInsn("panggil", MethodType.genericMethodType(jumlahArgumen+1).toMethodDescriptorString(),
            METHODCALL_HANDLE, namaMethod, type);
        return null;
    }

    public void generateOutput() {
        mv.visitInsn(RETURN);
        Label label = new Label();
        mv.visitLabel(label);
        for (int i=0; i<namaVariabel.size(); i++) {
            mv.visitLocalVariable(namaVariabel.get(i), "Ljava/lang/Object;",
                null, label0, label, i);
        }
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        cv.visitEnd();

        Path targetFile = Paths.get(sourceFile.getAbsoluteFile().getParent().toString(), namaSourceFile + ".class");
        System.out.println("Menghasilkan target file di lokasi: " + targetFile.toString() + "\n");
        try {
            Files.write(targetFile, cw.toByteArray(),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan saat membuat file target!");
            ex.printStackTrace();
        }
    }
}
