package org.apache.ofbiz.product.config.entity;

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
public class ProductConfig implements Serializable {

	public static final long serialVersionUID = 2550107633243933696L;
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

	public enum Fields {
		productId, configItemId, sequenceNum, fromDate, description, longDescription, configTypeId, defaultConfigOptionId, thruDate, isMandatory
	}

	public ProductConfig(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		configItemId = (String) value.get(Fields.configItemId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		description = (String) value.get(Fields.description.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		configTypeId = (String) value.get(Fields.configTypeId.name());
		defaultConfigOptionId = (String) value.get(Fields.defaultConfigOptionId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		isMandatory = (String) value.get(Fields.isMandatory.name());
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