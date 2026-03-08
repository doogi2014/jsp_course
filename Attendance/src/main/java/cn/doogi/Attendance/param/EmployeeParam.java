package cn.doogi.Attendance.param;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeParam {
	@NotNull
	private String id;
	@NotNull
	private String password;
	
	private String employee_id;								
	private String employee_start_date_b;
	private String employee_start_date_e;
	private String dept_id;	
	private String employee_enrollment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_start_date_b() {
		return employee_start_date_b;
	}
	public void setEmployee_start_date_b(String employee_start_date_b) {
		this.employee_start_date_b = employee_start_date_b;
	}
	public String getEmployee_start_date_e() {
		return employee_start_date_e;
	}
	public void setEmployee_start_date_e(String employee_start_date_e) {
		this.employee_start_date_e = employee_start_date_e;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getEmployee_enrollment() {
		return employee_enrollment;
	}
	public void setEmployee_enrollment(String employee_enrollment) {
		this.employee_enrollment = employee_enrollment;
	}
	
}
