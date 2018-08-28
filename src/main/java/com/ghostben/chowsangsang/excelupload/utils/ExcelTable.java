package com.ghostben.chowsangsang.excelupload.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by xschen on 22/12/2016.
 */
public class ExcelTable extends DataTable {

    private static final Logger logger = LoggerFactory.getLogger(ExcelTable.class);

    private ExcelTable() {

    }

    public static DataTable load(byte[] bytes) {
        ExcelTable table = new ExcelTable();
        table.load(new ByteArrayInputStream(bytes));
        return table;
    }

    public static DataTable load(Supplier<InputStream> inputStreamReader) {
        ExcelTable table = new ExcelTable();
        return table.load(inputStreamReader.get());
    }

    @SuppressWarnings("deprecation")
    private DataTable load(InputStream fis) {

        DataTable result = this;

        try {

            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mySheet.iterator();

            Map<Integer, String> columns = new HashMap<>();

            int rowIndex = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                DataRow dataRow = result.newRow();

                if (rowIndex == 0) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int columnIndex = 0;

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        // skip hidden headers
                        if (cell.getCellStyle().getHidden()) {
                            logger.info("cell hidden");
                            continue;
                        }

                        String value;
                        try {
                            value = cell.getStringCellValue();
                        } catch (IllegalStateException ex) {
                            try {
                                value = "" + cell.getNumericCellValue();
                            } catch (IllegalStateException ex2) {
                                value = "INVALID_HEADER";
                            }
                        }

                        if (value == null) {
                            columnIndex++;
                            continue;
                        }

                        value = value.trim();
                        if (!StringUtils.isEmpty(value)) {
                            logger.info("column: {}", value);
                            columns.put(columnIndex, value);
                        }

                        columnIndex++;
                    }

                    for (String column : columns.values()) {
                        result.columns().add(column);
                    }

                } else {
                    ArrayList<Integer> columnKeys = new ArrayList<Integer>(columns.keySet());
                    int numColumns = columnKeys.size();

                    for (int i = 0; i < numColumns; i++) {
                        int columnIndex = columnKeys.get(i);
                        Cell cell = row.getCell(columnIndex);
                        String value = "";

                        if (cell == null) {
                            value = "";
                        } else {

                            try {
                                value = cell.getStringCellValue();
                                logger.info("#" + (i + 1) + ": cell value (string): {}", value);

                            } catch (IllegalStateException ex) {
                                /*
                                 * 添加的用来读取Excel表格中的Date数据类型
                                 * 在POI处理Excel中的日期类型的单元格时，如果仅仅是判断它是否为日期类型的话，最终会以NUMERIC类型来处理。
                                 * 正确的处理方法是先判断单元格的类型是否则NUMERIC类型，然后再判断单元格是否为日期格式，如果是的话，
                                 */
                                try {
                                    if (0 == cell.getCellType()) {// 判断单元格的类型是否则NUMERIC类型
                                        if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断是否为日期类型
                                            Date date = cell.getDateCellValue();
                                            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
                                            value = sdformat.format(date);
                                            logger.info("#" + (i + 1) + ": cell value (datetime): {}", value);
                                        } else {
                                            value = "" + (int) cell.getNumericCellValue();
                                            logger.info("#" + (i + 1) + ": cell value (numeric): {}", value);
                                        }
                                    }
                                } catch (IllegalStateException ex2) {

                                    value = "";
                                    logger.info("#" + (i + 1) + ": cell value (neither string nor numeric): {}", value);
                                }
                            }
                        }

                        // final check for null values
                        if (value == null) {
                            value = "";
//                     logger.info("#" + (i + 1) + ": cell value (value null): {}", value);
                        }

                        dataRow.cell(columns.get(columnIndex), value);
                    }

                    result.rows().add(dataRow);
                }

                rowIndex++;
            }

        } catch (IOException e) {
            logger.error("Failed to read the excel file", e);
        }

        return result;

    }
}
