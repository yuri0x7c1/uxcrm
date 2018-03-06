package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Employment
 */
public class Employment implements Serializable {

	public static final long serialVersionUID = 15157112369638400L;
	public static final String NAME = "Employment";
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
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
	/**
	 * Termination Reason Id
	 */
	@Getter
	@Setter
	private String terminationReasonId;
	/**
	 * Termination Type Id
	 */
	@Getter
	@Setter
	private String terminationTypeId;

	public enum Fields {
		roleTypeIdFrom, roleTypeIdTo, partyIdFrom, partyIdTo, fromDate, thruDate, terminationReasonId, terminationTypeId
	}

	public Employment(GenericValue value) {
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		terminationReasonId = (String) value.get(Fields.terminationReasonId
				.name());
		terminationTypeId = (String) value.get(Fields.terminationTypeId.name());
	}

	public static Employment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Employment(value);
	}

	public static List<Employment> fromValues(List<GenericValue> values) {
		List<Employment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Employment(value));
		}
		return entities;
	}
}