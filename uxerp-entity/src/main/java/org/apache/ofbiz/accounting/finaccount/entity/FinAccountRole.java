package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Role
 */
public class FinAccountRole implements Serializable {

	public static final long serialVersionUID = 1242407559138920448L;
	public static final String NAME = "FinAccountRole";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		finAccountId, partyId, roleTypeId, fromDate, thruDate
	}

	public FinAccountRole(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FinAccountRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountRole(value);
	}

	public static List<FinAccountRole> fromValues(List<GenericValue> values) {
		List<FinAccountRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountRole(value));
		}
		return entities;
	}
}