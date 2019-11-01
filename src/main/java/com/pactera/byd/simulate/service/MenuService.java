package com.pactera.byd.simulate.service;

import com.pactera.byd.simulate.dao.MenuDao;
import com.pactera.byd.simulate.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    @Transactional
    public void save(List<Menu> list) {
        for (Menu menu : list) {
            // 基本属性：系统编号  系统名称	1级模块名称	1级模块编号	2级模块名称	2级模块编号	菜单名称	菜单编号	菜单URL
            menu.setSystemCode(menu.getSystemCode());
            menu.setSystemName(menu.getSystemName());
            menu.setModule1Name(menu.getModule1Name());
            menu.setModule1Code(menu.getModule1Code());
            menu.setModule2Name(menu.getModule2Name());
            menu.setModule2Code(menu.getModule2Code());
            menu.setMenuName(menu.getMenuName());
            menu.setMenuCode(menu.getMenuCode());
            menu.setUrlPath(menu.getUrlPath());
            menuDao.save(menu);
        }
    }
}