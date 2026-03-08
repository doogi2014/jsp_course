package cn.doogi.Attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cn.doogi.Attendance.dto.Employee;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query(value = "select * from t_employee where employee_id = :id and employee_name = :name ",nativeQuery = true)
	List<Employee> checkEmployee(@Param("id") String id, @Param("name") String name);
}
