package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortQuoteView implements Serializable {

	public static final long serialVersionUID = 2161533570176540672L;
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

	public enum Fields {
		statusItemDescription, workEffortId, quoteId, salesChannelEnumId, description, validThruDate, quoteTypeId, currencyUomId, statusId, validFromDate, productStoreId, partyId, issueDate, quoteName
	}

	public WorkEffortQuoteView(GenericValue value) {
		statusItemDescription = (String) value.get(Fields.statusItemDescription
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		description = (String) value.get(Fields.description.name());
		validThruDate = (Timestamp) value.get(Fields.validThruDate.name());
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		validFromDate = (Timestamp) value.get(Fields.validFromDate.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		partyId = (String) value.get(Fields.partyId.name());
		issueDate = (Timestamp) value.get(Fields.issueDate.name());
		quoteName = (String) value.get(Fields.quoteName.name());
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