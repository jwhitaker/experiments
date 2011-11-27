package ca.thewhitakers.customvalidator.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.thewhitakers.customvalidator.annotations.CheckRequestTypeBusinessRules;
import ca.thewhitakers.customvalidator.domain.AbsenceRequest;
import ca.thewhitakers.customvalidator.domain.RequestTypeBusinessRuleManager;
import ca.thewhitakers.customvalidator.domain.businessrules.BusinessRule;

@Component
public class CheckRequestTypeBusinessRulesValidator implements
		ConstraintValidator<CheckRequestTypeBusinessRules, AbsenceRequest> {
	private static final Log log = LogFactory
			.getLog(CheckRequestTypeBusinessRulesValidator.class);

	@Autowired
	private RequestTypeBusinessRuleManager businessRuleManager;

	public void initialize(CheckRequestTypeBusinessRules constraintAnnotation) {
	}

	public boolean isValid(AbsenceRequest value,
			ConstraintValidatorContext context) {
		if (value != null) {

			List<BusinessRule> businessRules = businessRuleManager
					.getBusinessRules(value.getRequestType());

			if (businessRules != null) {
				for (BusinessRule rule : businessRules) {
					if (!rule.isValid(value, context)) {
						return false;
					}
				}
			}

			return true;
		}

		return false;
	}

	public RequestTypeBusinessRuleManager getBusinessRuleManager() {
		return businessRuleManager;
	}

	public void setBusinessRuleManager(
			RequestTypeBusinessRuleManager businessRuleManager) {
		this.businessRuleManager = businessRuleManager;
	}
}