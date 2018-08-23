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
 * Product Config Config
 */
@FieldNameConstants
public class ProductConfigConfig implements Serializable {

	public static final long serialVersionUID = 516819974696996864L;
	public static final String NAME = "ProductConfigConfig";
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Config Option Id
	 */
	@Getter
	@Setter
	private String configOptionId;
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

	public ProductConfigConfig(GenericValue value) {
		configId = (String) value.get(FIELD_CONFIG_ID);
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		configOptionId = (String) value.get(FIELD_CONFIG_OPTION_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfigConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigConfig(value);
	}

	public static List<ProductConfigConfig> fromValues(List<GenericValue> values) {
		List<ProductConfigConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigConfig(value));
		}
		return entities;
	}
}