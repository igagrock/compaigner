package com.initgrep.compaigner.owner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.initgrep.compaigner.address.Address;
import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.compaign.Compaign;
import com.initgrep.compaigner.org.Organisation;
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
	
	@OneToMany(mappedBy="owner")
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(mappedBy="owner")
	private List<Organisation> orgs = new ArrayList<>();
	
	@OneToMany(mappedBy="owner")
	private List<Template> templates = new ArrayList<>();

	@OneToMany(mappedBy="owner")
	private List<Compaign> compaigns = new ArrayList<>();

}
