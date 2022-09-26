package com.loganima.io.base;

public interface IOProtocol {

    interface IReadable<T extends Object> {
        T readFile(String fileName);
    }

    interface IWritable<T extends Object> {
        void writeFile(T obj, String fileName);
    }
}