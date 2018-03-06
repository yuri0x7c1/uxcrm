package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Role
 */
public class GlAccountRole implements Serializable {

	public static final long serialVersionUID = 7644835412588348416L;
	public static final String NAME = "GlAccountRole";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
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
		glAccountId, partyId, roleTypeId, fromDate, thruDate
	}

	public GlAccountRole(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static GlAccountRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountRole(value);
	}

	public static List<GlAccountRole> fromValues(List<GenericValue> values) {
		List<GlAccountRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountRole(value));
		}
		return entities;
	}
}