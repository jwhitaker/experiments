package ca.thewhitakers.experiments.mongodb_person.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ca.thewhitakers.experiments.mongodb_person.domain.model.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {

}
