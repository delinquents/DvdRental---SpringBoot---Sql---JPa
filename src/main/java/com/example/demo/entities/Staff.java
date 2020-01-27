package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staff")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Staff implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8197155620319607124L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Integer id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "address_id" , nullable = false)	
	private Address address;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "store_id" , nullable = false)	
	private Store store;
	

	
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "last_update" , nullable = false)	
	private Timestamp last_update;
	
	
//	@OneToMany( mappedBy = "inventory",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)		
//	@JsonIgnore
//	private List<Rental> rentals = new ArrayList<Rental>();
	
	
//	//TODO ?????
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "staff_id")
//	@JsonIgnore
//	private List<Staff> staffs = new ArrayList<>();
	
	
	@Lob
	@Column(name = "picure")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] picture;
	
	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Staff )) return false;
	        return id != null && id.equals(((Staff) o).getId());
	    }
	 
	    @Override
	    public int hashCode() {
	        return 31;
	    }
}
