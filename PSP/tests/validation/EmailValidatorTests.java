package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import validation.Validator;

class EmailValidatorTests {

	Validator validator;

	@BeforeEach
	void setUp() {
		validator  = new Validator();
	}
	
	@Test
	void emailValidator_emptyEmail_shouldReturnFalse() {
		String email = "";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_emptyEmailBeforeAt_shouldReturnFalse() {
		String email = "@gmail.com";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasAtSymbol_shouldReturnFalse() {
		String email = "test.com";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasAtSymbol_shouldReturnTrue() {
		String email = "test@.com";
		boolean valid = validator.validateEmail(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasIllegalSymbol_shouldReturnFalse() {
		String email = "test@gmail.com";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasIllegalSymbol_shouldReturnTrue() {
		String email = "t*st@gmail.com";
		boolean valid = validator.validateEmail(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasCorrectDomain_shouldReturnTrue() {
		String email = "test@gmail.com";
		boolean valid = validator.validateEmail(email);
		assertTrue(valid);
	}
	
	@Test
	void emailValidator_hasCorrectDomain_shouldReturnFalse() {
		String email = "test@.com";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasCorrectTopDomain_shouldReturnFalse() {
		String email = "test@gmail.compr";
		boolean valid = validator.validateEmail(email);
		assertFalse(valid);
	}
	
	@Test
	void emailValidator_hasCorrectTopDomain_shouldReturnTrue() {
		String email = "test@.com";
		boolean valid = validator.validateEmail(email);
		assertTrue(valid);
	}
}
