package com.pactera.byd.simulate.dao;

import com.pactera.byd.simulate.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelDao extends JpaRepository<Menu, String> {
}