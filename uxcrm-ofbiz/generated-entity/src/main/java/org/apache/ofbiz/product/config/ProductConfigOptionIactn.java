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
 * Product Config Option Iactn
 */
@FieldNameConstants
public class ProductConfigOptionIactn implements Serializable {

	public static final long serialVersionUID = 6599291993613359104L;
	public static final String NAME = "ProductConfigOptionIactn";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Config Option Id
	 */
	@Getter
	@Setter
	private String configOptionId;
	/**
	 * Config Item Id To
	 */
	@Getter
	@Setter
	private String configItemIdTo;
	/**
	 * Config Option Id To
	 */
	@Getter
	@Setter
	private String configOptionIdTo;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Config Iactn Type Id
	 */
	@Getter
	@Setter
	private String configIactnTypeId;
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

	public ProductConfigOptionIactn(GenericValue value) {
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		configOptionId = (String) value.get(FIELD_CONFIG_OPTION_ID);
		configItemIdTo = (String) value.get(FIELD_CONFIG_ITEM_ID_TO);
		configOptionIdTo = (String) value.get(FIELD_CONFIG_OPTION_ID_TO);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		configIactnTypeId = (String) value.get(FIELD_CONFIG_IACTN_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfigOptionIactn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigOptionIactn(value);
	}

	public static List<ProductConfigOptionIactn> fromValues(
			List<GenericValue> values) {
		List<ProductConfigOptionIactn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigOptionIactn(value));
		}
		return entities;
	}
}