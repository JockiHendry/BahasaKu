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

public class OperatorBootstrap {

    private static final MethodHandle ARITMATIKA;

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            ARITMATIKA = lookup.findStatic(OperatorBootstrap.class, "aritmatika",
                MethodType.methodType(Object.class, String.class, Object.class, Object.class));
        } catch (Exception ex) {
            throw new Error("Terjadi kesalahan tak terduga [" + ex.getMessage() + "]");
        }
    }

    public static Object aritmatika(String jenisOperator, Object arg1, Object arg2) throws Throwable {
        MethodHandle target;
        try {
            target = MethodHandles.lookup().findStatic(OperatorBootstrap.class, jenisOperator,
                MethodType.methodType(Object.class, arg1.getClass(), arg2.getClass()));
        } catch (Throwable e) {
            target = MethodHandles.lookup().findStatic(OperatorBootstrap.class, jenisOperator,
                    MethodType.genericMethodType(2));
        }
        target.asType(MethodType.genericMethodType(2));
        return target.invokeWithArguments(arg1, arg2);
    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType type) throws NoSuchMethodException, IllegalArgumentException {
        return new ConstantCallSite(ARITMATIKA.bindTo(name).asType(type));
    }

    public static Object tambah(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }

    public static Object tambah(String arg1, String arg2) {
        return arg1 + arg2;
    }

    public static Object tambah(Object arg1, Object arg2) {
        if (arg1.getClass()== String.class || arg2.getClass()==String.class) {
            return new StringBuilder().append(arg1).append(arg2);
        } else {
            throw new IllegalArgumentException("Operator tambah (+) tidak mendukung [" + arg1 + "] dan [" + arg2 + "]");
        }
    }

    public static Object kurang(Integer arg1, Integer arg2) {
        return arg1 - arg2;
    }

    public static Object kurang(String arg1, String arg2) {
        return arg1.replace(arg2, "");
    }

    public static Object kurang(String arg1, Integer arg2) {
        return arg1.substring(0, arg1.length() - arg2);
    }

    public static Object kurang (Object arg1, Object arg2) {
        throw new IllegalArgumentException("Operator kurang (-) tidak mendukung [" + arg1 + "] dan [" + arg2 + "]");
    }

    public static Object kali(Integer arg1, Integer arg2) {
        return arg1 * arg2;
    }

    public static Object kali(String arg1, Integer arg2) {
        StringBuilder builder = new StringBuilder(arg1);
        for (int i=1; i<arg2; i++) {
            builder.append(arg1);
        }
        return builder.toString();
    }

    public static Object kali (Object arg1, Object arg2) {
        throw new IllegalArgumentException("Operator kali (*) tidak mendukung [" + arg1 + "] dan [" + arg2 + "]");
    }

    public static Object bagi(Integer arg1, Integer arg2) {
        return arg1 / arg2;
    }

    public static Object bagi(Object arg1, Object arg2) {
        throw new IllegalArgumentException("Operator bagi (/) tidak mendukung [" + arg1 + "] dan [" + arg2 + "]");
    }

}
