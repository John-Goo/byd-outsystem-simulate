package com.pactera.byd.simulate.service;

import com.pactera.byd.simulate.dao.UserMenuDao;
import com.pactera.byd.simulate.pojo.UserMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserMenuService {

    @Autowired
    private UserMenuDao userMenuDao;

    @Transactional
    public void saveAll(List<UserMenu> list, String menuCode, String systemCode, String MenuName) {
        for (UserMenu userMenu : list) {
            // 员工账号	菜单编号	系统编号	菜单名称
            userMenu.setMenuName(MenuName);
            userMenu.setSystemCode(systemCode);
            userMenu.setMenuCode(menuCode);
            userMenuDao.save(userMenu);
        }
    }
}

