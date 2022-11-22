package ru.vladimirkokourov.exceptions;

public class MyArraySizeException extends RuntimeException {

    private final int size;

    public int getSize() {
        return size;
    }

    public MyArraySizeException(String message, int size) {
        super(message);
        this.size = size;
    }
}
