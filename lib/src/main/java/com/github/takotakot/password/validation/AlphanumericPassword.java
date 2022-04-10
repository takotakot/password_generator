package com.github.takotakot.password.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;

@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Pattern.List({@Pattern(regexp = ".*[a-z].*", message = "Lowercase letters required"),
        @Pattern(regexp = ".*[A-Z].*", message = "Uppercase letters required"),
        @Pattern(regexp = ".*[0-9].*", message = "Numeric letters required"),
        @Pattern(regexp = "[a-zA-Z0-9]{8,}", message = "At least 8 letters required")})
public @interface AlphanumericPassword {
    String message() default "Password does not meet requirements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
