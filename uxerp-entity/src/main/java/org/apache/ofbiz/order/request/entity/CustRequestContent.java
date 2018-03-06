package org.apache.ofbiz.order.request.entity;

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

	public static final long serialVersionUID = 4010687107140172800L;
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

	public enum Fields {
		custRequestId, contentId, fromDate, thruDate
	}

	public CustRequestContent(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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