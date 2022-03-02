package com.example.excel.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件信息
 */
@Data
public class ExcelFileVO implements Serializable {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件位置
     */
    private String filePath;

}
