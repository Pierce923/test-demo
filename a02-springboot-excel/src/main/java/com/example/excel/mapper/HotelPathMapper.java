package com.example.excel.mapper;


import com.example.excel.dto.ExcelFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 乘客信息服务
 */
@Mapper
public interface HotelPathMapper {

    List<ExcelFileVO> select();

    void delete(int id);

}