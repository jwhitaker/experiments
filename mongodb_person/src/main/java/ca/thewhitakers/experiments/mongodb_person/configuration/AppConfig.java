package ca.thewhitakers.experiments.mongodb_person.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
@ComponentScan(basePackages = "ca.thewhitakers")
@ImportResource(value = {"classpath:*-config.xml"})
public class AppConfig {
	private @Value("${mongodb.host}") String host;
	private @Value("${mongodb.db}") String db;
	
	public @Bean Mongo mongo() throws Exception {
		return new Mongo(host);
	}
	
	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), db);
	}
}
