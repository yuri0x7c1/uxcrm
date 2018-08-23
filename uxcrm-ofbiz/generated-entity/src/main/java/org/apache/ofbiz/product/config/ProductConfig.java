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
 * Product Config
 */
@FieldNameConstants
public class ProductConfig implements Serializable {

	public static final long serialVersionUID = 3750070588725069824L;
	public static final String NAME = "ProductConfig";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Config Type Id
	 */
	@Getter
	@Setter
	private String configTypeId;
	/**
	 * Default Config Option Id
	 */
	@Getter
	@Setter
	private String defaultConfigOptionId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Is Mandatory
	 */
	@Getter
	@Setter
	private String isMandatory;
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

	public ProductConfig(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		configTypeId = (String) value.get(FIELD_CONFIG_TYPE_ID);
		defaultConfigOptionId = (String) value
				.get(FIELD_DEFAULT_CONFIG_OPTION_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		isMandatory = (String) value.get(FIELD_IS_MANDATORY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfig(value);
	}

	public static List<ProductConfig> fromValues(List<GenericValue> values) {
		List<ProductConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfig(value));
		}
		return entities;
	}
}