package com.yash.wh.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.wh.model.*;


public interface partsrepo extends JpaRepository<parts, Integer>
{
	List<parts> findByPquantityGreaterThan(int pquantity);
}
