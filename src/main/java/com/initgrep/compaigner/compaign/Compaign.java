package com.initgrep.compaigner.compaign;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.org.Organisation;
import com.initgrep.compaigner.subscriber.Subscriber;
import com.initgrep.compaigner.template.Template;

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
@ToString(exclude = {"recepients"})
@Entity
public class Compaign extends Auditable{
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String title;
	
	@NonNull
	private String description;
	
	@NonNull
	private String senderEmail;
	
	@NonNull
	private Boolean isActive;
	
	@ManyToOne
	private Template template;
		
	@ManyToOne
	private Organisation org; 
	
	@ManyToMany
	private List<Subscriber> recepients;
	

}
