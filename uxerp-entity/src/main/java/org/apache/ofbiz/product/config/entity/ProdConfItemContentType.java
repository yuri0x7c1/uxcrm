package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Conf Item Content Type
 */
public class ProdConfItemContentType implements Serializable {

	public static final long serialVersionUID = 5412767334104464384L;
	public static final String NAME = "ProdConfItemContentType";
	/**
	 * Conf Item Content Type Id
	 */
	@Getter
	@Setter
	private String confItemContentTypeId;
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
		confItemContentTypeId, parentTypeId, hasTable, description
	}

	public ProdConfItemContentType(GenericValue value) {
		confItemContentTypeId = (String) value.get(Fields.confItemContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProdConfItemContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdConfItemContentType(value);
	}

	public static List<ProdConfItemContentType> fromValues(
			List<GenericValue> values) {
		List<ProdConfItemContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdConfItemContentType(value));
		}
		return entities;
	}
}