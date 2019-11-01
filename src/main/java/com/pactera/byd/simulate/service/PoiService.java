package com.pactera.byd.simulate.service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

public interface PoiService {

    // 下载/导出Menu
    void downLoadExcelFromMenu(HttpServletResponse response);

    // 下载/导出UserMenu
    void downLoadExcelFromUserMenu(HttpServletResponse response);

    // 解析上传的excel
    public List parseExcel(InputStream in, String fileName) throws Exception;


}