package com.initgrep.compaigner.owner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.initgrep.compaigner.address.Address;
import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.org.Organisation;
import com.initgrep.compaigner.template.Template;

import lombok.AccessLevel;
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
@EqualsAndHashCode(callSuper=false)
@Entity
@ToString(exclude = { "addresses", "orgs" , "templates"})
public class Owner extends Auditable{


	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String email;
	
//	private Set<Org>
	/***
	 * TODO: add the address and payment information for the user here
	 * after implementing the payment gateway and address class
	 * @Note: address class would be @embedded class;
	 * 
	 */
	
	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy="owner")
	private List<Address> addresses = new ArrayList<>();
	
	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy="owner")
	private List<Organisation> orgs = new ArrayList<>();
	
	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy="owner")
	private List<Template> templates = new ArrayList<>();

	/** Add the address to the owner 
	 *  Note: Still need to save the address in services
	 * **/
	public Address addAddress(Address address){
		this.getAddresses().add(address);
		address.setOwner(this);
		return address;
	}
	
	
	public Organisation addOrg(Organisation org){
		this.getOrgs().add(org);
		org.setOwner(this);
		return org;
	}
	
	public Template addTemplate(Template template){
		this.getTemplates().add(template);
		template.setOwner(this);
		return template;
	}
	
	
	
	

}
