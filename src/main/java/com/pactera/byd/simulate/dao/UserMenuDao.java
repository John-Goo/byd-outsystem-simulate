package com.pactera.byd.simulate.dao;

import com.pactera.byd.simulate.pojo.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMenuDao extends JpaRepository<UserMenu, String> {

}
