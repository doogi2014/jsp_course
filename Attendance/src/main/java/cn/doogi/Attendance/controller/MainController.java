package cn.doogi.Attendance.controller;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.doogi.Attendance.dto.Employee;
import cn.doogi.Attendance.param.EmployeeParam;
import cn.doogi.Attendance.repository.EmployeeRepository;
import cn.doogi.Attendance.repository.EmployeeRepositoryOwn;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRepositoryOwn employeeRepository2;

	@GetMapping(path="/")
	public String index(Model model) {
		// This returns a JSON or XML with the users
//		List<Employee> list =new ArrayList<Employee>();
//		for (int i = 0; i < 20; i++) {
//			Employee employee1 =new Employee();
//			employee1.setEmployee_name("zhangsan");
//			employee1.setEmployee_age(34);
//			Employee employee2 =new Employee();
//			employee2.setEmployee_name("lisi");
//			employee2.setEmployee_age(38);
//			Employee employee3 =new Employee();
//			employee3.setEmployee_name("wangwu");
//			employee3.setEmployee_age(26);
//			
//			list.add(employee1);
//			list.add(employee2);
//			list.add(employee3);
//		}
		
		List<Employee> list = (List<Employee>) employeeRepository.findAll();	

		//从后台向前台传值
//		model.addAttribute("num",101);
//		model.addAttribute("name","lisi");
		model.addAttribute("employees",list);
		return "index";
	}
	
	@PostMapping(path="/login")
	public @ResponseBody String login(@RequestBody @Validated EmployeeParam param) {
		
		List<Employee> list = employeeRepository.checkEmployee(param.getId(), param.getPassword());
		list.get(0);
		
		return "login ok";
	}
	
	@PostMapping(path="/search")
	public String search(@ModelAttribute EmployeeParam param,Model model) {
		Specification<Employee> specification = new Specification<Employee>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				List<Predicate> predicates = new LinkedList<>();
				
				String eid = param.getEmployee_id();
				if(eid != null && eid.length()>0) {
					predicates.add(cb.equal(root.get("employee_id"), eid));
				}
				
				String dep = param.getDept_id();
				if(dep != null && dep.length()>0) {
					predicates.add(cb.equal(root.get("dept_id"), dep));
				}
				
				String enr = param.getEmployee_enrollment();
				if(enr != null && enr.length()>0) {
					predicates.add(cb.equal(root.get("employee_enrollment"), "1"));
				}
				
				String employee_start_date_b = param.getEmployee_start_date_b();
				String employee_start_date_e = param.getEmployee_start_date_e();
				if(employee_start_date_b != null && employee_start_date_b.length()>0 && employee_start_date_e != null && employee_start_date_e.length()>0) {
					Date beginDate = java.sql.Date.valueOf(employee_start_date_b);
					Date endDate = java.sql.Date.valueOf(employee_start_date_e);
					predicates.add(cb.between(root.get("employee_start_date"),beginDate, endDate));
				}

				return query.where(predicates.toArray(new Predicate[0])).getRestriction();
			}
        };
        
        List<Employee> list = employeeRepository2.findAll(specification);
        model.addAttribute("employees",list);
		return "index";
	}
	
	@PostMapping(path="/testform")
	public @ResponseBody String testform(@ModelAttribute EmployeeParam param) {
		return "login ok";
	}
	
	@PostMapping(path="/testform2")
	public @ResponseBody String testform2(@RequestParam("id") String id) {
		return "login ok";
	}
}
