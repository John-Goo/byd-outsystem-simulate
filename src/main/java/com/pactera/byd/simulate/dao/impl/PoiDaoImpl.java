package com.pactera.byd.simulate.dao.impl;

import com.pactera.byd.simulate.dao.PoiDao;
import com.pactera.byd.simulate.pojo.Menu;
import com.pactera.byd.simulate.pojo.UserMenu;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class PoiDaoImpl implements PoiDao {
    @Override
    public List<Menu> getMenus() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Menu m1 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "用户管理", "WMS_BASE_CODE_USER", "用户查看", "USER_DTAIL_VIEW", "pp/detail.html");
        Menu m2 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "日志管理", "WMS_BASE_CODE_LOG", "登录日志查看", "LOGIN_LOG_VIEW", "pp/logview.html");
        Menu m3 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "库存管理", "WMS_BASE_CODE_KUCUN ", "采购清单", "3", "pp/detail.html");
        Menu m4 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "用户管理", "WMS_BASE_CODE_USER", "产品列表", "3", "sms/list.html");
        Menu m5 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "日志管理", "WMS_BASE_CODE_LOG", "产品清单", "2", "sms/detail.html");
        Menu m6 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "库存管理", "WMS_BASE_CODE_KUCUN", "产品修改", "1", "sms/modify.html");
        Menu m7 = new Menu("WMS001", "一部分WMS", "基础信息", "WMS_BASE_CODE", "用户管理", "WMS_BASE_CODE_USER", "产品删除", "1", "sms/del.html");

        List<Menu> menuList = new ArrayList<>();

        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        menuList.add(m4);
        menuList.add(m5);
        menuList.add(m6);
        menuList.add(m7);

        return menuList;
    }

    @Override
    public List<UserMenu> getUserMenus() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UserMenu um1 = new UserMenu("1001", "USER_DTAIL_VIEW", "WMS001", "用户查看");
        UserMenu um2 = new UserMenu("1002", "LOGIN_LOG_VIEW", "WMS002", "登录日志查看");
        UserMenu um3 = new UserMenu("1003", "3", "WMS003", "采购清单");
        UserMenu um4 = new UserMenu("1004", "3", "WMS004", "产品列表");
        UserMenu um5 = new UserMenu("1005", "2", "WMS005", "产品清单");
        UserMenu um6 = new UserMenu("1006", "1", "WMS006", "产品修改");
        UserMenu um7 = new UserMenu("1007", "1", "WMS007", "产品删除");

        List<UserMenu> userMenuList = new ArrayList<>();
        userMenuList.add(um1);
        userMenuList.add(um2);
        userMenuList.add(um3);
        userMenuList.add(um4);
        userMenuList.add(um5);
        userMenuList.add(um6);
        userMenuList.add(um7);

        return userMenuList;
    }
}
