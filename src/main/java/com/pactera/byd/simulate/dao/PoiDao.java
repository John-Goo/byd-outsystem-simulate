package com.pactera.byd.simulate.dao;

import com.pactera.byd.simulate.pojo.Menu;
import com.pactera.byd.simulate.pojo.UserMenu;

import java.util.List;

public interface PoiDao {

    public List<Menu> getMenus();

    public List<UserMenu> getUserMenus();
}
