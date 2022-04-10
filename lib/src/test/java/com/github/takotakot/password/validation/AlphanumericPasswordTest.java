package com.github.takotakot.password.validation;

import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AlphanumericPasswordTest {

    private Validator validator;

    @BeforeEach
    public void prep() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aB345678", "aB345678iJ"})
    public void shouldMeetRequirements(String password) {
        Container container = new Container(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertEquals(0, constraintViolations.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aB3", "abcdefgh", "ABCDEFGH", "12345678", "abcdEFGH", "abcd5678",
            "ABCD5678", "aB345678iJ "})
    public void shouldNotMeetRequirements(String password) {
        Container container = new Container(password);
        var constraintViolations = validator.validate(container);
        Assertions.assertNotEquals(0, constraintViolations.size());
    }

    private static class Container {
        @AlphanumericPassword
        String password;

        public Container(String password) {
            this.password = password;
        }
    }

}
