package com.initgrep.compaigner.address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAllByOwnerId(Long ownerId);

	List<Address> findAllByOwnerEmail(String email);

	Optional<Address> findByIdAndOwnerEmail(Long id, String email);

}
