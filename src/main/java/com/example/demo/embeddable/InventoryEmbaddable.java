package com.example.demo.embeddable;



import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryEmbaddable {

	@Column(name="inventory_id")
	private Integer inventory_id;
	
//	@Column(name="film_id")
//	private Integer fim_id;
//	@Column(name="store_id")
//	private Integer store_id;
//	@Column(name = "last_update")
//	private Timestamp last_update;
}
