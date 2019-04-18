package com.initgrep.compaigner.org;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.initgrep.compaigner.audit.Auditable;
import com.initgrep.compaigner.owner.Owner;
import com.initgrep.compaigner.subscriber.Subscriber;

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
public class Organisation extends Auditable {
	
	@Id @GeneratedValue
	private Long id;
	
	@NonNull
	private String title;
	
	@NonNull
	private String url;
	
	@ManyToOne
	private Owner owner;
	
	@OneToMany(mappedBy ="org")
	private List<Subscriber> subscribers = new ArrayList<>();

}
