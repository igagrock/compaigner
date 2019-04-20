package com.initgrep.compaigner.bootstrap;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.initgrep.compaigner.address.Address;
import com.initgrep.compaigner.compaign.Compaign;
import com.initgrep.compaigner.org.Organisation;
import com.initgrep.compaigner.owner.Owner;
import com.initgrep.compaigner.owner.OwnerRepository;
import com.initgrep.compaigner.template.Template;

@Component
public class DatabaseLoader implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

	private OwnerRepository ownerRepository;

	public DatabaseLoader(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		fetchOwnerInformation_test1();

	}

	public void fetchOwnerInformation_test1() {

		Optional<Owner> optionalOwner = ownerRepository.findById(1001L);
		Owner owner = optionalOwner.get();
		List<Address> addresses = owner.getAddresses();
		List<Organisation> orgs = owner.getOrgs();
		List<Template> templates = owner.getTemplates();

		log.info("owner for Id 1001L = {} ", owner);
		log.info("Address for the owner 1001 = {} ", addresses);
		log.info("Organisations for the owner 1001 = {} ", orgs);
		log.info("Templates for the owner 1001 = {} ", templates);

		orgs.forEach(org -> log.info("org subscribers for id = {} , == {}", org.getId(), org.getSubscribers()));
		orgs.forEach(org ->{
			List<Compaign> compgs =  org.getCompaigns();
			log.info("org compaigns for id = {} , == {}", org.getId(), org.getCompaigns());
			compgs.forEach(cmp -> log.info("compaign reciepents = {}", cmp.getRecepients()));
			
		});

	}

}
