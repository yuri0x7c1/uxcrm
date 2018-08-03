package org.apache.ofbiz.product.config;

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
public class ProductConfigOption implements Serializable {

	public static final long serialVersionUID = 8441966500429125632L;
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

	public enum Fields {
		configItemId, configOptionId, configOptionName, description, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductConfigOption(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		configOptionName = (String) value.get(Fields.configOptionName.name());
		description = (String) value.get(Fields.description.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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