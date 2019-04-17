package com.initgrep.compaigner.compaign;

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
public class Compaign extends Auditable{
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String title;
	
	@NonNull
	private String desription;
	
	@NonNull
	private String senderEmail;
	
	@NonNull
	private Boolean status;
	
	
	
	

}
