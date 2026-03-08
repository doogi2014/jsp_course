package cn.doogi.Warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.doogi.Warehouse.dto.Warehouse;


public interface WarehouseRepositoryOwn extends JpaRepository<Warehouse, Long>, JpaSpecificationExecutor<Warehouse> {
	

}