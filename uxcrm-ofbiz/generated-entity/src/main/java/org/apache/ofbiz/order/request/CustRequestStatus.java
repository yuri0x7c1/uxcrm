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
 * Cust Request Status
 */
@FieldNameConstants
public class CustRequestStatus implements Serializable {

	public static final long serialVersionUID = 8108627694639533056L;
	public static final String NAME = "CustRequestStatus";
	/**
	 * Cust Request Status Id
	 */
	@Getter
	@Setter
	private String custRequestStatusId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Cust Request Item Seq Id
	 */
	@Getter
	@Setter
	private String custRequestItemSeqId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public CustRequestStatus(GenericValue value) {
		custRequestStatusId = (String) value.get(FIELD_CUST_REQUEST_STATUS_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		custRequestId = (String) value.get(FIELD_CUST_REQUEST_ID);
		custRequestItemSeqId = (String) value
				.get(FIELD_CUST_REQUEST_ITEM_SEQ_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CustRequestStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestStatus(value);
	}

	public static List<CustRequestStatus> fromValues(List<GenericValue> values) {
		List<CustRequestStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestStatus(value));
		}
		return entities;
	}
}