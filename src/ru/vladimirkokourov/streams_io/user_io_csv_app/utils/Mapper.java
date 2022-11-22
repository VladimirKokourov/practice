package ru.vladimirkokourov.streams_io.user_io_csv_app.utils;

import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    private Mapper() {
        throw new IllegalStateException("Utility class");
    }

    public static User toUser(String str) {
        if (str.isEmpty()) {
            return null;
        }
        String[] arr = str.split(",");
        return new User(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
    }

    public static String toString(User user) {
        if (user == null) {
            return "";
        }
        return "\n" + user.getId() +
                "," +
                user.getName() +
                "," +
                user.getAge()
                ;
    }

    public static String toString(List<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(Mapper.toString(user));
        }
        return sb.toString();
    }

    public static List<User> toUserList(List<String> strings) {
        return new ArrayList<>(
                strings.stream()
                        .map(Mapper::toUser)
                        .collect(Collectors.toList())
        );
    }
}
