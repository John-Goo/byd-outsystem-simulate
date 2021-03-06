package com.pactera.byd.simulate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Menu {
    // 系统编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_code", unique = true, nullable = false)
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

    public Menu(Object[] values) {
        // 系统编号  系统名称	1级模块名称	1级模块编号	2级模块名称	2级模块编号	菜单名称	菜单编号	菜单URL
        this.systemCode = values[1].toString();
        this.systemName = values[2].toString();
        this.module1Name = values[3].toString();
        this.module1Code = values[4].toString();
        this.module2Name = values[5].toString();
        this.module2Code = values[6].toString();
        this.MenuName = values[7].toString();
        this.menuCode = values[8].toString();
        this.urlPath = values[9].toString();
    }
}
