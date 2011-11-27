package ca.thewhitakers.customvalidator.domain.businessrules;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.thewhitakers.customvalidator.domain.AbsenceRequest;

public class SomeDynamicBusinessRule implements BusinessRule {
	private final Log log = LogFactory.getLog(SomeDynamicBusinessRule.class);
	
	private String message;
	
	public SomeDynamicBusinessRule(String message) {
		this.message = message;
	}

	public boolean isValid(AbsenceRequest request, ConstraintValidatorContext context) {
		log.info("Calling isValid in SomeDynamicBusinessRule with a message = " + message);
		
		return true;
	}
}
