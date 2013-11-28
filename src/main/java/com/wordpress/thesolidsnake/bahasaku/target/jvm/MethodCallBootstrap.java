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

import java.lang.invoke.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodCallBootstrap {

    private static final MethodHandle CONSTRUCTOR;
    private static final MethodHandle METHODCALL;
    private static final MethodHandle METHODCALL_RETURNSELF;

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            CONSTRUCTOR = lookup.findStatic(MethodCallBootstrap.class, "constructor",
                MethodType.methodType(Object.class, String.class, Object[].class));
            METHODCALL = lookup.findStatic(MethodCallBootstrap.class, "methodCall",
                MethodType.methodType(Object.class, String.class, Object[].class));
            METHODCALL_RETURNSELF= lookup.findStatic(MethodCallBootstrap.class, "methodCallReturnSelf",
                MethodType.methodType(Object.class, String.class, Object[].class));
        } catch (Exception ex) {
            throw new Error("Terjadi kesalahan tak terduga [" + ex.getMessage() + "]");
        }
    }

    public static Class getClassForName(String namaClass) throws Error {
        try {
            return Class.forName(namaClass);
        } catch (ClassNotFoundException ex) {
            throw new Error("Class Java tidak ditemukan: [" + namaClass + "]");
        }
    }

    public static boolean periksaPrimitif(Class primitiveClass, Object arg) {
        if (primitiveClass==long.class) return Long.class.isInstance(arg);
        if (primitiveClass==int.class) return Integer.class.isInstance(arg);
        if (primitiveClass==boolean.class) return Boolean.class.isInstance(arg);
        return false;
    }

    public static boolean isParameterSesuai(Class[] parameterTypes, Object[] args) {
        if (parameterTypes.length != args.length) return false;
        for (int i=0; i<parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                if (!periksaPrimitif(parameterTypes[i], args[i])) return false;
            } else if (!parameterTypes[i].isInstance(args[i])) {
                return false;
            }
        }
        return true;
    }

    public static Object constructor(String namaClass, Object[] args) {
        Class cls = getClassForName(namaClass);
        for (Constructor c: cls.getConstructors()) {
            if (isParameterSesuai(c.getParameterTypes(), args)) {
                try {
                    return MethodHandles.lookup().unreflectConstructor(c).invokeWithArguments(args);
                } catch (Throwable ex) {
                    throw new RuntimeException("Gagal membuat instance baru: " + ex.getMessage());
                }
            }
        }
        throw new Error("Tidak menemukan constructor yang tepat untuk " +
            namaClass+ " dengan argumen " + Arrays.deepToString(args));
    }

    public static Object methodCall(String namaMethod, Object[] args) {
        Class cls = args[0].getClass();
        Object[] realArgs = Arrays.copyOfRange(args, 1, args.length);
        for (Method m: cls.getMethods()) {
            if (m.getName().equals(namaMethod) && isParameterSesuai(m.getParameterTypes(), realArgs)) {
                try {
                    MethodHandle currentMethod = MethodHandles.lookup().unreflect(m);
                    return currentMethod.bindTo(args[0]).invokeWithArguments(realArgs);
                } catch (Throwable ex) {
                    throw new RuntimeException("Gagal mengerjakan method: " + ex);
                }
            }
        }
        throw new RuntimeException("Tidak menemukan method " + namaMethod + " untuk object " +
            args[0]+ " (" + args[0].getClass() + ") dengan argumen " + Arrays.deepToString(args));
    }

    public static Object methodCallReturnSelf(String namaMethod, Object[] args) {
        methodCall(namaMethod, args);
        return args[0];
    }

    public static CallSite constructorBootstrap(MethodHandles.Lookup lookup, String name, MethodType type, String namaClass) throws Exception {
        return new ConstantCallSite(CONSTRUCTOR.bindTo(namaClass).asCollector(Object[].class, type.parameterCount()).asType(type));
    }

    public static CallSite methodCallBootstrap(MethodHandles.Lookup lookup, String name, MethodType type,
           String namaMethod, int returnSelf) throws Exception {
        if (returnSelf==1) {
            return new ConstantCallSite(METHODCALL_RETURNSELF.bindTo(namaMethod).
                asCollector(Object[].class, type.parameterCount()).asType(type));
        } else {
            return new ConstantCallSite(METHODCALL.bindTo(namaMethod).
                asCollector(Object[].class, type.parameterCount()).asType(type));
        }
    }
}
