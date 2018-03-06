package org.apache.ofbiz.product.catalog.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Prod Catalog Category
 */
public class ProdCatalogCategory implements Serializable {

	public static final long serialVersionUID = 4635372373083004928L;
	public static final String NAME = "ProdCatalogCategory";
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Prod Catalog Category Type Id
	 */
	@Getter
	@Setter
	private String prodCatalogCategoryTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		prodCatalogId, productCategoryId, prodCatalogCategoryTypeId, fromDate, thruDate, sequenceNum
	}

	public ProdCatalogCategory(GenericValue value) {
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		prodCatalogCategoryTypeId = (String) value
				.get(Fields.prodCatalogCategoryTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProdCatalogCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProdCatalogCategory(value);
	}

	public static List<ProdCatalogCategory> fromValues(List<GenericValue> values) {
		List<ProdCatalogCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProdCatalogCategory(value));
		}
		return entities;
	}
}