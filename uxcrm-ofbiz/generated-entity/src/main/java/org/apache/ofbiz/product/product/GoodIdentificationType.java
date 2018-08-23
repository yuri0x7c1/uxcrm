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
 * Good Identification Type
 */
@FieldNameConstants
public class GoodIdentificationType implements Serializable {

	public static final long serialVersionUID = 2243712522895136768L;
	public static final String NAME = "GoodIdentificationType";
	/**
	 * Good Identification Type Id
	 */
	@Getter
	@Setter
	private String goodIdentificationTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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

	public GoodIdentificationType(GenericValue value) {
		goodIdentificationTypeId = (String) value
				.get(FIELD_GOOD_IDENTIFICATION_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GoodIdentificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GoodIdentificationType(value);
	}

	public static List<GoodIdentificationType> fromValues(
			List<GenericValue> values) {
		List<GoodIdentificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GoodIdentificationType(value));
		}
		return entities;
	}
}