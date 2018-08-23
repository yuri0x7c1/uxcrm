package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Quote View
 */
@FieldNameConstants
public class WorkEffortQuoteView implements Serializable {

	public static final long serialVersionUID = 8708900486610164736L;
	public static final String NAME = "WorkEffortQuoteView";
	/**
	 * Status Item Description
	 */
	@Getter
	@Setter
	private String statusItemDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Valid Thru Date
	 */
	@Getter
	@Setter
	private Timestamp validThruDate;
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Valid From Date
	 */
	@Getter
	@Setter
	private Timestamp validFromDate;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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
	 * Quote Name
	 */
	@Getter
	@Setter
	private String quoteName;

	public WorkEffortQuoteView(GenericValue value) {
		statusItemDescription = (String) value
				.get(FIELD_STATUS_ITEM_DESCRIPTION);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		validThruDate = (Timestamp) value.get(FIELD_VALID_THRU_DATE);
		quoteTypeId = (String) value.get(FIELD_QUOTE_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		validFromDate = (Timestamp) value.get(FIELD_VALID_FROM_DATE);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		issueDate = (Timestamp) value.get(FIELD_ISSUE_DATE);
		quoteName = (String) value.get(FIELD_QUOTE_NAME);
	}

	public static WorkEffortQuoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortQuoteView(value);
	}

	public static List<WorkEffortQuoteView> fromValues(List<GenericValue> values) {
		List<WorkEffortQuoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortQuoteView(value));
		}
		return entities;
	}
}