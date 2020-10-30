/**  
* <p>Title: ExcelReader.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年7月27日  
* @version 1.0  
*/
package com.suncent.sso.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.suncent.sso.vo.UserVO;

/**
 * <p>
 * Title: ExcelReader
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author ZhouFei
 * @date 2020年7月27日 上午11:58:12
 */
public class ExcelReader {
	private static final Logger log  = LoggerFactory.getLogger(ExcelReader.class);
	
	private static final String XLS = "xls";
	private static final String XLSX = "xlsx";

	/**
	 * 根据文件后缀名类型获取对应的工作簿对象
	 * 
	 * @param inputStream 读取文件的输入流
	 * @param fileType    文件后缀名类型（xls或xlsx）
	 * @return 包含文件数据的工作簿对象
	 * @throws IOException
	 */
	public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
		Workbook workbook = null;
		if (fileType.equalsIgnoreCase(XLS)) {
			workbook = new HSSFWorkbook(inputStream);
		} else if (fileType.equalsIgnoreCase(XLSX)) {
			workbook = new XSSFWorkbook(inputStream);
		}
		return workbook;
	}

	/**
	 * 读取Excel文件内容
	 * 
	 * @param fileName 要读取的Excel文件所在路径
	 * @return 读取结果列表，读取失败时返回null
	 */
	public static List<UserVO> readExcel(String fileName) {
		log.info("读取Excel数据》》》");
		Workbook workbook = null;
		FileInputStream inputStream = null;
		try {
			// 获取Excel后缀名
			String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			// 获取Excel文件
			File excelFile = new File(fileName);
			if (!excelFile.exists()) {
				log.error("Excel文件加载错误失败，文件【"+fileName+"】不存在！");
				return null;
			}

			// 获取Excel工作簿
			inputStream = new FileInputStream(excelFile);
			workbook = getWorkbook(inputStream, fileType);

			// 读取excel中的数据
			List<UserVO> resultDataList = parseExcel(workbook);

			return resultDataList;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (null != workbook) {
					workbook.close();
				}
				if (null != inputStream) {
					inputStream.close();
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 解析Excel数据
	 * 
	 * @param workbook Excel工作簿对象
	 * @return 解析结果
	 */
	private static List<UserVO> parseExcel(Workbook workbook) {
		List<UserVO> resultDataList = new ArrayList<>();
		// 解析sheet
		int rowEnd = -1;//Excel数据量超标
		for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
			Sheet sheet = workbook.getSheetAt(sheetNum);
			// 校验sheet是否合法
			if (sheet == null) {
				continue;
			}
			// 获取第一行数据
			int firstRowNum = sheet.getFirstRowNum();
			Row firstRow = sheet.getRow(firstRowNum);
			if (null == firstRow) {
				log.error("Sheet页："+sheet.getSheetName()+"无数据！");
				continue;
			}

			// 解析每一行的数据，构造数据对象
			int rowStart = firstRowNum + 1;
			rowEnd = getEffRowsNum(sheet);
			for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
				Row row = sheet.getRow(rowNum);
				if (null == row) {
					continue;
				}
				UserVO resultData = convertRowToData(row);
				if (null == resultData) {
					continue;
				}else{
					resultDataList.add(resultData);
				}
			}
			log.info("Sheet页："+sheet.getSheetName()+"读取完毕，共加载有效数据"+resultDataList.size()+"条！");
		}
		return resultDataList;
	}

	private static int getEffRowsNum(Sheet sheet) {
		int rowEnd = sheet.getPhysicalNumberOfRows();
		int totalRows = rowEnd;
		for (int i = 0; i < rowEnd; i++) {
			Row r = sheet.getRow(i);
			boolean isEffRow = false;
			for (Cell c : r) {
				if (c.getCellType() != CellType.BLANK) {
					isEffRow = true;
				}
			}
			if(!isEffRow) {
				totalRows = i;
				break;
			}
		}
		return totalRows;
	}

	/**
	 * 将单元格内容转换为字符串
	 * 
	 * @param cell
	 * @return
	 */
	private static String convertCellValueToString(Cell cell) {
		if (cell == null) {
			return null;
		}
		String returnValue = null;
		switch (cell.getCellType()) {
		case NUMERIC: // 数字
			Double doubleValue = cell.getNumericCellValue();
			//小数为0则显示整数，否则显示小数
			BigDecimal bg = new BigDecimal(doubleValue).setScale(2, RoundingMode.UP);
		    double num = bg.doubleValue();
		    if (Math.round(num) - num == 0) {
		    	returnValue = String.valueOf((long) num);
		    }else {
		    	returnValue = String.valueOf(num);
		    }
			break;
		case STRING: // 字符串
			returnValue = cell.getStringCellValue();
			break;
		case BOOLEAN: // 布尔
			Boolean booleanValue = cell.getBooleanCellValue();
			returnValue = booleanValue.toString();
			break;
		case BLANK: // 空值
			break;
		case FORMULA: // 公式
			returnValue = cell.getCellFormula();
			break;
		case ERROR: // 故障
			break;
		default:
			break;
		}
		return returnValue;
	}

	/**
	 * 提取每一行中需要的数据，构造成为一个结果数据对象
	 *
	 * 当该行中有单元格的数据为空或不合法时，忽略该行的数据
	 *
	 * @param row 行数据
	 * @return 解析后的行数据对象，行数据错误时返回null
	 */
	private static UserVO convertRowToData(Row row) {
		UserVO user = new UserVO();
		Cell cell;
		int cellNum = 0;
		cell = row.getCell(cellNum++);
		String roleId = convertCellValueToString(cell);
		user.setRoleId(roleId);
		
		cell = row.getCell(cellNum++);
		String name = convertCellValueToString(cell);
		user.setName(name);
		
		cell = row.getCell(cellNum++);
		String nameEn = convertCellValueToString(cell);
		user.setNameEn(nameEn);
		user.setAccount(nameEn);
		
		cell = row.getCell(cellNum++);
		String pwd = convertCellValueToString(cell);
		user.setPwd(pwd);
		
		cell = row.getCell(cellNum++);
		String center = convertCellValueToString(cell);
		user.setCore(center);
		
		cell = row.getCell(cellNum++);
		String title = convertCellValueToString(cell);
		user.setTitle(title);
		
		cell = row.getCell(cellNum++);
		String dept = convertCellValueToString(cell);
		user.setDept(dept);
		
		cell = row.getCell(cellNum++);
		String phone = convertCellValueToString(cell);
		user.setPhone(phone);
		
		cell = row.getCell(cellNum++);
		String email = convertCellValueToString(cell);
		user.setEmail(email);
		
		return user;
	}
}
