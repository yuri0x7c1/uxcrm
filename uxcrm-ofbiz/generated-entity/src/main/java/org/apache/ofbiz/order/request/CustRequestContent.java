package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Content
 */
public class CustRequestContent implements Serializable {

	public static final long serialVersionUID = 8514093974860122112L;
	public static final String NAME = "CustRequestContent";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
		custRequestId, contentId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestContent(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CustRequestContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestContent(value);
	}

	public static List<CustRequestContent> fromValues(List<GenericValue> values) {
		List<CustRequestContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestContent(value));
		}
		return entities;
	}
}