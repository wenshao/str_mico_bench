# str_mico_bench

## String Microbenchmark

This project contains microbenchmarks for string operations using JMH (Java Microbenchmark Harness).

## JDK Compatibility

This project is compatible with **Java 8** and higher versions.

## Build

To build the project:

```bash
mvn clean compile
```

To package as an executable JAR:

```bash
mvn clean package
```

## Run Benchmarks

To run the benchmarks:

```bash
java -jar target/benchmarks.jar
```