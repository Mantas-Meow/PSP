package validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {

    PasswordChecker passwordChecker;
    PhoneValidator phoneValidator;
    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    @Test
    void TestIfPasswordLengthIsAtLeastX() {
    	assertAll(
    	() -> assertTrue(passwordChecker.isAtLeastX("pass12345", 5)),
    	() -> assertFalse(passwordChecker.isAtLeastX("pass", 5))
    	); 
        
    }

    @Test
    void TestIfPasswordHasUppercaseSymbols() {
    	assertAll(
        () -> assertTrue(passwordChecker.hasUppercaseSymbols("Pass12345")),
        () -> assertFalse(passwordChecker.hasUppercaseSymbols("pass12345"))
        );
    }

    @Test
    void TestIfPasswordHasSpecialSymbols() {
    	assertAll(
    	() -> assertTrue(passwordChecker.hasSpecialSymbols("Pass-12345")),
    	() -> assertFalse(passwordChecker.hasSpecialSymbols("Pass12345"))
    	);
        
    }

    @Test
    void TestIfPhoneNumberHasOnlyNumbers() {
    	assertAll(
    		() -> assertTrue(phoneValidator.hasOnlyNumbers("911")),
    		() -> assertFalse(phoneValidator.hasOnlyNumbers("9a11"))
    	);
    }

    @Test
    void TestIfPhoneNumberBeginsWithEight() {
    	assertAll(
    	() -> assertTrue(phoneValidator.beginsWithEight("861122333")),
    	() -> assertFalse(phoneValidator.beginsWithEight("761122333"))
    	);
    }

    @Test
    void TestIfPhoneNumberBelongsToSelectedCountry() {
    	assertAll(
    	() -> assertTrue(phoneValidator.belongsToSelectedCountry("+49301234567")),
    	() -> assertFalse(phoneValidator.belongsToSelectedCountry("+48301234567"))	
    	);
        
    }

    @Test
    void TestIfEmailHasAtSign() {
    	assertAll(
    	() -> assertTrue(emailValidator.hasAtSign("name.surname@gmail.com")),
    	() -> assertFalse(emailValidator.hasAtSign("name.surnamegmail.com"))
    	);        
    }

    @Test
    void TestIfEmailHasInvalidCharacters() {
    	assertAll(
    	    	() -> assertFalse(emailValidator.hasInvalidCharacters("name.surname@gmail.com")),
    	    	() -> assertTrue(emailValidator.hasInvalidCharacters("name.surn[ame@gmail.com"))
    	);
    }

    @Test
    void TestIfEmailHasCorrectDomainAndTLD() {
    	assertAll(
    	    	() -> assertTrue(emailValidator.hasCorrectDomainAndTDL("name.surname@gmail.com")),
    	    	() -> assertFalse(emailValidator.hasCorrectDomainAndTDL("name.surname@gmail.c5m"))
    	);
    }

}
