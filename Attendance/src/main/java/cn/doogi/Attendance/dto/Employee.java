package cn.doogi.Attendance.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "T_EMPLOYEE") // This tells Hibernate to make a table out of this class
public class Employee {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id;
	
	public Employee()
	{
		
	}

	@Id
	private String employee_id;								
	private Date employee_start_date;									
	private String dept_id;									
	private String employee_name;									
	private String employee_gender;									
	private int employee_age;								
	private String employee_enrollment;									
	private String employee_email;
	
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Date getEmployee_start_date() {
		return employee_start_date;
	}
	public void setEmployee_start_date(Date employee_start_date) {
		this.employee_start_date = employee_start_date;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_gender() {
		return employee_gender;
	}
	public void setEmployee_gender(String employee_gender) {
		this.employee_gender = employee_gender;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
	public String getEmployee_enrollment() {
		return employee_enrollment;
	}
	public void setEmployee_enrollment(String employee_enrollment) {
		this.employee_enrollment = employee_enrollment;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}									

	

}
