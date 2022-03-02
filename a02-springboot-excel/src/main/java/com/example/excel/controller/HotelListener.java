package com.example.excel.controller;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.excel.dto.HotelVO;
import com.example.excel.service.IReadHotelService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HotelListener extends AnalysisEventListener<HotelVO> {

    /**
     * 每隔 1000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 1000;

    private List<HotelVO> list = new ArrayList<HotelVO>();

    public IReadHotelService readHotelService;

    public HotelListener() {
    }

    public HotelListener(IReadHotelService readHotelService) {
        this.readHotelService = readHotelService;
    }

    @Override
    public void invoke(HotelVO hotelVO, AnalysisContext analysisContext) {
        if (hotelVO == null) {
            log.info("数据为空");
            return;
        }
        list.add(hotelVO);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            log.info("HotelListener invoke add once 1000-->" + System.currentTimeMillis());
            readHotelService.saveHotelData(list);
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        readHotelService.saveHotelData(list);
        log.info("all data analysed.");
    }
}
