package com.psp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.psp.Application;
import com.psp.model.User;

@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTest
{
    @Autowired
    private UserService service;

    @Test
    void saveUser_ShouldBeTrue()
    {
    	User u1 = new User(1L, "Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        User added = service.add(u1);
        assertEquals(u1, added);
    }
    
    @Test
    void findById_ShouldBeTrue()
    {
    	User u1 = new User(1L, "Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
    	User u2 = new User(2L, "Surname", "Name", "+37062222222", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        service.add(u1);
        service.add(u2);
        Optional<User> a = service.findUserById(1L);
        User actual = a.get();
        assertEquals(u1, actual);
    }
    @Test
    void deleteUser_ShouldBeTrue()
    {
    	User u1 = new User(1L, "Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
    	User u2 = new User(2L, "Surname", "Name", "+37062222222", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        service.add(u1);
        service.add(u2);
        service.deleteById(1L);
        List<User> actual = service.findAll();

        assertEquals(List.of(u2), actual);
    }
    
    @Test
    void updateUser_ShouldBeTrue()
    {
    	User u1 = new User(1L, "Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        User u2 = new User(1L, "Surname", "Name", "+37062222222", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        service.add(u1);
        service.update(u2);
        Optional<User> a = service.findUserById(1L);
        User actual = a.get();

        assertEquals(u2, actual);
    }
}
