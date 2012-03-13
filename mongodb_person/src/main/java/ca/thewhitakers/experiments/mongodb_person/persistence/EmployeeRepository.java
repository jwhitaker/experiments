package ca.thewhitakers.experiments.mongodb_person.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ca.thewhitakers.experiments.mongodb_person.domain.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

}
