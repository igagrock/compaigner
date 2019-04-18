package com.initgrep.compaigner.subscriber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.org.Organisation;

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
public class Subscriber extends Auditable {
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String email;
	
	@NonNull
	private Integer locale;
	
	@ManyToOne
	private Organisation org;
	
	

}
