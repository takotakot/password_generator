package com.github.takotakot.password.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AlphabeticPasswordTest {

    private Validator validator;

    @BeforeEach
    public void prep() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aBCDEFGH", "ABCDefghIJ"})
    public void shouldMeetRequirements(String password) {
        var container = new Container(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertEquals(0, constraintViolations.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aB", "abcdefgh", "ABCDEFGH", "12345678", "abcd5678", "ABCD5678", "ABCDefghIJ "})
    public void shouldNotMeetRequirements(String password) {
        var container = new Container(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertNotEquals(0, constraintViolations.size());
    }

    private static class Container {
        @AlphabeticPassword
        String password;

        public Container(String password) {
            this.password = password;
        }

    }

}
