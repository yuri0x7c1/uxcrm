package org.apache.ofbiz.order.quote;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class Quote implements Serializable {

	public static final long serialVersionUID = 52663233030185984L;
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

	public Quote(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		quoteTypeId = (String) value.get(FIELD_QUOTE_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		issueDate = (Timestamp) value.get(FIELD_ISSUE_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		validFromDate = (Timestamp) value.get(FIELD_VALID_FROM_DATE);
		validThruDate = (Timestamp) value.get(FIELD_VALID_THRU_DATE);
		quoteName = (String) value.get(FIELD_QUOTE_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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