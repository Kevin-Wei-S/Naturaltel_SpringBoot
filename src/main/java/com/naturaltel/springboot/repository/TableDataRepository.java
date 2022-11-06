package com.naturaltel.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naturaltel.springboot.pojo.TableData;

public interface TableDataRepository extends JpaRepository<TableData, Integer> {

}
