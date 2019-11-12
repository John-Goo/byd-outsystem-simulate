package com.pactera.byd.simulate.service;

import com.pactera.byd.simulate.dao.ExcelDao;
import com.pactera.byd.simulate.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelDao excelDao;

    @Transactional
    public void savemenu(List<Menu> list, Menu menu) {
        // List<Menu> list = new ArrayList<>();
        Menu menu1 = new Menu();
        // 系统编号
        menu.setSystemCode(menu1.getSystemCode());
        // 系统名称
        menu.setSystemName(menu1.getSystemName());
        // 一级模块名称
        menu.setModule1Code(menu1.getModule1Code());
        // 一级模块编号
        menu.setModule1Name(menu1.getModule1Name());
        // 二级模块编号
        menu.setModule2Code(menu1.getModule2Code());
        // 二级模块名称
        menu.setModule2Name(menu1.getModule2Name());
        // 菜单名称
        menu.setMenuName(menu1.getMenuName());
        // 菜单编号
        menu.setMenuCode(menu1.getMenuCode());
        // 菜单URL
        menu.setUrlPath(menu1.getUrlPath());
        list.add(menu);
        this.excelDao.saveAll(list);
    }
}