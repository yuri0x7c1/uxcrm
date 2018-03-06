package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Party
 */
public class CustRequestParty implements Serializable {

	public static final long serialVersionUID = 4583110398490549248L;
	public static final String NAME = "CustRequestParty";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
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
		custRequestId, partyId, roleTypeId, fromDate, thruDate
	}

	public CustRequestParty(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static CustRequestParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestParty(value);
	}

	public static List<CustRequestParty> fromValues(List<GenericValue> values) {
		List<CustRequestParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestParty(value));
		}
		return entities;
	}
}