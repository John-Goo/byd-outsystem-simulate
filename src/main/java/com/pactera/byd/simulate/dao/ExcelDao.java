package com.pactera.byd.simulate.dao;

import com.pactera.byd.simulate.pojo.Menu;
import com.pactera.byd.simulate.pojo.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcelDao extends JpaRepository<Menu, String> {

    List<Menu> saveAllMenu(Menu menu);

    List<UserMenu> saveAllUserMenu(UserMenu userMenu);
}