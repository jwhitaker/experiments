package ca.thewhitakers.customvalidator.validators;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.thewhitakers.customvalidator.domain.AbsenceRequest;
import ca.thewhitakers.customvalidator.domain.RequestType;
import ca.thewhitakers.customvalidator.domain.RequestTypeBusinessRuleManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestCheckRequestTypeBusinessRulesValidator {
	@Test
	public void testShouldPass() {
		AbsenceRequest request = new AbsenceRequest();
		request.setRequestType(RequestType.TYPE_A);
		
		RequestTypeBusinessRuleManager manager = new RequestTypeBusinessRuleManager();
		
		CheckRequestTypeBusinessRulesValidator validator = new CheckRequestTypeBusinessRulesValidator();
		validator.setBusinessRuleManager(manager);
		
		Assert.assertTrue(validator.isValid(request, null));
	}
}
