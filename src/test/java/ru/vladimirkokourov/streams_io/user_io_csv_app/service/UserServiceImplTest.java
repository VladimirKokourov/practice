package ru.vladimirkokourov.streams_io.user_io_csv_app.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserAlreadyExistException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.exception.UserNotFoundException;
import ru.vladimirkokourov.streams_io.user_io_csv_app.model.User;
import ru.vladimirkokourov.streams_io.user_io_csv_app.repository.FileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class UserServiceImplTest {

    //real object
    //Mockito.mock(FileRepository.class);
    //Mockito.spy()
    private final FileRepository fileRepository = mock(FileRepository.class);

    private final UserServiceImpl userService = spy(new UserServiceImpl(fileRepository));


    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(fileRepository);
    }

    @Test
    void save_shouldThrowException() {
        User user = new User(1, "s", 1);

        Optional<User> userOptional = Optional.of(user);

        when(fileRepository.findById(1)).thenReturn(userOptional);

        assertThrows(UserAlreadyExistException.class,
                () -> userService.save(user));

        verify(fileRepository).findById(1);
    }

    @Test
    void save_shouldBeSuccess() {
        User user = mock(User.class);

        Optional<User> userOptional = Optional.empty();
        when(fileRepository.findById(anyInt())).thenReturn(userOptional);
        when(fileRepository.save(user)).thenReturn(user);

        User savedUser = userService.save(user);

        verify(fileRepository).findById(anyInt());
        verify(fileRepository).save(user);

        assertEquals(savedUser, user);
    }

    @Test
    void findAll_shouldBeSuccess() {
        List<User> list = new ArrayList<>();
        when(fileRepository.findAll()).thenReturn(list);

        List<User> actual = userService.findAll();

        assertSame(list,actual);

        verify(fileRepository).findAll();
    }

    @Test
    void findById_shouldBeSuccess() {
        User user = new User(1, "s", 1);
        Optional<User> userOptional = Optional.of(user);

        when(fileRepository.findById(1)).thenReturn(userOptional);

        assertEquals(user, userService.findById(1));

        verify(fileRepository).findById(1);
    }

    @Test
    void findById_shouldThrowException() {

        Optional<User> userOptional = Optional.empty();

        when(fileRepository.findById(1)).thenReturn(userOptional);

        assertThrows(UserNotFoundException.class, () -> userService.findById(1));

        verify(fileRepository).findById(1);
    }

    @Test
    void deleteById_shouldBeSuccess() {

        when(fileRepository.deleteById(1)).thenReturn(true);

        assertTrue(userService.deleteById(1));

        verify(fileRepository).deleteById(anyInt());
    }

    @Test
    void update_shouldBeSuccess() {
        User user = new User(1, "s", 1);
        Optional<User> userOptional = Optional.of(user);

        when(fileRepository.findById(1)).thenReturn(userOptional);
        when(fileRepository.deleteById(1)).thenReturn(true);
        when(fileRepository.save(user)).thenReturn(user);

        assertEquals(user, userService.update(user));

        verify(fileRepository).findById(anyInt());
        verify(fileRepository).deleteById(anyInt());
        verify(fileRepository).save(user);
    }
}