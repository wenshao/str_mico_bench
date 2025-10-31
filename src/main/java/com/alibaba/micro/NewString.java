package com.alibaba.micro;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Fork(value = 1)
public class NewString {
    static byte[] bytes;
    static char[] chars;

    static {
        java.util.Random r = new java.util.Random();
        int len = 1024 + r.nextInt(1024);
        bytes = new byte[len];
        chars = new char[len];

        for (int i = 0; i < bytes.length; i++) {
            byte b = (byte) ('a' + r.nextInt(24));
            bytes[i] = b;
            chars[i] = (char) b;
        }
    }

    @Benchmark
    public String newString_iso88591() {
        return new String(bytes, java.nio.charset.StandardCharsets.ISO_8859_1);
    }

    @Benchmark
    public String newString_utf8() {
        return new String(bytes, java.nio.charset.StandardCharsets.UTF_8);
    }

    @Benchmark
    public String newString_chars() {
        return new String(chars);
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(NewString.class.getName())
                .forks(1)
                .build();
        new Runner(options).run();
    }
}

