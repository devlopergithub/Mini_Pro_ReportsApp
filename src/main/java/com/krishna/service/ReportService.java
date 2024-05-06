package com.krishna.service;

import java.util.List;

import com.krishna.entity.CitizenPlan;
import com.krishna.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response)throws Exception ;
    
	
}
