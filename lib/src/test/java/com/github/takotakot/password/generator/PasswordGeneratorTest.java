package com.github.takotakot.password.generator;

import java.util.Arrays;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import com.github.takotakot.password.validation.AlphabeticPassword;
import com.github.takotakot.password.validation.AlphanumericPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

    private Validator validator;

    @BeforeEach
    public void prep() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void shouldGenerateAlphanumericPassword() {
        String password = PasswordGenerator.generateAlphanumeric(8);
        System.err.println(password);
        var container = new AlphanumericContainer(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertEquals(0, constraintViolations.size());
    }

    @Test
    public void shouldGenerateAlphabeticPassword() {
        String password = PasswordGenerator.generateAlphabetic(8);
        System.err.println(password);
        var container = new AlphabeticContainer(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertEquals(0, constraintViolations.size());
    }

    @Test
    public void shouldGenerateCustomPassword() {
        String password = PasswordGenerator.generateCustom(12,
                Arrays.asList(SecureRandomCharacterStream.LOWERCASE_LETTERS,
                        SecureRandomCharacterStream.UPPERCASE_LETTERS,
                        SecureRandomCharacterStream.NUMERIC_LETTERS,
                        new char[] {'#'}, new char[] {'%'}));
        System.err.println(password);
        Assertions.assertTrue(password.contains("#"));
        Assertions.assertTrue(password.contains("%"));
        Assertions.assertFalse(password.contains("&"));
    }

    private static class AlphanumericContainer {
        @AlphanumericPassword
        String password;

        public AlphanumericContainer(String password) {
            this.password = password;
        }

    }

    private static class AlphabeticContainer {
        @AlphabeticPassword
        String password;

        public AlphabeticContainer(String password) {
            this.password = password;
        }

    }

}
