package ru.vladimirkokourov.streams_io.user_io_csv_app.service;

import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserAlreadyExistException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserNotFoundException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.repository.FileRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final FileRepository fileRepository;

    public UserServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public User save(User user) {
        if (fileRepository.findById(user.getId()).isPresent()) {
            throw new UserAlreadyExistException("User already exist with id: " +
                    user.getId(), user.getId());
        }

        return fileRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id, id));
    }

    @Override
    public boolean deleteById(int id) {
        return fileRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        findById(user.getId());
        fileRepository.deleteById(user.getId());
        return fileRepository.save(user);
    }

}
