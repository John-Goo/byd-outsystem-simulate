package com.pactera.byd.simulate.controller;

import com.pactera.byd.simulate.common.Result;
import com.pactera.byd.simulate.common.ResultCode;
import com.pactera.byd.simulate.pojo.UserMenu;
import com.pactera.byd.simulate.service.UserMenuService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserMenuController {

    @Autowired
    private UserMenuService userMenuService;

    private String menuCode;
    private String systemCode;
    private String MenuName;

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Result importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        // 解析Excel
        // 根据Excel文件创建工作簿
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        // 获取Sheet
        Sheet sheet = wb.getSheetAt(0);
        // 获取Sheet中的每一行，和每一个单元格
        List<UserMenu> list = new ArrayList<UserMenu>();
        System.out.println(sheet.getLastRowNum());
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);//根据索引获取每一个行
            Object[] values = new Object[row.getLastCellNum()];
            for (int cellNum = 1; cellNum < row.getLastCellNum(); cellNum++) {
                Cell cell = row.getCell(cellNum);
                Object value = getCellValue(cell);
                values[cellNum] = value;
            }
            UserMenu userMenu = new UserMenu(values);
            list.add(userMenu);
        }
        // 保存
        userMenuService.saveAll(list, menuCode, systemCode, MenuName);
        return new Result(ResultCode.SUCCESS);
    }

    public static Object getCellValue(Cell cell) {
        //1.获取到单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    //日期格式
                    value = cell.getDateCellValue();
                } else {
                    //数字
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA: //公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }
}
