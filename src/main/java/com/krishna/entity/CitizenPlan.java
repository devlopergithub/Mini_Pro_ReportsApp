package com.krishna.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Citizen_Plans")
public class CitizenPlan {
    
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String planName;
	private String planStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private String gender;
	private Double benefitAmt;
	private String denialReason;
	private LocalDate terminateDate;
	private String treminationReason;

}
