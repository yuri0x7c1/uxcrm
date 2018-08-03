package org.apache.ofbiz.product.config;

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
public class ProductConfigConfig implements Serializable {

	public static final long serialVersionUID = 257787503684800512L;
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

	public enum Fields {
		configId, configItemId, sequenceNum, configOptionId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductConfigConfig(GenericValue value) {
		configId = (String) value.get(Fields.configId.name());
		configItemId = (String) value.get(Fields.configItemId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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