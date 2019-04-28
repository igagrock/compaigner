package com.initgrep.compaigner.template;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

	TemplateRepository repository;

	public TemplateServiceImpl(TemplateRepository repository) {
		this.repository = repository;
	}

	@Override
	public Template get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Template was not found for id = " + id));
	}

	@Override
	public List<Template> getAll() {
		return repository.findAll();
	}

	@Override
	public Template save(Template t) {
		return repository.save(t);
	}

	@Override
	public Template update(Template t) throws DataNotFoundException {
		this.get(t.getId());
		return repository.save(t);
	}

	@Override
	public void delete(Template t) throws DataNotFoundException {
		this.get(t.getId());
		repository.delete(t);
	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
			this.get(id);
			repository.deleteById(id);
	}

}
