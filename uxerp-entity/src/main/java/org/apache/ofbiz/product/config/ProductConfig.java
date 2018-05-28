package org.apache.ofbiz.product.config;

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

	public static final long serialVersionUID = 4360805992361757696L;
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

	public enum Fields {
		productId, configItemId, sequenceNum, fromDate, description, longDescription, configTypeId, defaultConfigOptionId, thruDate, isMandatory, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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