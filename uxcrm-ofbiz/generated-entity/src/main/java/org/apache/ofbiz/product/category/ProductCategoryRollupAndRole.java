package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductCategoryRollupAndRole implements Serializable {

	public static final long serialVersionUID = 6118383108094504960L;
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

	public ProductCategoryRollupAndRole(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		parentProductCategoryId = (String) value
				.get(FIELD_PARENT_PRODUCT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		roleFromDate = (Timestamp) value.get(FIELD_ROLE_FROM_DATE);
		roleThruDate = (Timestamp) value.get(FIELD_ROLE_THRU_DATE);
		roleComments = (String) value.get(FIELD_ROLE_COMMENTS);
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