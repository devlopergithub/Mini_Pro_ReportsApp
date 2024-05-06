package com.krishna.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.krishna.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {


	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File file) throws Exception {
		// TODO Auto-generated method stub

		
		//Workbook workbook = new XSSFWorkbook();
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Plans-data");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("citizenId");
		headerRow.createCell(1).setCellValue("citizenName");
		headerRow.createCell(2).setCellValue("planName");
		headerRow.createCell(3).setCellValue("planStatus");
		headerRow.createCell(4).setCellValue("startDate");
		headerRow.createCell(5).setCellValue("endDate");
		headerRow.createCell(6).setCellValue("BenefitAmount");

		 

		int dataRowIndex = 1;

		for (CitizenPlan plan : plans) {

			Row dataRow = sheet.createRow(dataRowIndex);
			
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			if (null != plan.getStartDate()) {
				dataRow.createCell(4).setCellValue(plan.getStartDate()+"");
			} else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			if (null != plan.getEndDate()) {
				dataRow.createCell(5).setCellValue(plan.getEndDate()+"");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			
			if (null != plan.getBenefitAmt()) {
				dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}

			dataRowIndex++;
		}
		FileOutputStream fos=new FileOutputStream(file);
	    workbook.write(fos);
	    fos.close();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}
