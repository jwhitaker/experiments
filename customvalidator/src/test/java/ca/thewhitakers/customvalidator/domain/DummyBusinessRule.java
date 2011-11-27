package ca.thewhitakers.customvalidator.domain;

import javax.validation.ConstraintValidatorContext;

import ca.thewhitakers.customvalidator.domain.AbsenceRequest;
import ca.thewhitakers.customvalidator.domain.businessrules.BusinessRule;

public class DummyBusinessRule implements BusinessRule {
	public boolean isValid(AbsenceRequest request,
			ConstraintValidatorContext context) {
		return true;
	}
}
