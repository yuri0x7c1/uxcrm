package org.apache.ofbiz.product.category.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Role
 */
public class ProductCategoryRole implements Serializable {

	public static final long serialVersionUID = 6912074970053506048L;
	public static final String NAME = "ProductCategoryRole";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		productCategoryId, partyId, roleTypeId, fromDate, thruDate, comments
	}

	public ProductCategoryRole(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static ProductCategoryRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryRole(value);
	}

	public static List<ProductCategoryRole> fromValues(List<GenericValue> values) {
		List<ProductCategoryRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryRole(value));
		}
		return entities;
	}
}