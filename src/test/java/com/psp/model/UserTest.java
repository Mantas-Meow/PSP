package com.psp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.psp.exceptions.BadEmailException;

class UserTest {

	@Test
    void userFields_AreSetGetCorrectly_FielsShouldBeEqual()
    {
        User u = new User("Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        assertAll(
                () -> assertEquals("Name", u.getName()),
                () -> assertEquals("Surname", u.getSurname()),
                () -> assertEquals("+37060000000", u.getPhoneNumber()),
                () -> assertEquals("email@gmail.com", u.getEmail()),
                () -> assertEquals("Ukmerges g. 6", u.getAddress()),
                () -> assertEquals("PassWord123$%", u.getPassword())
        );
    }
	
	@Test
    void compareUsers_UsersShouldBeEqual()
    {
        User u1 = new User("Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        User u2 = new User("Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");

        assertTrue(u1.equals(u2));
    }
	
	@Test
    void compareUsers_UsersShouldNotBeEqual()
    {
        User u1 = new User("Name", "Surname", "+37061111111", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");
        User u2 = new User("Name", "Surname", "+37060000000", "email@gmail.com", "Ukmerges g. 6", "PassWord123$%");

        assertFalse(u1.equals(u2));
    }
	
	@Test
    void phoneNumberValid_ShouldBeTrue() throws IOException
    {
        User u = new User();
        assertTrue(u.isPhoneNumberValid("+37061111111"));
    }
	
    @Test
    void phoneNumberValid_ShouldBeFalse() throws IOException
    {
        User u = new User();
        assertFalse(u.isPhoneNumberValid("abc"));
    }

    @Test
    void emailValid_ShouldBeTrue() throws IOException
    {
        User u = new User();
        assertTrue(u.isEmailValid("email@gmail.com"));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", "emailgmail.com", "email@."})
    void emailValid_Tests_ShouldBeFalse(String email) throws IOException
    {
        User u = new User();
        assertThrows(BadEmailException.class, () -> u.isEmailValid(email));
    }

    @Test
    void passwordValid_ShouldBeTrue() throws IOException
    {
        User u = new User();
        assertTrue(u.isPasswordValid("PassWord123$%"));
    }
    
    @Test
    void passwordValid_ShouldBeFalse() throws IOException
    {
        User u = new User();
        assertFalse(u.isPasswordValid("abcd"));
    }

}
