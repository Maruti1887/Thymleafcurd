package com.example.thymleaf_crud2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int sid;
	 private String sname;
	 private String semail;
}
