package com.initgrep.compaigner.owner;

import com.initgrep.compaigner.common.CommonCrudService;
import com.initgrep.compaigner.exception.DataNotFoundException;

public interface OwnerService extends CommonCrudService<Owner, Long, DataNotFoundException>{

	Owner get(String email) throws DataNotFoundException;
	
}
