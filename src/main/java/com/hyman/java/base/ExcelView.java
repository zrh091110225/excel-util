package com.hyman.java.base;

import com.hyman.java.annotations.ExcelTable;
import com.hyman.java.utils.ExportUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by ronghaizheng on 15/3/29.
 */
public class ExcelView<T> extends AbstractExcelView {

    private static Logger logger = LoggerFactory.getLogger(ExcelView.class);

    /**
     * Excel中的数据
     */
    private List<T> dataList;
    /**
     * Excel文件名
     */
    private String fileName;


    /**
     * 使用注解的文件名生成Excel
     *
     * @param dataList 数据
     */
    public ExcelView(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * 使用指定的文件名生成Excel
     *
     * @param dataList 数据
     * @param fileName 文件名
     */
    public ExcelView(List<T> dataList, String fileName) {
        this.dataList = dataList;
        this.fileName = fileName;
    }

    @Override
    protected void buildExcelDocument(Map map, HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        if (dataList == null || dataList.isEmpty()) {
            logger.info("ExcelView.buildExcelDocument model is empty");
            return;
        }

        logger.info("ExcelView.buildExcelDocument");
        try {
            if (StringUtils.isBlank(fileName)) {
                fileName = "DefaultExcel";
                Class<? extends Object> dataCls = dataList.get(0).getClass();
                ExcelTable excelTable = dataCls.getAnnotation(ExcelTable.class);
                if (excelTable != null) {
                    fileName = excelTable.fileName();
                }
            }
            ExportUtil.export(fileName, dataList, workbook);

            String rtn = "filename=\"" + URLEncoder.encode(fileName, "UTF-8") + ".xls" + "\"";
            response.setHeader("Content-disposition", "attachment;" + rtn);
        } catch (Exception e) {
            logger.error("ExcelView.buildExcelDocument error!", e);
        }
    }
}

