package com.krishna.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.krishna.entity.CitizenPlan;
import com.krishna.repo.CitizenPlanRepository;
import com.krishna.request.SearchRequest;
import com.krishna.util.EmailUtils;
import com.krishna.util.ExcelGenerator;
import com.krishna.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;
	
	@Autowired
	EmailUtils emailUtils;
	
	@Autowired
	private ExcelGenerator excelGen;
	@Autowired
	private PdfGenerator pdfGen;

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		// TODO Auto-generated method stub
		return repo.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
			;
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setStartDate(localDate);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setEndDate(localDate);
		}

		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("Plans.pdf");
		List<CitizenPlan> plans = repo.findAll();
		pdfGen.generate(response, plans,file);
		
		String subject ="Test mail subject";
		String body = "<h1>Test mail Body <h1>";
		String to ="krishna.krish10498@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("Plans.xls");
		List<CitizenPlan> plans = repo.findAll();
		excelGen.generate(response, plans, file);
		
		String subject ="Test mail subject";
		String body = "<h1>Test mail Body <h1>";
		String to ="krishna.krish10498@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, file);
		file.delete();
		return true;

	}

}
