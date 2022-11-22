package ru.vladimirkokourov.streams_io.user_io_csv_app.repository;

import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.utils.Mapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String PATH = "user.csv";
    private static final String HEADER = "Id,Name,Age";

    private final File file;

    public UserRepository() {
        this.file = new File(PATH);
        try {
            if (file.exists()) {
                Files.delete(file.toPath());
            }
            if ((file.createNewFile())) {
                System.out.println("File created");
            }
            Files.writeString(file.toPath(), HEADER, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAll(List<User> userList) {
        String result = HEADER + Mapper.toString(userList);
        try {
            Files.writeString(file.toPath(), result, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User save(User user) {
        if (user == null) {
            throw new NullPointerException("User is null");
        }

        List<String> stringList = new ArrayList<>();
        try {
            stringList = Files.readAllLines(file.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringList.remove(0);
        List<User> userList = Mapper.toUserList(stringList);
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
        return Mapper.toUserList(list);
    }

    public User findById(int id) {
        List<User> userList = findAll();
        for (User user : userList) {
            if (user.getId() == id) {
                return new User(user.getId(), user.getName(), user.getAge());
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        boolean result;
        List<User> userList = findAll();
        result = userList.removeIf(user -> user.getId() == id);
        saveAll(userList);
        return result;
    }
}
