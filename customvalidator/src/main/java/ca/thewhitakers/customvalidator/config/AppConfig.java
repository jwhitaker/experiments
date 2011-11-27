package ca.thewhitakers.customvalidator.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import ca.thewhitakers.customvalidator.domain.RequestType;
import ca.thewhitakers.customvalidator.domain.RequestTypeBusinessRuleManager;
import ca.thewhitakers.customvalidator.domain.businessrules.AnotherDynamicBusinessRule;
import ca.thewhitakers.customvalidator.domain.businessrules.BusinessRule;
import ca.thewhitakers.customvalidator.domain.businessrules.SomeDynamicBusinessRule;

@Configuration
public class AppConfig {
	@Bean
	public RequestTypeBusinessRuleManager businessRuleManager() {
		RequestTypeBusinessRuleManager manager = new RequestTypeBusinessRuleManager();
		
		manager.getBusinessRules().put(RequestType.TYPE_A, typeABusinessRules());
		manager.getBusinessRules().put(RequestType.TYPE_B, typeBBusinessRules());
		
		return manager;
	}

	@Bean
	public List<BusinessRule> typeABusinessRules() {
		List<BusinessRule> businessRules = new ArrayList<BusinessRule>();
		businessRules.add(new SomeDynamicBusinessRule("Type A - Rule 1"));
		businessRules.add(new AnotherDynamicBusinessRule());
		
		return businessRules;
	}
	
	@Bean
	public List<BusinessRule> typeBBusinessRules() {
		List<BusinessRule> businessRules = new ArrayList<BusinessRule>();
		businessRules.add(new SomeDynamicBusinessRule("Type B - Rule 1"));
		
		return businessRules;
	}
	
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
