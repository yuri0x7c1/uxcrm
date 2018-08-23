package org.apache.ofbiz.order.request;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Category
 */
@FieldNameConstants
public class CustRequestCategory implements Serializable {

	public static final long serialVersionUID = 2034316523315460096L;
	public static final String NAME = "CustRequestCategory";
	/**
	 * Cust Request Category Id
	 */
	@Getter
	@Setter
	private String custRequestCategoryId;
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
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

	public CustRequestCategory(GenericValue value) {
		custRequestCategoryId = (String) value
				.get(FIELD_CUST_REQUEST_CATEGORY_ID);
		custRequestTypeId = (String) value.get(FIELD_CUST_REQUEST_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestCategory(value);
	}

	public static List<CustRequestCategory> fromValues(List<GenericValue> values) {
		List<CustRequestCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestCategory(value));
		}
		return entities;
	}
}