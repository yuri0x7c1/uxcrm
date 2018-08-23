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
 * Cust Request Attribute
 */
@FieldNameConstants
public class CustRequestAttribute implements Serializable {

	public static final long serialVersionUID = 812784935042963456L;
	public static final String NAME = "CustRequestAttribute";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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

	public CustRequestAttribute(GenericValue value) {
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		attrValue = (String) value.get(FIELD_ATTR_VALUE);
		attrDescription = (String) value.get(FIELD_ATTR_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestAttribute(value);
	}

	public static List<CustRequestAttribute> fromValues(
			List<GenericValue> values) {
		List<CustRequestAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestAttribute(value));
		}
		return entities;
	}
}