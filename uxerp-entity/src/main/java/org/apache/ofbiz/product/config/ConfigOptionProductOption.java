package org.apache.ofbiz.product.config;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Config Option Product Option
 */
public class ConfigOptionProductOption implements Serializable {

	public static final long serialVersionUID = 9187853604569922560L;
	public static final String NAME = "ConfigOptionProductOption";
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Option Id
	 */
	@Getter
	@Setter
	private String productOptionId;
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
		configId, configItemId, sequenceNum, configOptionId, productId, productOptionId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ConfigOptionProductOption(GenericValue value) {
		configId = (String) value.get(Fields.configId.name());
		configItemId = (String) value.get(Fields.configItemId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		productId = (String) value.get(Fields.productId.name());
		productOptionId = (String) value.get(Fields.productOptionId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ConfigOptionProductOption fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ConfigOptionProductOption(value);
	}

	public static List<ConfigOptionProductOption> fromValues(
			List<GenericValue> values) {
		List<ConfigOptionProductOption> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ConfigOptionProductOption(value));
		}
		return entities;
	}
}