package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Good Identification Type
 */
public class GoodIdentificationType implements Serializable {

	public static final long serialVersionUID = 6311979629654537216L;
	public static final String NAME = "GoodIdentificationType";
	/**
	 * Good Identification Type Id
	 */
	@Getter
	@Setter
	private String goodIdentificationTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		goodIdentificationTypeId, parentTypeId, hasTable, description
	}

	public GoodIdentificationType(GenericValue value) {
		goodIdentificationTypeId = (String) value
				.get(Fields.goodIdentificationTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GoodIdentificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GoodIdentificationType(value);
	}

	public static List<GoodIdentificationType> fromValues(
			List<GenericValue> values) {
		List<GoodIdentificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GoodIdentificationType(value));
		}
		return entities;
	}
}