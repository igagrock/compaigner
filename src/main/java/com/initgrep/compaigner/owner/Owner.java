package com.initgrep.compaigner.owner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@EqualsAndHashCode(callSuper=false , exclude = { "addresses", "orgs" , "templates"})
@Entity
@ToString(exclude = { "addresses", "orgs" , "templates"})
public class Owner extends Auditable{


	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy="owner", cascade= CascadeType.REMOVE)
	private List<Address> addresses = new ArrayList<>();
	
	@JsonIgnore
	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy="owner" ,  cascade= CascadeType.REMOVE)
	private List<Organisation> orgs = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="owner" )
	private List<Template> templates = new ArrayList<>();

	
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
