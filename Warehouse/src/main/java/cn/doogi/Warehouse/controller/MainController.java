package cn.doogi.Warehouse.controller;

import java.sql.Date;
import java.time.chrono.IsoChronology;
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

import cn.doogi.Warehouse.dto.Warehouse;
import cn.doogi.Warehouse.repository.WarehouseRepository;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private WarehouseRepository warehouseRepository;

	@GetMapping(path="/")
	public String index(Model model) {
		List<Warehouse> list = (List<Warehouse>) warehouseRepository.findById("0000000002");
		Warehouse warehouse = list.get(0);

		model.addAttribute("warehouse",warehouse);
		return "index";
	}
	
	@PostMapping(path="/search")
	public String testform(@RequestParam("warehouse_id") String warehouse_id,@RequestParam("warehouse_name") String warehouse_name,@RequestParam("warehouse_unit") String warehouse_unit,@RequestParam("warehouse_remarks") String warehouse_remarks,Model model) 
	{
		List<Warehouse> list = (List<Warehouse>) warehouseRepository.findById(warehouse_id);
		Warehouse warehouse = list.get(0);
		warehouse.setName(warehouse_name);
		warehouse.setUnit(warehouse_unit);
		warehouse.setRemarks(warehouse_remarks);
		warehouse.setCreate_date(new java.util.Date());
		warehouseRepository.save(warehouse);
		
		model.addAttribute("warehouse",warehouse);
		return "index";
	}
}
