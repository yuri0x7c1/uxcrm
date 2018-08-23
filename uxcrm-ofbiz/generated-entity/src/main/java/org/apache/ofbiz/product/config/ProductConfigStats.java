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
 * Product Config Stats
 */
@FieldNameConstants
public class ProductConfigStats implements Serializable {

	public static final long serialVersionUID = 9126609865278620672L;
	public static final String NAME = "ProductConfigStats";
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Num Of Confs
	 */
	@Getter
	@Setter
	private Long numOfConfs;
	/**
	 * Config Type Id
	 */
	@Getter
	@Setter
	private String configTypeId;
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

	public ProductConfigStats(GenericValue value) {
		configId = (String) value.get(FIELD_CONFIG_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		numOfConfs = (Long) value.get(FIELD_NUM_OF_CONFS);
		configTypeId = (String) value.get(FIELD_CONFIG_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfigStats fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigStats(value);
	}

	public static List<ProductConfigStats> fromValues(List<GenericValue> values) {
		List<ProductConfigStats> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigStats(value));
		}
		return entities;
	}
}