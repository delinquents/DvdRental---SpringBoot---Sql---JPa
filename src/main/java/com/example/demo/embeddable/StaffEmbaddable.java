package com.example.demo.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StaffEmbaddable {

	@Column(name = "staff_id")
	private Integer staff_id;
	
}
