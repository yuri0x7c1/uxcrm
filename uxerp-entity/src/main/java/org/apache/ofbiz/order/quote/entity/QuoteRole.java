package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Role
 */
public class QuoteRole implements Serializable {

	public static final long serialVersionUID = 1654083285920623616L;
	public static final String NAME = "QuoteRole";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
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
		quoteId, partyId, roleTypeId, fromDate, thruDate
	}

	public QuoteRole(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static QuoteRole fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteRole(value);
	}

	public static List<QuoteRole> fromValues(List<GenericValue> values) {
		List<QuoteRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteRole(value));
		}
		return entities;
	}
}