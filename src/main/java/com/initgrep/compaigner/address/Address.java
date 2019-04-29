package com.initgrep.compaigner.address;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.owner.Owner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false, exclude = {"id"})
@Entity
@ToString(exclude = {"owner"})
public class Address extends Auditable{
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String addressLine1;
	
	@NonNull
	private String addressLine2;
	
	/** 
	 * TODO: city and country to be embeded entities later such as
	 *  CountryCode, CountryName, localeId 
	 */
	@NonNull
	private String city;
	
	@NonNull
	private String country;
	
	@NonNull
	private String ZipCode;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Owner owner;
	
}
