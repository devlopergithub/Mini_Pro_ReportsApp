package com.krishna.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krishna.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	
	

	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File file) throws Exception {
		// TODO Auto-generated method stub

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(file));
		document.open();
		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		Paragraph p = new Paragraph("Citizen Plan Info");
		document.add(p);
		// Aligning the paragraph in document
		p.setAlignment(Element.ALIGN_CENTER);

		PdfPTable table = new PdfPTable(6);
		// Create Table Cells for table header
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan name");
		table.addCell("Plan Status");
		table.addCell("Start date");
		table.addCell("End date");

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3, 3, 3, 3 });
		table.setSpacingBefore(5);
		// Setting the background color and padding

		 
		for (CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(String.valueOf(plan.getStartDate()));
			table.addCell(String.valueOf(plan.getEndDate()));
		}
		document.add(table);
		document.close();
	
	}

}
