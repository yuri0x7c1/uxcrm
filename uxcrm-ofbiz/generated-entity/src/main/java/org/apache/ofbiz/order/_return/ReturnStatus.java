package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Status
 */
@FieldNameConstants
public class ReturnStatus implements Serializable {

	public static final long serialVersionUID = 3402890731973560320L;
	public static final String NAME = "ReturnStatus";
	/**
	 * Return Status Id
	 */
	@Getter
	@Setter
	private String returnStatusId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
	/**
	 * Status Datetime
	 */
	@Getter
	@Setter
	private Timestamp statusDatetime;
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

	public ReturnStatus(GenericValue value) {
		returnStatusId = (String) value.get(FIELD_RETURN_STATUS_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		statusDatetime = (Timestamp) value.get(FIELD_STATUS_DATETIME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnStatus(value);
	}

	public static List<ReturnStatus> fromValues(List<GenericValue> values) {
		List<ReturnStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnStatus(value));
		}
		return entities;
	}
}