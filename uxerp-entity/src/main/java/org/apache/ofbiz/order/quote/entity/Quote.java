package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote
 */
public class Quote implements Serializable {

	public static final long serialVersionUID = 3376650638707195904L;
	public static final String NAME = "Quote";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Issue Date
	 */
	@Getter
	@Setter
	private Timestamp issueDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Valid From Date
	 */
	@Getter
	@Setter
	private Timestamp validFromDate;
	/**
	 * Valid Thru Date
	 */
	@Getter
	@Setter
	private Timestamp validThruDate;
	/**
	 * Quote Name
	 */
	@Getter
	@Setter
	private String quoteName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		quoteId, quoteTypeId, partyId, issueDate, statusId, currencyUomId, productStoreId, salesChannelEnumId, validFromDate, validThruDate, quoteName, description
	}

	public Quote(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		issueDate = (Timestamp) value.get(Fields.issueDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		validFromDate = (Timestamp) value.get(Fields.validFromDate.name());
		validThruDate = (Timestamp) value.get(Fields.validThruDate.name());
		quoteName = (String) value.get(Fields.quoteName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static Quote fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Quote(value);
	}

	public static List<Quote> fromValues(List<GenericValue> values) {
		List<Quote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Quote(value));
		}
		return entities;
	}
}