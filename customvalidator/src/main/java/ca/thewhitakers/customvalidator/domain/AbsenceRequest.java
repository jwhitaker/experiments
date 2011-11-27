package ca.thewhitakers.customvalidator.domain;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import ca.thewhitakers.customvalidator.annotations.CheckRequestTypeBusinessRules;

@CheckRequestTypeBusinessRules()
public class AbsenceRequest {
	@NotNull
	private RequestType requestType;
	@NotNull
	private DateTime startDate;
	@NotNull
	private DateTime endDate;

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
}
