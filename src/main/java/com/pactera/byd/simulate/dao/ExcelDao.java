package com.pactera.byd.simulate.dao;

import com.pactera.byd.simulate.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExcelDao extends JpaRepository<Menu, String> {


    //List<Menu> saveAll(Menu menu);

    // List<UserMenu> saveAllUserMenu(UserMenu userMenu);
}