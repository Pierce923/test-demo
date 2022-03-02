package com.example.excel.controller;

import com.example.excel.dto.ExcelFileVO;
import com.example.excel.mapper.HotelInfoMapper;
import com.example.excel.mapper.HotelPathMapper;
import com.example.excel.service.IReadHotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * excel服务
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class ExeclController {

    @Autowired
    private IReadHotelService readHotelService;

    @Autowired
    private HotelPathMapper pathMapper;

    @Autowired
    private HotelInfoMapper hotelInfoMapper;

    /**
     * 读取hotel数据
     */
    @GetMapping("/read-hotel")
    public void readHotel() {
        log.info("ExeclController readHotel");
        List<ExcelFileVO> list = pathMapper.select();
        for (ExcelFileVO fileVO : list) {
            readHotelService.readHotel(fileVO.getFilePath(), readHotelService);
        }
    }

}
