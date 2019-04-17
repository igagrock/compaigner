package com.initgrep.compaigner.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.template.Template;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
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

}
