package com.github.takotakot.password.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

@Constraint(validatedBy = {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER,  ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Pattern.List({@Pattern(regexp = ".*[a-z].*", message = "Lowercase letters required"),
        @Pattern(regexp = ".*[A-Z].*", message = "Uppercase letters required"),
        @Pattern(regexp = "[a-zA-Z]{8,}", message = "At least 8 letters required")})
public @interface AlphabeticPassword {
    String message() default "Password does not meet requirements";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
