package com.pactera.byd.simulate.controller;

import com.pactera.byd.simulate.common.Result;
import com.pactera.byd.simulate.common.ResultCode;
import com.pactera.byd.simulate.pojo.Menu;
import com.pactera.byd.simulate.service.ExcelService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping(value = "/menu/import", method = RequestMethod.POST)
    public Result importExcelByMenu(@RequestParam("file") MultipartFile file, @RequestBody Menu menu) throws Exception {
        // 解析Excel
        // 根据Excel文件创建工作簿
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        // 获取Sheet
        Sheet sheet = wb.getSheetAt(0);
        // 获取Sheet中的每一行，和每一个单元格
        List<Menu> list = new ArrayList<Menu>();
        System.out.println(sheet.getLastRowNum());
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);//根据索引获取每一个行
            Object[] values = new Object[row.getLastCellNum()];
            for (int cellNum = 1; cellNum < row.getLastCellNum(); cellNum++) {
                Cell cell = row.getCell(cellNum);
                Object value = getCellValue(cell);
                values[cellNum] = value;
            }
            Menu menu1 = new Menu(values);
            list.add(menu1);
        }
        // 保存
        excelService.saveMenu(list, menu);
        return new Result(ResultCode.SUCCESS);
    }

   /* @RequestMapping(value = "/userMenu/import", method = RequestMethod.POST)
    public Result importExcelByUserMenu(@RequestParam("file") MultipartFile file, @RequestBody UserMenu userMenu) throws Exception {
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
            UserMenu userMenu1 = new UserMenu(values);
            list.add(userMenu1);
        }
        // 保存
        excelService.saveAllUserMenu(list, userMenu);
        return new Result(ResultCode.SUCCESS);
    }*/

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
