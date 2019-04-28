package com.initgrep.compaigner.template;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.compaign.Compaign;
import com.initgrep.compaigner.owner.Owner;

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
@EqualsAndHashCode(callSuper=false ,  exclude = {"compaigns", "owner"})
@Entity
@ToString(exclude = {"compaigns", "owner"})
public class Template extends Auditable {

	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String title;
	
	@NonNull
	private String description;
	
	@NonNull
	private Boolean isPrivate;
	
	/**
	 * TODO: change String to Clob 
	 */
	@NonNull
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Owner owner;
	
	
	@OneToMany(mappedBy="template")
	@Setter(AccessLevel.PRIVATE)
	private List<Compaign> compaigns = new ArrayList<>();
	
	
	public Compaign addCompaign(Compaign compaign) {
		this.getCompaigns().add(compaign);
		compaign.setTemplate(this);
		return compaign;
	}
	
}
