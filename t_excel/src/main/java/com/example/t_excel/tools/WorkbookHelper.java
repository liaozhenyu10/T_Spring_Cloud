package com.example.t_excel.tools;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: liaozhenyu
 * @date: 2022/06/20
 **/
public class WorkbookHelper {

    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();


        Sheet sheet = workbook.createSheet("测试表单");

        //第一行
        Row headerRow = sheet.createRow(0);

        //创建样式
        CellStyle headerCellStyle = workbook.createCellStyle();

        //填充色
        headerCellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 字体颜色
        Font font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        headerCellStyle.setFont(font);

        //遍历设置第一行的单元格子

        for (int i = 0; i < 10; i++) {
            Cell headerRowCell = headerRow.createCell(i);
            headerRowCell.setCellValue("值" + i);
            headerRowCell.setCellStyle(headerCellStyle);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("E://b.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();


        System.out.println("finished......");

    }
}
