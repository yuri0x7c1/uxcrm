package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Good Identification
 */
public class GoodIdentification implements Serializable {

	public static final long serialVersionUID = 6309926933930440704L;
	public static final String NAME = "GoodIdentification";
	/**
	 * Good Identification Type Id
	 */
	@Getter
	@Setter
	private String goodIdentificationTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;
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
		goodIdentificationTypeId, productId, idValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GoodIdentification(GenericValue value) {
		goodIdentificationTypeId = (String) value
				.get(Fields.goodIdentificationTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		idValue = (String) value.get(Fields.idValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GoodIdentification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GoodIdentification(value);
	}

	public static List<GoodIdentification> fromValues(List<GenericValue> values) {
		List<GoodIdentification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GoodIdentification(value));
		}
		return entities;
	}
}