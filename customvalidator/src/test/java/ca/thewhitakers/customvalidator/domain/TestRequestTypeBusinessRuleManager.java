package ca.thewhitakers.customvalidator.domain;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.thewhitakers.customvalidator.domain.RequestType;
import ca.thewhitakers.customvalidator.domain.RequestTypeBusinessRuleManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestRequestTypeBusinessRuleManager {
	@Test
	public void shouldAddAndGetBusinessRule() {
		RequestTypeBusinessRuleManager manager = new RequestTypeBusinessRuleManager();
		manager.addBusinessRule(RequestType.TYPE_A, new DummyBusinessRule());
		
		Assert.assertEquals(1, manager.getBusinessRules().size());
		Assert.assertEquals(DummyBusinessRule.class, manager.getBusinessRules(RequestType.TYPE_A).get(0).getClass());
	}
	
	@Test
	public void shouldReturnNullWithNoBusinessRuleList() {
		RequestTypeBusinessRuleManager manager = new RequestTypeBusinessRuleManager();
		
		Assert.assertNull(manager.getBusinessRules(RequestType.TYPE_A));
	}
}
