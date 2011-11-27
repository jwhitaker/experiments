package ca.thewhitakers.customvalidator.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.thewhitakers.customvalidator.domain.businessrules.BusinessRule;

public class RequestTypeBusinessRuleManager {
	private Map<RequestType, List<BusinessRule>> businessRules = new HashMap<RequestType, List<BusinessRule>>();
	
	public void addBusinessRule(RequestType requestType, BusinessRule businessRule) {
		if (!businessRules.containsKey(requestType)) {
			businessRules.put(requestType, new ArrayList<BusinessRule>());
		}
		
		businessRules.get(requestType).add(businessRule);
	}
	
	public List<BusinessRule> getBusinessRules(RequestType requestType) {
		if (businessRules.containsKey(requestType)) {
			return businessRules.get(requestType);
		}
		
		return null;
	}

	public Map<RequestType, List<BusinessRule>> getBusinessRules() {
		return businessRules;
	}

	public void setBusinessRules(Map<RequestType, List<BusinessRule>> businessRules) {
		this.businessRules = businessRules;
	}
}
