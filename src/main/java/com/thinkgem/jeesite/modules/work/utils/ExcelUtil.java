﻿package com.thinkgem.jeesite.modules.work.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * 操作Excel工具类
 * @creator     zhangqiang
 * @create-time May 13, 2015   5:58:41 PM
 * @version 1.0
 */
public class ExcelUtil {

	private static Log logger = LogFactory.getLog(ExcelUtil.class);
	
	/**
	 * 创建Excel行头
	 * @param titleList
	 * @param sheet
	 * @param headRowNumber
	 * @return
	 */
	public static HSSFRow createHSSFRow(List<String> titleList,
			List<Integer> titleWidthList,
			HSSFWorkbook wb,
			HSSFSheet sheet,
			Integer headRowNumber) {
        // 列头
		HSSFRow row = sheet.createRow(headRowNumber);
		if (titleList != null && titleList.size() > 0 ){
			for (int i = 0; i < titleList.size(); i++) {
				sheet.setColumnWidth(i, titleWidthList.get(i) * 256);
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(titleList.get(i));

				HSSFCellStyle cellStyle = wb.createCellStyle();
				// 指定单元格居中对齐
				cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
				// 指定单元格垂直居中对齐
				cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
				// 指定单元格自动换行
				cellStyle.setWrapText(true);

				// 设置单元格字体
				HSSFFont font = wb.createFont();
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				cellStyle.setFont(font);

				// 设置单元格格式
				cell.setCellStyle(cellStyle);
			}
		}
		return row;
	}
	
	/**
	 * 创建Excel行头
	 * @param titles
	 * @param sheet
	 * @param headRowNumber
	 * @return
	 */
	public static HSSFRow createHSSFRow(String[] titles,
			Integer[] titleWidths,
			HSSFWorkbook wb,
			HSSFSheet sheet,
			Integer headRowNumber) {
        // 列头
		HSSFRow row = sheet.createRow(headRowNumber);
		if (titles != null && titles.length > 0 ){
			for (int i = 0; i < titles.length; i++) {
				sheet.setColumnWidth(i, titleWidths[i] * 256);
				HSSFCell cell = row.createCell(i);
				cell.setCellValue(titles[i]);
				
				HSSFCellStyle cellStyle = wb.createCellStyle();
				// 指定单元格居中对齐
				cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
				// 指定单元格垂直居中对齐
				cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
				// 指定单元格自动换行
				cellStyle.setWrapText(true);

				// 设置单元格字体
				HSSFFont font = wb.createFont();
				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				cellStyle.setFont(font);

				// 设置单元格格式
				cell.setCellStyle(cellStyle);
			}
		}
		return row;
	}
	public static HSSFCell createCell(HSSFCellStyle cellStyle,HSSFRow row,int cellNum){
		HSSFCell cell = row.createCell(cellNum);
		cell.setCellStyle(cellStyle);
		return cell;
	}
	public static void exportExcelData(String excelFileName,
			HttpServletResponse response,
			HSSFWorkbook wb) {
		String fileName = new Date().getTime() + "";
		//获取文件名
		fileName = excelFileName+".xls";
		OutputStream os = null;
		try {
			// 清空输出流
			response.reset();
			// 取得输出流
			os = response.getOutputStream(); 
			// 设定输出文件头
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
			// 定义输出类型
			response.setContentType("application/msexcel");
		} catch (IOException ex) {
			// 捕捉异常   
			ex.printStackTrace();
			logger.error("导出" + excelFileName + "发生异常:" + ex.getMessage());
		}
		try {
			os.flush();
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("导出" + excelFileName + "发生异常:" + e.getMessage());
		}
	}
/*	public static String exportAjaxExcelData(String excelFileName,
			HSSFWorkbook wb) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String excelFilePath="";
		//输出文件
		String tmpZipDirectoryName = UUIDUtil.uuid().toLowerCase();
		String tmpZipDirectoryPath = System.getProperty("java.io.tmpdir") + File.separator + tmpZipDirectoryName + File.separator;
		File tmpZipDirectory = new File(tmpZipDirectoryPath);
		if (!tmpZipDirectory.exists()) {
			tmpZipDirectory.mkdirs();
		}
		try{
			excelFilePath = tmpZipDirectoryPath + tmpZipDirectoryName + ".xls";
			fos = new FileOutputStream(excelFilePath);
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(fos);
		}
		return excelFilePath;
	}*/
	/**获取设置样式《有边框》*/
	public static HSSFCellStyle createHSSFCellStyle1(HSSFWorkbook wb){
		HSSFCellStyle cellStyles = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyles.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyles.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyles.setWrapText(true);
		//设置边框
		cellStyles.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		cellStyles.setFont(font);
		return cellStyles;
	}
	/**获取设置样式《无边框》*/
	public static HSSFCellStyle createHSSFCellStyle2(HSSFWorkbook wb){
		HSSFCellStyle cellStyles = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyles.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyles.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyles.setWrapText(true);
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		cellStyles.setFont(font);
		return cellStyles;
	}
	/**获取设置样式《无边框，加粗,字体加大》*/
	public static HSSFCellStyle createHSSFCellStyle3(HSSFWorkbook wb){
		HSSFCellStyle cellStyles = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyles.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyles.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyles.setWrapText(true);
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeight((short)300);
		cellStyles.setFont(font);
		return cellStyles;
	}
	/**获取设置样式《边框，加粗》*/
	public static HSSFCellStyle createHSSFCellStyle4(HSSFWorkbook wb){
		HSSFCellStyle cellStyles = wb.createCellStyle();
		// 指定单元格居中对齐
		cellStyles.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 指定单元格垂直居中对齐
		cellStyles.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 指定单元格自动换行
		cellStyles.setWrapText(true);
		//设置边框
		cellStyles.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyles.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyles.setFont(font);
		return cellStyles;
	}
}
