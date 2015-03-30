package com.hyman.java.export;

import com.hyman.java.annotations.ExcelColumn;
import com.hyman.java.annotations.ExcelTable;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by ronghaizheng on 15/3/29.
 */
public class ExportUtil {
    private static Logger logger = LoggerFactory.getLogger(ExportUtil.class);
    private static int EXCEL_MAX_SHEET_CNT = 255;

    /**
     * 导出Excel
     *
     * @param sheetName excle表格名
     * @param excelData 要导出的数据
     * @return
     */
    public static <T> HSSFWorkbook export(String sheetName, List<T> excelData) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        return export(sheetName, excelData, workbook);
    }

    /**
     * 导出Excel
     *
     * @param sheetName excle表格名
     * @param excelData 要导出的数据
     * @param workbook  要导出的工作薄
     * @return
     */
    public static <T> HSSFWorkbook export(String sheetName, List<T> excelData, HSSFWorkbook workbook) {

        if (excelData == null || excelData.isEmpty() || workbook == null || StringUtils.isBlank(sheetName)) {
            return null;
        }

        try {
            /**
             * 设置最大行数
             */
            Class<? extends Object> dataCls = excelData.get(0).getClass();
            ExcelTable excelTable = dataCls.getAnnotation(ExcelTable.class);
            // 定义标题行字体
            Font font = workbook.createFont();
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            int totalDataSize = excelData.size();
            int sheetCnt = totalDataSize /  + 1;

            if (sheetCnt > EXCEL_MAX_SHEET_CNT) {
                throw new Exception("数据量超过了Excel的容量范围！");
            }

            for (int i = 0; i < sheetCnt; i++) {
                int fromIndex = i * excelTable.maxRows();
                int toIndex = fromIndex + excelTable.maxRows();
                toIndex = toIndex > totalDataSize ? totalDataSize : toIndex;
                List<T> sheetData = excelData.subList(fromIndex, toIndex);

                // 生成一个表格
                HSSFSheet sheet = workbook.createSheet(sheetName + "_" + i);

                // 生成标题行
                createHeader(sheetData, sheet, font);

                // 遍历集合数据，产生数据行
                createBody(sheetData, sheet);
            }

            return workbook;
        } catch (Exception e) {
            logger.error("导出Excel异常！", e);
        }

        return null;
    }

    /**
     * 创建表格数据
     *
     * @param excelData
     * @param sheet
     */
    private static <T> void createBody(List<T> excelData, HSSFSheet sheet) {
        int dataRowIndex = 1;
        for (T data : excelData) {
            // 创建数据行
            HSSFRow dataRow = sheet.createRow(dataRowIndex++);

            Class<? extends Object> dataClass = data.getClass();
            Field[] fields = dataClass.getDeclaredFields();
            int columnIndex = 0;
            for (Field field : fields) {
                // 如果没有配置注解，则不在excel中导出该字段
                ExcelColumn columnHeader = field.getAnnotation(ExcelColumn.class);
                if (columnHeader == null) {
                    continue;
                }

                // 创建列
                HSSFCell cell = dataRow.createCell(columnIndex);

                // 反射获取字段的值
                String aimPattern = columnHeader.pattern();
                Object fieldValue = getFieldValue(data, field);
                String textValue = " ";
                if (fieldValue != null) {
                    //TODO 类型处理
                    textValue = fieldValue.toString();
                }

                HSSFRichTextString text = new HSSFRichTextString(textValue);
                cell.setCellValue(text);

                columnIndex++;
            }
        }
    }

    /**
     * 生成Excel的标题行
     *
     * @param excelData 导出的数据列表
     * @param sheet     excel表
     * @return
     */
    private static <T> void createHeader(List<T> excelData, HSSFSheet sheet, Font font) {
        HSSFRow headerRow = sheet.createRow(0);
        Field[] fields = excelData.get(0).getClass().getDeclaredFields();
        int columnIndex = 0;
        for (Field field : fields) {

            // 如果没有配置注解，则不在excel中导出该字段
            ExcelColumn columnHeader = field.getAnnotation(ExcelColumn.class);
            if (columnHeader == null) {
                continue;
            }

            // 获取指定的列标题和列宽高度
            String columnTitle = columnHeader.headerName();
            int columnWidth = columnHeader.columnWidth();
            int columnHeight = columnHeader.columnHeight() * 256;
            columnHeader.typeHandler();

            // 创建列
            HSSFCell cell = headerRow.createCell(columnIndex);
            headerRow.setHeight((short) columnHeight);
            HSSFRichTextString text = new HSSFRichTextString(columnTitle);
            text.applyFont(font);
            // 设置列标题
            cell.setCellValue(text);
            // 设置列宽度
            sheet.setColumnWidth(columnIndex, columnWidth * 256);
            sheet.setDefaultRowHeight((short) columnHeight);

            columnIndex++;
        }
    }

    /**
     * 反射获取字段的值
     *
     * @param obj   对象
     * @param field 字段
     * @return
     */
    private static <T> Object getFieldValue(T obj, Field field) {
        Object fieldValue = " ";

        try {
            field.setAccessible(true);
            fieldValue = field.get(obj);
            if (fieldValue != null) {
                return fieldValue;
            }
        } catch (Exception e) {
            logger.error("导出Excel动态获取字段值异常", e);
        }
        return fieldValue;
    }
}
