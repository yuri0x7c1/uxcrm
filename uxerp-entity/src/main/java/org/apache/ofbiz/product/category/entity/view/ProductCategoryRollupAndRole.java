package org.apache.ofbiz.product.category.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Rollup And Role
 */
public class ProductCategoryRollupAndRole implements Serializable {

	public static final long serialVersionUID = 2375436084896368640L;
	public static final String NAME = "ProductCategoryRollupAndRole";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Parent Product Category Id
	 */
	@Getter
	@Setter
	private String parentProductCategoryId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		productCategoryId, parentProductCategoryId, fromDate, thruDate, sequenceNum, partyId, roleTypeId, comments
	}

	public ProductCategoryRollupAndRole(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		parentProductCategoryId = (String) value
				.get(Fields.parentProductCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static ProductCategoryRollupAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryRollupAndRole(value);
	}

	public static List<ProductCategoryRollupAndRole> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryRollupAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryRollupAndRole(value));
		}
		return entities;
	}
}