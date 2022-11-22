package ru.vladimirkokourov.streams_io.user_io_csv_app;

import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserAlreadyExistException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserNotFoundException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.repository.UserRepository;
import ru.vladimirkokourov.streams_io.user_io_csv_app.service.UserService;
import ru.vladimirkokourov.streams_io.user_io_csv_app.service.UserServiceImpl;

public class UserListApplication {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserServiceImpl(userRepository);

        User user1 = new User(1,"Lina", 25);
        User user2 = new User(2,"Ivan", 34);
        User user3 = new User(3,"Oleg", 31);
        User user = null;

        System.out.println(userService.findAll());
        System.out.println(userService.save(user1));
        try {
            System.out.println(userService.save(user1));
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
        }
        System.out.println(userService.save(user2));
        System.out.println(userService.save(user3));

        try {
            System.out.println(userService.save(user));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println(userService.findAll());
        System.out.println(userService.findById(1));
        try {
            System.out.println(userService.findById(0));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(userService.deleteById(1));
        try {
            System.out.println(userService.deleteById(1));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userService.findAll());

        user3.setAge(40);
        System.out.println(userService.update(user3));
        System.out.println(userService.findById(3));
    }
}
