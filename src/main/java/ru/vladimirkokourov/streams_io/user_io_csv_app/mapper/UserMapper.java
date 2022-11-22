package ru.vladimirkokourov.streams_io.user_io_csv_app.mapper;

import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public User toUser(String str) {
        String[] arr = str.split(",");
        return new User(
                Integer.parseInt(arr[0]),
                arr[1],
                Integer.parseInt(arr[2]));
    }

    public String toString(User user) {
        return "\n" + user.getId() +
                "," +
                user.getName() +
                "," +
                user.getAge()
                ;
    }

    public String toString(List<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(toString(user));
        }
        return sb.toString();
    }

    public List<User> toUserList(List<String> strings) {
        return new ArrayList<>(
                strings.stream()
                        .map(this::toUser)
                        .collect(Collectors.toList())
        );
    }
}
