package com.initgrep.compaigner.subscriber;

import com.initgrep.compaigner.common.CommonCrudService;
import com.initgrep.compaigner.exception.DataNotFoundException;

public interface SubscriberService extends CommonCrudService<Subscriber, Long, DataNotFoundException> {

	Subscriber get(String email) throws DataNotFoundException;
	
}
