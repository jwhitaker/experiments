package ca.thewhitakers.customvalidator.domain.businessrules;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.thewhitakers.customvalidator.domain.AbsenceRequest;

public class AnotherDynamicBusinessRule implements BusinessRule {
	private static final Log log = LogFactory.getLog(AnotherDynamicBusinessRule.class);

	public boolean isValid(AbsenceRequest request,
			ConstraintValidatorContext context) {
		
		log.info("Calling isValid in AnotherDynamicBusinessRule");
		
		return true;
	}

}
