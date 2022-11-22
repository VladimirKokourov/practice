package ru.vladimirkokourov.streams_io.user_io_csv_app.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserAlreadyExistException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.repository.FileRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UserServiceImplTest {

    //real object
    //Mockito.mock(FileRepository.class);
    //Mockito.spy()
    private final FileRepository fileRepository = Mockito.mock(FileRepository.class);

    private final UserServiceImpl userService = Mockito.spy(new UserServiceImpl(fileRepository));


    @AfterEach
    void afterEach() {
        Mockito.verifyNoMoreInteractions(fileRepository);
    }

    @Test
    void save_ShouldThrowException() {
        User user = new User(1, "s", 1);

        Optional<User> userOptional = Optional.of(user);

        Mockito.when(fileRepository.findById(1)).thenReturn(userOptional);

        Assertions.assertThrows(UserAlreadyExistException.class,
                () -> userService.save(user));

        verify(fileRepository, times(1)).findById(1);
    }

    @Test
    void save_shouldBeSuccess() {
        User user = Mockito.mock(User.class);

        Optional<User> userOptional = Optional.empty();
        Mockito.when(fileRepository.findById(anyInt())).thenReturn(userOptional);
        Mockito.when(fileRepository.save(user)).thenReturn(user);

        User savedUser = userService.save(user);

        verify(fileRepository, times(1)).findById(anyInt());
        verify(fileRepository, times(1)).save(user);

        Assertions.assertEquals(savedUser, user);
    }
}