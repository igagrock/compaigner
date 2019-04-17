package com.initgrep.compaigner.owner;

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
public class Owner extends Auditable{


	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private Long name;
	
	@NonNull
	private String email;
	
//	private Set<Org>
	/***
	 * TODO: add the address and payment information for the user here
	 * after implementing the payment gateway and address class
	 * @Note: address class would be @embedded class;
	 * 
	 */

}
