package com.pactera.byd.simulate.service.impl;

import com.pactera.byd.simulate.dao.PoiDao;
import com.pactera.byd.simulate.pojo.Menu;
import com.pactera.byd.simulate.pojo.UserMenu;
import com.pactera.byd.simulate.service.PoiService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoiServiceImpl implements PoiService {

    @Autowired
    private PoiDao poiDao;


    @Override
    public List parseExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }


    @Override
    public void downLoadExcelFromMenu(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("菜单结构——模板");
        List<Menu> menuList = poiDao.getMenus();

        // 设置要导出的文件的名字
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "云平台同步目标系统——菜单模板" + simpleDateFormat.format(new Date()) + ".xls";

        // 新增数据行，并且设置单元格数据
        int rowNum = 1;
        // headers表示excel表中第一行的表头
        String[] headers = {"系统编号", "系统名称", "一级模块名称", "一级模块编号", "二级模块名称", "二级模块编号", "菜单名称", "菜单编号", "菜单URL"};

        // 在excel表中添加表头
        HSSFRow row = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Menu menu : menuList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(String.valueOf(menu.getSystemCode()));
            row1.createCell(1).setCellValue(menu.getSystemName());
            row1.createCell(2).setCellValue(menu.getModule1Name());
            row1.createCell(3).setCellValue(menu.getModule1Code());
            row1.createCell(4).setCellValue(menu.getModule2Name());
            row1.createCell(5).setCellValue(menu.getModule2Code());
            row1.createCell(6).setCellValue(menu.getMenuName());
            row1.createCell(7).setCellValue(menu.getMenuCode());
            row1.createCell(8).setCellValue(menu.getUrlPath());
            rowNum++;
        }

        // 声明输出流
        OutputStream outputStream = null;

        //响应到客户端
        try {
            //设置响应头
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

            //获取输出流
            outputStream = response.getOutputStream();

            //用文档写输出流
            workbook.write(outputStream);

            //刷新输出流
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void downLoadExcelFromUserMenu(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户菜单关系");
        List<UserMenu> userMenuList = poiDao.getUserMenus();

        // 设置要导出的文件的名字
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fileName = "云平台同步目标系统——用户菜单关系" + simpleDateFormat.format(new Date()) + ".xls";

        // 新增数据行，并且设置单元格数据
        int rowNum = 1;
        // headers表示excel表中第一行的表头
        String[] headers = {"员工账号", "菜单编号", "系统编号", "菜单名称"};

        // 在excel表中添加表头
        HSSFRow row = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (UserMenu userMenu : userMenuList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(String.valueOf(userMenu.getStaffCode()));
            row1.createCell(1).setCellValue(userMenu.getMenuCode());
            row1.createCell(2).setCellValue(userMenu.getSystemCode());
            row1.createCell(3).setCellValue(userMenu.getMenuName());
            rowNum++;
        }

        // 声明输出流
        OutputStream outputStream = null;

        //响应到客户端
        try {
            //设置响应头
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

            //获取输出流
            outputStream = response.getOutputStream();

            //用文档写输出流
            workbook.write(outputStream);

            //刷新输出流
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 判断文件格式
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }
}
