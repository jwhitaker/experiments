package ca.thewhitakers.customvalidator.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import ca.thewhitakers.customvalidator.validators.CheckRequestTypeBusinessRulesValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckRequestTypeBusinessRulesValidator.class)
@Documented
public @interface CheckRequestTypeBusinessRules {

	String message() default "{ca.thewhitakers.customvalidator.requesttype}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	boolean checkAllBusinessRules() default false;
}
