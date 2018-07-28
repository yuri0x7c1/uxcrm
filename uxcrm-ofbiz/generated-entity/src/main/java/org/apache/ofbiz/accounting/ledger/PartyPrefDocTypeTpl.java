package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Pref Doc Type Tpl
 */
public class PartyPrefDocTypeTpl implements Serializable {

	public static final long serialVersionUID = 7428002161901935616L;
	public static final String NAME = "PartyPrefDocTypeTpl";
	/**
	 * Party Pref Doc Type Tpl Id
	 */
	@Getter
	@Setter
	private String partyPrefDocTypeTplId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Custom Screen Id
	 */
	@Getter
	@Setter
	private String customScreenId;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		partyPrefDocTypeTplId, partyId, fromDate, thruDate, invoiceTypeId, orderTypeId, quoteTypeId, customScreenId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyPrefDocTypeTpl(GenericValue value) {
		partyPrefDocTypeTplId = (String) value.get(Fields.partyPrefDocTypeTplId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		customScreenId = (String) value.get(Fields.customScreenId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyPrefDocTypeTpl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyPrefDocTypeTpl(value);
	}

	public static List<PartyPrefDocTypeTpl> fromValues(List<GenericValue> values) {
		List<PartyPrefDocTypeTpl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyPrefDocTypeTpl(value));
		}
		return entities;
	}
}