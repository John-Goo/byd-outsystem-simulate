package com.pactera.byd.simulate.controller;

import com.pactera.byd.simulate.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@RestController
public class PoiController {

    @Autowired
    private PoiService poiService;

    /**
     * 下载/导出Menu
     */
    @RequestMapping(value = "downLoadExcelFromMenu", method = RequestMethod.GET)
    public void downLoadExcelFromMenu(HttpServletResponse response) {
        poiService.downLoadExcelFromMenu(response);
    }

    /**
     * 下载/导出UserMenu
     */
    @RequestMapping(value = "downLoadExcelFromUserMenu", method = RequestMethod.GET)
    public void downLoadExcelFromUserMenu(HttpServletResponse response) {
        poiService.downLoadExcelFromUserMenu(response);
    }

    @PostMapping(value = "/upload")
    public String uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = poiService.parseExcel(inputStream, file.getOriginalFilename());
        inputStream.close();


        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            //TODO 随意发挥
            System.out.println(lo);
        }
        return "上传成功";
    }
}
