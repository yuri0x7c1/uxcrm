package org.apache.ofbiz.order.request;

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
public class CustRequestCategory implements Serializable {

	public static final long serialVersionUID = 4053528447196894208L;
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

	public enum Fields {
		custRequestCategoryId, custRequestTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestCategory(GenericValue value) {
		custRequestCategoryId = (String) value.get(Fields.custRequestCategoryId
				.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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