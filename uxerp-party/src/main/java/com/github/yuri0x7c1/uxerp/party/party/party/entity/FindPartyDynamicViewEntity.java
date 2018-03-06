package com.github.yuri0x7c1.uxerp.party.party.party.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ofbiz.entity.GenericValue;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindPartyDynamicViewEntity implements Serializable {

	public static final long serialVersionUID = 4369712914562639872L;

	/* PT */
	@Getter
	@Setter
	private String partyId;

	@Getter
	@Setter
	private String partyTypeId;

	@Getter
	@Setter
	private String statusId;

	@Getter
	@Setter
	private Date createdDate;

	@Getter
	@Setter
	private Date lastModifiedDate;

	public FindPartyDynamicViewEntity(GenericValue value) {
		/* PT */
		partyId = (java.lang.String) value.get("partyId");
		partyTypeId = (java.lang.String) value.get("partyTypeId");
		statusId = (java.lang.String) value.get("statusId");
		createdDate = (java.util.Date) value.get("createdDate");
		lastModifiedDate = (java.util.Date) value.get("lastModifiedDate");
	}

	public static FindPartyDynamicViewEntity fromValue(GenericValue value) {
		return new FindPartyDynamicViewEntity(value);
	}

	public static List<FindPartyDynamicViewEntity> fromValues(List<GenericValue> values) {
		List<FindPartyDynamicViewEntity> entityList = new ArrayList<>();
		for(GenericValue value : values) {
			entityList.add(new FindPartyDynamicViewEntity(value));
		}
		return entityList;
	}
}