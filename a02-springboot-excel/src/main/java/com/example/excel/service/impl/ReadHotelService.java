package com.example.excel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.example.excel.controller.HotelListener;
import com.example.excel.dto.HotelVO;
import com.example.excel.mapper.HotelInfoMapper;
import com.example.excel.service.IReadHotelService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadHotelService implements IReadHotelService {

    @Autowired
    private HotelInfoMapper hotelInfoMapper;

    @Override
    public void readHotel(String fileAddr, IReadHotelService readHotelService) {
        // 读取文件
        // HotelListener由于不能交给spring管理，因此需要通过构造方法传入
        EasyExcel.read(fileAddr, HotelVO.class, new HotelListener(readHotelService)).sheet().doRead();
    }

    @Override
    public void saveHotelData(List<HotelVO> list) {
/*        for (HotelVO vo : list) {
            hotelInfoMapper.insert(vo);
        }*/

        if (CollectionUtils.isNotEmpty(list)) {
            hotelInfoMapper.batchInsert(list);
        }
    }

}
