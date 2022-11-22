package ru.vladimirkokourov.streams_io.user_io_csv_app.exception;

public class UserAlreadyExistException extends RuntimeException {

    private final int id;

    public UserAlreadyExistException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
