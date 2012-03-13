package ca.thewhitakers.experiments.mongodb_person.domain.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {
	@Id
	private String id;
	
	@Indexed
	private String name;
	
	@PersistenceConstructor
	public Department(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("name", name)
			.toString();
	}
}
