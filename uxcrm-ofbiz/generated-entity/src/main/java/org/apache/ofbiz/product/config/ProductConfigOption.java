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
 * Product Config Option
 */
@FieldNameConstants
public class ProductConfigOption implements Serializable {

	public static final long serialVersionUID = 841812404349894656L;
	public static final String NAME = "ProductConfigOption";
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
	 * Config Option Name
	 */
	@Getter
	@Setter
	private String configOptionName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public ProductConfigOption(GenericValue value) {
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		configOptionId = (String) value.get(FIELD_CONFIG_OPTION_ID);
		configOptionName = (String) value.get(FIELD_CONFIG_OPTION_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfigOption fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigOption(value);
	}

	public static List<ProductConfigOption> fromValues(List<GenericValue> values) {
		List<ProductConfigOption> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigOption(value));
		}
		return entities;
	}
}