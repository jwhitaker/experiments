package ca.thewhitakers.customvalidator.domain;

public enum RequestType {
	TYPE_A("typeA"),
	TYPE_B("typeB");
	
	private final String type;
	
	RequestType(String type) {
		this.type = type;
	}
	
	public String type() { return type; }
}
