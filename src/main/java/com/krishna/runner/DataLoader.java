package com.krishna.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.krishna.entity.CitizenPlan;
import com.krishna.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
 
	@Autowired
	private CitizenPlanRepository planRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		planRepo.deleteAll();
		//Cash plan Data
	    CitizenPlan c1= new CitizenPlan();
	    c1.setCitizenName("Jhon");
	    c1.setGender("Male");
	    c1.setPlanName("Cash");
	    c1.setPlanStatus("Approved");
	    c1.setStartDate(LocalDate.now());
	    c1.setEndDate(LocalDate.now().plusMonths(6));
	    c1.setBenefitAmt(5000.00);
	    
	    
	    CitizenPlan c2= new CitizenPlan();
	    c2.setCitizenName("Smith");
	    c2.setGender("Male");
	    c2.setPlanName("Cash");
	    c2.setPlanStatus("Denied");
	    c2.setDenialReason("Rental Income");
	    
	    CitizenPlan c3= new CitizenPlan();
	    c3.setCitizenName("Cathy");
	    c3.setGender("FeMale");
	    c3.setPlanName("Cash");
	    c3.setPlanStatus("Terminated");
	    c3.setStartDate(LocalDate.now().plusMonths(4));
	    c3.setEndDate(LocalDate.now().plusMonths(6));
	    c3.setBenefitAmt(5000.00); 
	    c3.setTerminateDate(LocalDate.now());
	    c3.setTreminationReason("Employed");
	    
	    // Food Plan data
	    
	    CitizenPlan c4= new CitizenPlan();
	    c4.setCitizenName("Preethi");
	    c4.setGender("FeMale");
	    c4.setPlanName("Food");
	    c4.setPlanStatus("Approved");
	    c4.setStartDate(LocalDate.now());
	    c4.setEndDate(LocalDate.now().plusMonths(6));
	    c4.setBenefitAmt(4000.00);
	    
	    
	    CitizenPlan c5= new CitizenPlan();
	    c5.setCitizenName("Rubby");
	    c5.setGender("Male");
	    c5.setPlanName("Food");
	    c5.setPlanStatus("Denied");
	    c5.setDenialReason("Rental Income");
	    
	    CitizenPlan c6= new CitizenPlan();
	    c6.setCitizenName("Priya");
	    c6.setGender("FeMale");
	    c6.setPlanName("Food");
	    c6.setPlanStatus("Terminated");
	    c6.setStartDate(LocalDate.now().plusMonths(4));
	    c6.setEndDate(LocalDate.now().plusMonths(6));
	    c6.setBenefitAmt(4000.00); 
	    c6.setTerminateDate(LocalDate.now());
	    c6.setTreminationReason("Employed");
	    
	    //Medical plan data
	    
	    CitizenPlan c7= new CitizenPlan();
	    c7.setCitizenName("Chandu");
	    c7.setGender("FeMale");
	    c7.setPlanName("Mediacal");
	    c7.setPlanStatus("Approved");
	    c7.setStartDate(LocalDate.now());
	    c7.setEndDate(LocalDate.now().plusMonths(6));
	    c7.setBenefitAmt(6000.00);
	    
	    
	    CitizenPlan c8= new CitizenPlan();
	    c8.setCitizenName("David");
	    c8.setGender("Male");
	    c8.setPlanName("Mediacal");
	    c8.setPlanStatus("Denied");
	    c8.setDenialReason("Rental Income");
	    
	    CitizenPlan c9= new CitizenPlan();
	    c9.setCitizenName("Krishna");
	    c9.setGender("Male");
	    c9.setPlanName("Mediacal");
	    c9.setPlanStatus("Terminated");
	    c9.setStartDate(LocalDate.now().plusMonths(4));
	    c9.setEndDate(LocalDate.now().plusMonths(6));
	    c9.setBenefitAmt(6000.00); 
	    c9.setTerminateDate(LocalDate.now());
	    c9.setTreminationReason("Gov Job");
	    
	    // Employment plan data
	    
	    CitizenPlan c10= new CitizenPlan();
	    c10.setCitizenName("Jaanu");
	    c10.setGender("FeMale");
	    c10.setPlanName("Employment");
	    c10.setPlanStatus("Approved");
	    c10.setStartDate(LocalDate.now());
	    c10.setEndDate(LocalDate.now().plusMonths(6));
	    c10.setBenefitAmt(6000.00);
	    
	    
	    CitizenPlan c11= new CitizenPlan();
	    c11.setCitizenName("Vinay");
	    c11.setGender("Male");
	    c11.setPlanName("Employment");
	    c11.setPlanStatus("Denied");
	    c11.setDenialReason("Rental Income");
	    
	    CitizenPlan c12= new CitizenPlan();
	    c12.setCitizenName("Anil");
	    c12.setGender("Male");
	    c12.setPlanName("Employment");
	    c12.setPlanStatus("Terminated");
	    c12.setStartDate(LocalDate.now().plusMonths(4));
	    c12.setEndDate(LocalDate.now().plusMonths(6));
	    c12.setBenefitAmt(6000.00); 
	    c12.setTerminateDate(LocalDate.now());
	    c12.setTreminationReason("Gov Job");
	    
	    List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
	    
	    planRepo.saveAll(list);
	    
	}
	

}
