package com.pactera.byd.simulate.pojo;

public class UserMenu {

    // 员工号
    private String StaffCode;

    // 菜单编号或菜单ID
    private String menuCode;

    // 系统编号
    private String systemCode;

    // 菜单名称
    private String MenuName;


    public UserMenu() {

    }

    public UserMenu(String staffCode, String menuCode, String systemCode, String menuName) {
        StaffCode = staffCode;
        this.menuCode = menuCode;
        this.systemCode = systemCode;
        MenuName = menuName;
    }

    public UserMenu(String staffCode, String menuCode, String systemCode) {
        StaffCode = staffCode;
        this.menuCode = menuCode;
        this.systemCode = systemCode;
    }

    public String getStaffCode() {
        return StaffCode;
    }

    public void setStaffCode(String staffCode) {
        StaffCode = staffCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }
}
