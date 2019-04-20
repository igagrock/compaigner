package com.initgrep.compaigner.template;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.compaign.Compaign;
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
@EqualsAndHashCode(callSuper=false)
@Entity
@ToString(exclude = {"compaigns"})
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
	
	@ManyToOne
	private Owner owner;
	
	
	@OneToMany(mappedBy="template")
	private List<Compaign> compaigns = new ArrayList<>();
}
