package org.apache.ofbiz.order.request;

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
public class CustRequestStatus implements Serializable {

	public static final long serialVersionUID = 1532054985933145088L;
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

	public enum Fields {
		custRequestStatusId, statusId, custRequestId, custRequestItemSeqId, statusDate, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestStatus(GenericValue value) {
		custRequestStatusId = (String) value.get(Fields.custRequestStatusId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		custRequestId = (String) value.get(Fields.custRequestId.name());
		custRequestItemSeqId = (String) value.get(Fields.custRequestItemSeqId
				.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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