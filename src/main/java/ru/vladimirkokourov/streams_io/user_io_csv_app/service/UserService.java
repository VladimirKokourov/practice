package ru.vladimirkokourov.streams_io.user_io_csv_app.service;

import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    boolean deleteById(int id);
    User update(User user);
}
