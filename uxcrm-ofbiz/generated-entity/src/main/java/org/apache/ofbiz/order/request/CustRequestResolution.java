package org.apache.ofbiz.order.request;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Resolution
 */
public class CustRequestResolution implements Serializable {

	public static final long serialVersionUID = 6744145458036197376L;
	public static final String NAME = "CustRequestResolution";
	/**
	 * Cust Request Resolution Id
	 */
	@Getter
	@Setter
	private String custRequestResolutionId;
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
		custRequestResolutionId, custRequestTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CustRequestResolution(GenericValue value) {
		custRequestResolutionId = (String) value
				.get(Fields.custRequestResolutionId.name());
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CustRequestResolution fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestResolution(value);
	}

	public static List<CustRequestResolution> fromValues(
			List<GenericValue> values) {
		List<CustRequestResolution> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestResolution(value));
		}
		return entities;
	}
}