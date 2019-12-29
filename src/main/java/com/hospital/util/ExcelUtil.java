package com.hospital.util;

import lombok.val;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import sun.jvm.hotspot.utilities.AssertionFailure;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class which provide common solution for excel generation.
 *
 * @author jianhua.shi
 */
public final class ExcelUtil {

    private ExcelUtil() {
        throw new AssertionFailure("Can't be initialized.");
    }

    private static final String[] TABLE_HEADS = {"日期", "星期", "GN日", "内膜", "右卵巢", ">=20", "19", "18", "17", "16", "15", "14", "12-13", "<=11", "左卵巢", ">=20", "19", "18", "17", "16", "15", "14", "12-13", "<=11","" +
            "超声者","GnRH","FSH","hMG","其他","E2","LH","FSH","P","医生"};

    public static HSSFWorkbook buildWorkBook(String sheetName, Map<String, String> values) {


        val wb = new HSSFWorkbook();


        val sheet = wb.createSheet(sheetName);

        val row0 = sheet.createRow(0);

        val style = createStyle(wb);

        buildHead(style, row0, values);

        sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 20));
        val row1 = sheet.createRow(1);

        buildTitle(style, row1);
        buildBody(style, sheet, values);
        buildTable(style,sheet,values);
        buildFoot(style,sheet,values);


        return wb;
    }


    /**
     * @param wb
     * @return
     */
    private static HSSFCellStyle createStyle(final HSSFWorkbook wb) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFFont font = wb.createFont(); //设置字体
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 15);
        font.setColor(HSSFColor.BLACK.index);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        style.setFont(font);

        return style;
    }

    private static void buildTitle(final HSSFCellStyle style, final HSSFRow row) {
        val cell0 = row.createCell(5);
        cell0.setCellStyle(style);
        cell0.setCellValue("卵泡监测单");
    }

    private static void buildHead(final HSSFCellStyle style, final HSSFRow row, final Map<String, String> values) {
        val cell0 = row.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("身高:");

        val cell1 = row.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue(values.get("height"));

        val cell2 = row.createCell(2);
        cell2.setCellValue("CM");
        cell2.setCellStyle(style);

        val cell3 = row.createCell(4);
        cell3.setCellStyle(style);
        cell3.setCellValue("体重:");

        val cell4 = row.createCell(5);
        cell4.setCellStyle(style);
        cell4.setCellValue(values.get("weight"));

        val cell7 = row.createCell(6);
        cell7.setCellStyle(style);
        cell7.setCellValue("KG");

        val cell5 = row.createCell(8);
        cell5.setCellStyle(style);
        cell5.setCellValue("BMI:");

        val cell6 = row.createCell(9);
        cell6.setCellStyle(style);
        cell6.setCellValue(values.get("bmi"));

        val cell8 = row.createCell(12);
        cell8.setCellStyle(style);
        cell8.setCellValue("姓名:");

        val cell9 = row.createCell(13);
        cell9.setCellStyle(style);
        cell9.setCellValue(values.get("name"));

    }

    private static void buildBody(final HSSFCellStyle style, final HSSFSheet sheet, final Map<String, String> values) {

        sheet.addMergedRegion(new CellRangeAddress(3, 3, 24, 26));
        val row3 = sheet.createRow(3);
        val cell0 = row3.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("方案:");

        val cell1 = row3.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue(values.get("plan"));

        val cell3 = row3.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("AMH:");

        val cell4 = row3.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue(values.get("amh"));

        val cell6 = row3.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("E2:");

        val cell7 = row3.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue(values.get("e2"));

        val cell9 = row3.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("FSH:");

        val cell10 = row3.createCell(10);
        cell10.setCellStyle(style);
        cell10.setCellValue(values.get("fsh"));

        val cell12 = row3.createCell(12);
        cell12.setCellStyle(style);
        cell12.setCellValue("LH:");

        val cell13 = row3.createCell(13);
        cell13.setCellStyle(style);
        cell13.setCellValue(values.get("lh"));


        val cell15 = row3.createCell(15);
        cell15.setCellStyle(style);
        cell15.setCellValue("P:");

        val cell16 = row3.createCell(16);
        cell16.setCellStyle(style);
        cell16.setCellValue(values.get("p"));


        val cell18 = row3.createCell(18);
        cell18.setCellStyle(style);
        cell18.setCellValue("PRL:");

        val cell19 = row3.createCell(19);
        cell19.setCellStyle(style);
        cell19.setCellValue(values.get("prl"));


        val cell21 = row3.createCell(21);
        cell21.setCellStyle(style);
        cell21.setCellValue("T:");

        val cell22 = row3.createCell(22);
        cell22.setCellStyle(style);
        cell22.setCellValue(values.get("t"));

        val cell24 = row3.createCell(24);
        cell24.setCellStyle(style);
        cell24.setCellValue("末次月经时间:");

        val cell25 = row3.createCell(25);
        cell25.setCellStyle(style);
        cell25.setCellValue(values.get("lmpDate"));

        val row4 = sheet.createRow(4);

        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 4));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 7, 9));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 12, 15));
        val cell0_4 = row4.createCell(0);
        cell0_4.setCellStyle(style);
        cell0_4.setCellValue("降调时间及用药:");

        val cell1_4 = row4.createCell(5);
        cell1_4.setCellStyle(style);

        val cell3_4 = row4.createCell(7);
        cell3_4.setCellStyle(style);
        cell3_4.setCellValue("撤退性出血:");

        val cell4_4 = row4.createCell(10);
        cell4_4.setCellStyle(style);

        val cell6_4 = row4.createCell(12);
        cell6_4.setCellStyle(style);
        cell6_4.setCellValue("降调后时间:");

        val cell7_4 = row4.createCell(16);
        cell7_4.setCellStyle(style);


        val cell9_4 = row4.createCell(18);
        cell9_4.setCellStyle(style);
        cell9_4.setCellValue("E2:");

        val cell10_4 = row4.createCell(19);
        cell10_4.setCellStyle(style);
        cell10_4.setCellValue(values.get("e2"));

        val cell12_4 = row4.createCell(20);
        cell12_4.setCellStyle(style);
        cell12_4.setCellValue("FSH:");

        val cell13_4 = row4.createCell(21);
        cell13_4.setCellStyle(style);
        cell13_4.setCellValue(values.get("fsh"));

        val cell15_4 = row4.createCell(23);
        cell15_4.setCellStyle(style);
        cell15_4.setCellValue("LH:");

        val cell16_4 = row4.createCell(24);
        cell16_4.setCellStyle(style);
        cell16_4.setCellValue(values.get("lh"));


        val row5 = sheet.createRow(5);

        sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 4));

        val cell0_5 = row5.createCell(0);
        cell0_5.setCellStyle(style);
        cell0_5.setCellValue("促排起始时间及用药:");

        val cell1_5 = row5.createCell(5);
        cell1_5.setCellStyle(style);

        val cell3_5 = row5.createCell(7);
        cell3_5.setCellStyle(style);
        cell3_5.setCellValue("备注:");

        val cell4_5 = row5.createCell(8);
        cell4_5.setCellStyle(style);

    }

    private static void buildTable(final HSSFCellStyle style,final HSSFSheet sheet, final Map<String,String> values){
        for(int i=0; i< TABLE_HEADS.length;i++){
            val row = sheet.createRow(i+6);
            val cell0 = row.createCell(0);
            cell0.setCellStyle(style);
            cell0.setCellValue(TABLE_HEADS[i]);
        }
    }

    private static void buildFoot(final HSSFCellStyle style,final HSSFSheet sheet,final Map<String,String> values){

        val row = sheet.createRow(41);
        sheet.addMergedRegion(new CellRangeAddress(41,41,0,5));
        val cell0 = row.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("扳机药物时间及剂量:");

        val cell1 = row.createCell(6);
        cell1.setCellStyle(style);

        val cell3 = row.createCell(8);
        cell3.setCellStyle(style);
        cell3.setCellValue("备注:");

        val cell4 = row.createCell(9);
        cell4.setCellStyle(style);
    }

    public static  void main(String[] args) throws IOException {
        HSSFWorkbook book = ExcelUtil.buildWorkBook("卵泡监测表",new HashMap<String,String>());

        File tempFile=File.createTempFile("temp",".xls", new File("/Users/jianhua.shi/Downloads"));
        OutputStream tempout = new FileOutputStream(tempFile);
        book.write(tempout);
    }

}
