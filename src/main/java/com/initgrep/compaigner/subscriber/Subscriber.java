package com.initgrep.compaigner.subscriber;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = { "org" })
@Entity
@ToString(exclude = { "org" })
public class Subscriber extends Auditable {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String email;

	@NonNull
	private Integer locale;

	@ManyToOne(fetch = FetchType.LAZY)
	private Organisation org;

}
