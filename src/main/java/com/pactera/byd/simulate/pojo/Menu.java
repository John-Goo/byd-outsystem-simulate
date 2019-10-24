package com.pactera.byd.simulate.pojo;

public class Menu {
    // 系统编号
    private String systemCode;
    // 系统名称
    private String systemName;
    // 1级模块名称
    private String module1Name;
    // 1级模块编号
    private String module1Code;
    // 2级模块名称
    private String module2Name;
    // 2级模块编号
    private String module2Code;
    // 菜单名称
    private String MenuName;
    // 菜单编号
    private String menuCode;
    // 菜单URL
    private String urlPath;

    public Menu() {

    }

    public Menu(String systemCode, String systemName, String module1Name, String module1Code, String module2Name, String module2Code, String menuName, String menuCode, String urlPath) {
        this.systemCode = systemCode;
        this.systemName = systemName;
        this.module1Name = module1Name;
        this.module1Code = module1Code;
        this.module2Name = module2Name;
        this.module2Code = module2Code;
        MenuName = menuName;
        this.menuCode = menuCode;
        this.urlPath = urlPath;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModule1Name() {
        return module1Name;
    }

    public void setModule1Name(String module1Name) {
        this.module1Name = module1Name;
    }

    public String getModule1Code() {
        return module1Code;
    }

    public void setModule1Code(String module1Code) {
        this.module1Code = module1Code;
    }

    public String getModule2Name() {
        return module2Name;
    }

    public void setModule2Name(String module2Name) {
        this.module2Name = module2Name;
    }

    public String getModule2Code() {
        return module2Code;
    }

    public void setModule2Code(String module2Code) {
        this.module2Code = module2Code;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
