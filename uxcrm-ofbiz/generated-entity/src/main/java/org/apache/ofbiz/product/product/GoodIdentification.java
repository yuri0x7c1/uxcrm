package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class GoodIdentification implements Serializable {

	public static final long serialVersionUID = 1036563697216577536L;
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

	public GoodIdentification(GenericValue value) {
		goodIdentificationTypeId = (String) value
				.get(FIELD_GOOD_IDENTIFICATION_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		idValue = (String) value.get(FIELD_ID_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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