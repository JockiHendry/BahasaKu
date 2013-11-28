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

package com.wordpress.thesolidsnake.bahasaku;

import com.wordpress.thesolidsnake.bahasaku.grammar.BahasaKuLexer;
import com.wordpress.thesolidsnake.bahasaku.grammar.BahasaKuParser;
import com.wordpress.thesolidsnake.bahasaku.target.jvm.BahasaKuVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Tool ini dipakai untuk menjalankan program BahasaKu\n\n" +
                "Contoh penggunaan:\n" +
                "bahasaku namafilesource.baku\n" +
                "bahasaku source1.baku source2.baku\n" +
                "bahasaku -trace namafilesource.baku\n");
            return;
        }

        boolean enableTrace = false;
        List<String> sourceFiles = new ArrayList<>();

        // Melakukan parsing argumen
        // Dapat melakukan kompilasi lebih dari satu file
        for (String arg: args) {
            if ("-trace".equals(arg)) {
                enableTrace = true;
            } else {
                sourceFiles.add(arg);
            }
        }

        // Memulai proses kompilasi
        for (String sourceFile: sourceFiles) {
            Path file = Paths.get(sourceFile);
            if (!file.toFile().exists()) {
                System.out.println("Tidak dapat menemukan file: [" + file + "]");
                continue;
            }

            try {

                // Front-end
                ANTLRInputStream antlrInputStream = new ANTLRInputStream(Files.newInputStream(file));
                BahasaKuLexer lexer = new BahasaKuLexer(antlrInputStream);
                CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                BahasaKuParser parser = new BahasaKuParser(commonTokenStream);
                ParseTree parseTree = parser.file();

                // Back-end
                BahasaKuVisitor jvmVisitor = new BahasaKuVisitor(file.toFile(), enableTrace);
                jvmVisitor.visit(parseTree);
                jvmVisitor.generateOutput();

                // Menjalankan Program
                String namaFileLengkap = file.toFile().getName();
                String namaClass = namaFileLengkap.substring(0, namaFileLengkap.lastIndexOf('.'));
                ProcessBuilder pb = new ProcessBuilder(System.getProperty("java.home") + "/bin/java",
                    "-classpath",System.getProperty("java.class.path") + File.pathSeparatorChar + file.getParent().toAbsolutePath().toFile().toString(), namaClass);
                if (enableTrace) {
                    System.out.println("Mengerjakan " + pb.command());
                }
                pb.inheritIO();
                pb.start().waitFor();


            } catch (Exception ex) {
                System.out.println("Terjadi kesalahan [" + ex.getMessage() + "]");
            }
        }

    }

}
