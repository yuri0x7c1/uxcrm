package org.apache.ofbiz.product.catalog.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Category Type
 */
public class ProdCatalogCategoryType implements Serializable {

	public static final long serialVersionUID = 4963685757050788864L;
	public static final String NAME = "ProdCatalogCategoryType";
	/**
	 * Prod Catalog Category Type Id
	 */
	@Getter
	@Setter
	private String prodCatalogCategoryTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		prodCatalogCategoryTypeId, parentTypeId, description
	}

	public ProdCatalogCategoryType(GenericValue value) {
		prodCatalogCategoryTypeId = (String) value
				.get(Fields.prodCatalogCategoryTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProdCatalogCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogCategoryType(value);
	}

	public static List<ProdCatalogCategoryType> fromValues(
			List<GenericValue> values) {
		List<ProdCatalogCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogCategoryType(value));
		}
		return entities;
	}
}