package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.embeddable.CustomerEmbaddable;
import com.example.demo.embeddable.InventoryEmbaddable;
import com.example.demo.embeddable.StaffEmbaddable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rental")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Rental implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4546682461012237893L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id", unique = true,nullable = false)
	private Integer id;
	
	@Column(name = "rental_date", nullable = false)
	private Timestamp rental_date;
	
	
	//TODO
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "inventory_id" , nullable = false)	
	private Inventory inventory;

	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "inventory_id")
//	private List<Inventory> inventories = new ArrayList<>();
	
	
//	@Column(name="inventory_id")
//	private Integer inventory_id;
	
//	@Column(name="customer_id")
//	private Integer customer_id;

 
//	@Embedded
//	private InventoryEmbaddable inventory;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "customer_id" , nullable = false)	
	private Customer customer;
	

	

 
	
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "customer_id")
//	private List<Customer> customers = new ArrayList<>();
	
	
//	@Embedded
//	@AttributeOverride(name="first_name", column=@Column(name="customer"))
//	private CustomerEmbaddable customer;
	
	@Column(name = "return_date")
	private Timestamp return_date;
	
//	@Column(name="staff_id")
//	private Integer staff_id;
	
	//TODO
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	
    @JoinColumn(name = "staff_id" , nullable = false)
	private Staff staff;
	

	
//	@Embedded
//    private StaffEmbaddable staff;
	
	
	/* OneDirection
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "staff_id")
	private List<Staff> staffs = new ArrayList<>();
	*/
	
	@Column(name = "last_update", nullable = false)
	private Timestamp last_update;
	
	@OneToMany( mappedBy = "rental",
	            fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)		
	@JsonIgnore
	private List<Payment> payments = new ArrayList<Payment>();
	

}
