package org.apache.ofbiz.product.category.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Member And Role
 */
public class ProductCategoryMemberAndRole implements Serializable {

	public static final long serialVersionUID = 3825830064540978176L;
	public static final String NAME = "ProductCategoryMemberAndRole";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
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
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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

	public enum Fields {
		productId, productCategoryId, fromDate, thruDate, comments, sequenceNum, quantity, partyId, roleTypeId
	}

	public ProductCategoryMemberAndRole(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static ProductCategoryMemberAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryMemberAndRole(value);
	}

	public static List<ProductCategoryMemberAndRole> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryMemberAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryMemberAndRole(value));
		}
		return entities;
	}
}