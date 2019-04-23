package com.initgrep.compaigner.template;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface TemplateService {
	
	public Template get(Long id)throws DataNotFoundException;
	
	public List<Template> getAll();
	
	public Template save(Template template);
	
	public Template update(Template template) throws DataNotFoundException;
	
	public void delete(Template template) throws DataNotFoundException;
	
	public void delete(Long id) throws DataNotFoundException;
}
