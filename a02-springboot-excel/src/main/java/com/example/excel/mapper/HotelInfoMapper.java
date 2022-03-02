package com.example.excel.mapper;


import com.example.excel.dto.HotelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 乘客信息服务
 */
@Mapper
public interface HotelInfoMapper {

    int insert(HotelVO vo);

    int batchInsert(@Param("list") List<HotelVO> list);

    Integer select(@Param("list") List<Integer> list);

}