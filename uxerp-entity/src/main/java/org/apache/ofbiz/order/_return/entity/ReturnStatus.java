package org.apache.ofbiz.order._return.entity;

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
public class ReturnStatus implements Serializable {

	public static final long serialVersionUID = 3073561535276954624L;
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

	public enum Fields {
		returnStatusId, statusId, returnId, returnItemSeqId, changeByUserLoginId, statusDatetime
	}

	public ReturnStatus(GenericValue value) {
		returnStatusId = (String) value.get(Fields.returnStatusId.name());
		statusId = (String) value.get(Fields.statusId.name());
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
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