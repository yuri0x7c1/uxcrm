package org.apache.ofbiz.party.party.service;

import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.party.party.service.base.PartyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartyService extends PartyBaseService {
	@Autowired
	public PartyService(ExecuteFindService executeFindService) {
		super(executeFindService);
	}
}
