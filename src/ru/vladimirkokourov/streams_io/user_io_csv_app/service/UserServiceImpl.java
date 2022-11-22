package ru.vladimirkokourov.streams_io.user_io_csv_app.service;

import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserAlreadyExistException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserNotFoundException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (userRepository.findById(user.getId()) != null) {
            throw new UserAlreadyExistException("User already exist with id: " + user.getId(), user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found with id: " + id, id);
        }
        return user;
    }

    @Override
    public boolean deleteById(int id) {
        return userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        if (findById(user.getId()) == null) {
            throw new UserNotFoundException("User not found with id: " + user.getId(), user.getId());
        }
        userRepository.deleteById(user.getId());
        return userRepository.save(user);
    }
}
