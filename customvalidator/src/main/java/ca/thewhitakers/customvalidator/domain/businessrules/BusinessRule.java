package ca.thewhitakers.customvalidator.domain.businessrules;

import javax.validation.ConstraintValidatorContext;

import ca.thewhitakers.customvalidator.domain.AbsenceRequest;

public interface BusinessRule {
	public boolean isValid(AbsenceRequest request, ConstraintValidatorContext context);
}
