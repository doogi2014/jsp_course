package cn.doogi.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.doogi.Attendance.dto.Employee;


public interface EmployeeRepositoryOwn extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
	

}