package org.apache.ofbiz.product.config;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Conf Item Content Type
 */
@FieldNameConstants
public class ProdConfItemContentType implements Serializable {

	public static final long serialVersionUID = 7236849227510962176L;
	public static final String NAME = "ProdConfItemContentType";
	/**
	 * Conf Item Content Type Id
	 */
	@Getter
	@Setter
	private String confItemContentTypeId;
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

	public ProdConfItemContentType(GenericValue value) {
		confItemContentTypeId = (String) value
				.get(FIELD_CONF_ITEM_CONTENT_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProdConfItemContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdConfItemContentType(value);
	}

	public static List<ProdConfItemContentType> fromValues(
			List<GenericValue> values) {
		List<ProdConfItemContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdConfItemContentType(value));
		}
		return entities;
	}
}