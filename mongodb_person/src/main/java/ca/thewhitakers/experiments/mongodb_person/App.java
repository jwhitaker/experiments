package ca.thewhitakers.experiments.mongodb_person;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ca.thewhitakers.experiments.mongodb_person.configuration.AppConfig;
import ca.thewhitakers.experiments.mongodb_person.domain.model.Department;
import ca.thewhitakers.experiments.mongodb_person.domain.model.Employee;
import ca.thewhitakers.experiments.mongodb_person.persistence.DepartmentRepository;
import ca.thewhitakers.experiments.mongodb_person.persistence.EmployeeRepository;

@Component("application")
public class App {
	private static final Log log = LogFactory.getLog(App.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void run() {
		departmentRepository.deleteAll();
		employeeRepository.deleteAll();
		
		Department d = new Department("Engineering");
		departmentRepository.save(d);
		
		Department d2 = new Department("Engineering");
		departmentRepository.save(d2);
		
		Employee e = new Employee("Jason", "Whitaker");
		e.setDepartment(d);
		employeeRepository.save(e);
		
		log.info(employeeRepository.findOne(e.getId()));
		log.info(employeeRepository.findAll());
		log.info(departmentRepository.findAll());
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		App a = (App)ctx.getBean(App.class);
		a.run();
	}
}
