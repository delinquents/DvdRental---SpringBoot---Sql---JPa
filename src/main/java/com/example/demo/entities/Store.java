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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Store implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8358313117087384937L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id", unique = true, nullable = false)
	private Integer id;

	
	@Column(name= "manager_staff_id")
	private Integer manager_staff_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "address_id" , nullable = false)	
	private Address address;
	
	@OneToMany( mappedBy = "store",
			fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)	
    @JsonIgnore
	private List<Customer> customers = new ArrayList<Customer>();
	
	@Column(name = "last_update" , nullable = false)	
	private Timestamp last_update;
	

	@OneToMany( mappedBy = "store",
	            fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)	
	@JsonIgnore
	private List<Inventory> invetories = new ArrayList<Inventory>();
	
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store )) return false;
        return id != null && id.equals(((Store) o).getId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }
	
}
