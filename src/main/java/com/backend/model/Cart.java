package com.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[cart]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

	private static final long serialVersionUID = -6689334928223129869L;

	@Id
	private String id;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "date_add")
	private Date date_add;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dt_pro")
	private DetailsProduct detailsProduct;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_acc")
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ser")
	private Service service;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private Set<Order> order;
}
