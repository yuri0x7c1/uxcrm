package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Status
 */
public class PartyStatus implements Serializable {

	public static final long serialVersionUID = 6669056904091942912L;
	public static final String NAME = "PartyStatus";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;

	public enum Fields {
		statusId, partyId, statusDate, changeByUserLoginId
	}

	public PartyStatus(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		partyId = (String) value.get(Fields.partyId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
	}

	public static PartyStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyStatus(value);
	}

	public static List<PartyStatus> fromValues(List<GenericValue> values) {
		List<PartyStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyStatus(value));
		}
		return entities;
	}
}