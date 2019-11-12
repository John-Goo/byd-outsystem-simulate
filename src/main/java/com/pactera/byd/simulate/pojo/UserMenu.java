package com.pactera.byd.simulate.pojo;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userMenu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMenu {

    // 员工号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StaffCode;

    // 菜单编号或菜单ID
    private String menuCode;

    // 系统编号
    private String systemCode;

    // 菜单名称
    private String MenuName;

    public UserMenu(Object[] values) {
        // 员工账号	菜单编号	系统编号	菜单名称
        this.systemCode = values[1].toString();
        this.menuCode = values[2].toString();
        this.systemCode = values[3].toString();
        this.MenuName = values[4].toString();
    }
}
