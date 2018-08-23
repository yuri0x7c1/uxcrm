package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductCategoryMemberAndRole implements Serializable {

	public static final long serialVersionUID = 8735330579797634048L;
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
	/**
	 * Role From Date
	 */
	@Getter
	@Setter
	private Timestamp roleFromDate;
	/**
	 * Role Thru Date
	 */
	@Getter
	@Setter
	private Timestamp roleThruDate;
	/**
	 * Role Comments
	 */
	@Getter
	@Setter
	private String roleComments;

	public ProductCategoryMemberAndRole(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		roleFromDate = (Timestamp) value.get(FIELD_ROLE_FROM_DATE);
		roleThruDate = (Timestamp) value.get(FIELD_ROLE_THRU_DATE);
		roleComments = (String) value.get(FIELD_ROLE_COMMENTS);
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