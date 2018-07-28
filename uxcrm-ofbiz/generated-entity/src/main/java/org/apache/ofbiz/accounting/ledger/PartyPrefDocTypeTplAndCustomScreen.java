package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Pref Doc Type Tpl And Custom Screen
 */
public class PartyPrefDocTypeTplAndCustomScreen implements Serializable {

	public static final long serialVersionUID = 6728992684444308480L;
	public static final String NAME = "PartyPrefDocTypeTplAndCustomScreen";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Party Pref Doc Type Tpl Id
	 */
	@Getter
	@Setter
	private String partyPrefDocTypeTplId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Custom Screen Id
	 */
	@Getter
	@Setter
	private String customScreenId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Custom Screen Location
	 */
	@Getter
	@Setter
	private String customScreenLocation;
	/**
	 * Custom Screen Type Id
	 */
	@Getter
	@Setter
	private String customScreenTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Custom Screen Name
	 */
	@Getter
	@Setter
	private String customScreenName;

	public enum Fields {
		fromDate, quoteTypeId, invoiceTypeId, partyPrefDocTypeTplId, orderTypeId, customScreenId, partyId, thruDate, customScreenLocation, customScreenTypeId, description, customScreenName
	}

	public PartyPrefDocTypeTplAndCustomScreen(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		partyPrefDocTypeTplId = (String) value.get(Fields.partyPrefDocTypeTplId
				.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		customScreenId = (String) value.get(Fields.customScreenId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		customScreenLocation = (String) value.get(Fields.customScreenLocation
				.name());
		customScreenTypeId = (String) value.get(Fields.customScreenTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		customScreenName = (String) value.get(Fields.customScreenName.name());
	}

	public static PartyPrefDocTypeTplAndCustomScreen fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyPrefDocTypeTplAndCustomScreen(value);
	}

	public static List<PartyPrefDocTypeTplAndCustomScreen> fromValues(
			List<GenericValue> values) {
		List<PartyPrefDocTypeTplAndCustomScreen> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyPrefDocTypeTplAndCustomScreen(value));
		}
		return entities;
	}
}