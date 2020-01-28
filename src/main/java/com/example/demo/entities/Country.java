package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Country  implements Serializable  {

	
	private static final long serialVersionUID = 1200958173303481948L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name =  "country")
	private String country;
	
	@OneToMany( mappedBy = "country",
			    fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)	
    @JsonIgnore
	private List<City> cities = new ArrayList<City>();
	
	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;
	
}
