package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validation.Validator;

class PasswordCheckerTests {

	Validator validator;

	@BeforeEach
	void setUp() {
		validator  = new Validator();
	}
	
	@Test
	void passwordValidator_passwordTooShort_shouldReturnFalse() {
		String password = "123";
		boolean valid = validator.validatePassword(password);
		assertFalse(valid);
	}
	
	@Test
	void passwordValidator_hasAnUppercase_shouldReturnTrue() {
		String password = "Password";
		boolean valid = validator.validatePassword(password);
		assertTrue(valid);
	}
	
	@Test
	void passwordValidator_hasAnUppercase_shouldReturnFalse() {
		String password = "password";
		boolean valid = validator.validatePassword(password);
		assertFalse(valid);
	}
	
	@Test
	void passwordValidator_hasSpecialCharacters_shouldReturnTrue() {
		String password = "Password$";
		boolean valid = validator.validatePassword(password);
		assertTrue(valid);
	}
	
	@Test
	void passwordValidator_hasSpecialCharacters_shouldReturnFalse() {
		String password = "Password";
		boolean valid = validator.validatePassword(password);
		assertFalse(valid);
	}
}
