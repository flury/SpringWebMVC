package id.ac.campus.spring.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.campus.spring.entity.TblHero;
import id.ac.campus.spring.service.HeroDaoService;

@Controller
public class HeroExportExcelController {

	@Autowired
	private HeroDaoService heroDaoService;
	
	@RequestMapping("/hero-export-excel")
	public String heroExportExcel(HttpServletResponse response) {
		
		response.setContentType("application/octet-stream");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
		String currentDateTime = dateFormat.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attchment; filename=heros_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<TblHero> listTblHero = heroDaoService.findAll();
		XSSFWorkbook workbook = null;
		
		try {
			workbook = toExcel(listTblHero);
			workbook.write(response.getOutputStream());
			workbook.close();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hero-list";
	}
	
	private XSSFWorkbook toExcel(List<TblHero> listTblHero) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Heros");
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		
		// Write Header Line
		createCell(row, 0, "Hero Name", style, sheet);
		createCell(row, 1, "Hero Code", style, sheet);
		createCell(row, 2, "Roles", style, sheet);
		
		// Write Data Line
		CellStyle styleData = workbook.createCellStyle();
		XSSFFont fontData = workbook.createFont();
		fontData.setBold(false);
		styleData.setFont(fontData);
		
		int rowCount = 1;
		for (int i = 0; i < listTblHero.size(); i++) {
			TblHero tblHero = listTblHero.get(i);
			
			Row rowData = sheet.createRow(rowCount++);
			int columnCount = 0;
			
			createCell(rowData, columnCount++, tblHero.getHeroName(), styleData, sheet);
			createCell(rowData, columnCount++, tblHero.getHeroCode(), styleData, sheet);
			createCell(rowData, columnCount++, tblHero.getHeroRole(), styleData, sheet);
		}
		
		return workbook;
	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style, XSSFSheet sheet) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	
}
