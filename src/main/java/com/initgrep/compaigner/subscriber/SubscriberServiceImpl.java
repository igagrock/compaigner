package com.initgrep.compaigner.subscriber;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public class SubscriberServiceImpl implements SubscriberService {

	private SubscriberRepository repository;

	@Override
	public Subscriber get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Subscriber was not found for id " + id));
	}

	@Override
	public Subscriber get(String email) throws DataNotFoundException {
		return repository.findByEmail(email)
				.orElseThrow(() -> new DataNotFoundException("Subscriber was not found for email " + email));
	}

	@Override
	public List<Subscriber> getAll() {
		return repository.findAll();
	}

	@Override
	public Subscriber save(Subscriber t) {
		return repository.save(t);
	}

	@Override
	public Subscriber update(Subscriber t) throws DataNotFoundException {
		this.get(t.getId());
		return repository.save(t);
	}

	@Override
	public void delete(Subscriber t) throws DataNotFoundException {
		this.get(t.getId());
		repository.delete(t);
	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);
	}

}
