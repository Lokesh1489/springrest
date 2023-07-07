package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rest_Tourist")
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;

	@Column(length = 20)
	@NonNull
	private String tname;

	@Column(length = 20)
	@NonNull
	private String city;

	@Column(length = 20)
	@NonNull
	private String packageType;

	@NonNull
	private Double budget;

}
