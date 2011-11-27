package ca.thewhitakers.customvalidator.domain;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestAbsenceRequestValidation {
	@Autowired
	private Validator validator; 
	
	@Test
	public void shouldValidateAbsenceRequest() {
		AbsenceRequest request = new AbsenceRequest();
		request.setRequestType(RequestType.TYPE_A);
		request.setStartDate(DateTime.now());
		request.setEndDate(DateTime.now());
		
		Set<ConstraintViolation<AbsenceRequest>> results = validator.validate(request);

		Assert.assertEquals(0, results.size());
	}
}
