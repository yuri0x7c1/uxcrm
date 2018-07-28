package org.apache.ofbiz.order.request;

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
public class CustRequestTypeAttr implements Serializable {

	public static final long serialVersionUID = 8057096132656323584L;
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

	public enum Fields {
		custRequestTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestTypeAttr(GenericValue value) {
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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