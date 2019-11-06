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
    public void saveMenu(List<Menu> list, Menu menu) {
        for (Menu menu_1 : list) {
            // 系统编号
            menu_1.setSystemCode(menu.getSystemCode());
            // 系统名称
            menu_1.setSystemName(menu.getSystemName());
            // 一级模块名称
            menu_1.setModule1Code(menu.getModule1Code());
            // 一级模块编号
            menu_1.setModule1Name(menu.getModule1Name());
            // 二级模块名称
            menu_1.setModule2Code(menu.getModule2Code());
            // 二级模块编号
            menu_1.setModule2Name(menu.getModule2Name());
            // 菜单名称
            menu_1.setMenuName(menu.getMenuName());
            // 菜单编号
            menu_1.setMenuCode(menu.getMenuCode());
            /// 菜单URL
            menu_1.setUrlPath(menu.getUrlPath());
            excelDao.save(menu_1);
        }
    }

   /* @Transactional
    public void saveAllUserMenu(List<UserMenu> list, UserMenu userMenu) {
        for (UserMenu userMenu_1 : list) {
            // 员工账号
            userMenu_1.setStaffCode(userMenu.getStaffCode());
            // 菜单编号
            userMenu_1.setMenuCode(userMenu.getMenuCode());
            // 系统编号
            userMenu_1.setSystemCode(userMenu.getSystemCode());
            // 菜单名称
            userMenu_1.setMenuName(userMenu.getMenuName());
            menuDao.saveAllUserMenu(userMenu_1);
        }
    }*/
}