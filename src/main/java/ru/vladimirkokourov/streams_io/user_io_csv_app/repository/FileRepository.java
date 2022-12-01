package ru.vladimirkokourov.streams_io.user_io_csv_app.repository;

import ru.vladimirkokourov.streams_io.user_io_csv_app.mapper.UserMapper;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileRepository  {

    private static final String HEADER = "Id,Name,Age";

    private final File file;
    private final UserMapper userMapper;

    public FileRepository(File file, UserMapper userMapper) {
        this.file = file;
        this.userMapper = userMapper;
        try {
            Files.writeString(file.toPath(), HEADER, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAll(List<User> userList) {
        String result = HEADER + userMapper.toString(userList);
        try {
            Files.writeString(file.toPath(), result, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User save(User user) {
        List<String> stringList = new ArrayList<>();
        try {
            stringList = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringList.remove(0);
        List<User> userList = userMapper.toUserList(stringList);
        userList.add(user);
        saveAll(userList);

        return user;
    }

    public List<User> findAll() {
        List<String> list = new ArrayList<>();

        try {
            list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            list.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userMapper.toUserList(list);
    }

    public Optional<User> findById(int id) {
        List<User> userList = findAll();

        for (User user : userList) {
            if (user.getId() == id) {
                return Optional.of(new User(user.getId(), user.getName(), user.getAge()));
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(int id) {
        boolean result;
        List<User> userList = findAll();
        result = userList.removeIf(user -> user.getId() == id);
        saveAll(userList);
        return result;
    }
}
