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
 * Cust Request Type Attr
 */
@FieldNameConstants
public class CustRequestTypeAttr implements Serializable {

	public static final long serialVersionUID = 5268529601392878592L;
	public static final String NAME = "CustRequestTypeAttr";
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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

	public CustRequestTypeAttr(GenericValue value) {
		custRequestTypeId = (String) value.get(FIELD_CUST_REQUEST_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestTypeAttr(value);
	}

	public static List<CustRequestTypeAttr> fromValues(List<GenericValue> values) {
		List<CustRequestTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestTypeAttr(value));
		}
		return entities;
	}
}