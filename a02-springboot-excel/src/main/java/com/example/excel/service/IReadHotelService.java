package com.example.excel.service;

import com.example.excel.dto.HotelVO;

import java.util.List;

/**
 * 读取hotel表格
 */
public interface IReadHotelService {

    /**
     * 读取hotel数据
     *
     * @param fileAddr
     */
    void readHotel(String fileAddr, IReadHotelService readHotelService);

    void saveHotelData(List<HotelVO> list);

}
