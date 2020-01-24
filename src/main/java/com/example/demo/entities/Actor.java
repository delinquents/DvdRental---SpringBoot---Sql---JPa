package com.example.demo.entities;


import java.io.Serializable;
import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Actor  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5883841491291924737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id", unique = true,nullable = false)
	private Integer id;
	
	@Column(name = "first_name" ,nullable = false, length = 45)
	private String first_name;
	
	@Column(name = "last_name",nullable = false, length = 45 )
	private String last_name;
	
	@Column(name = "last_update" , nullable = false)	
	private Timestamp last_update;
	
	
	
	
	
}
