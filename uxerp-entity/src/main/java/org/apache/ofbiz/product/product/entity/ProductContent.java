package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Content
 */
public class ProductContent implements Serializable {

	public static final long serialVersionUID = 1558234658008370176L;
	public static final String NAME = "ProductContent";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Product Content Type Id
	 */
	@Getter
	@Setter
	private String productContentTypeId;
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
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Use Time
	 */
	@Getter
	@Setter
	private Long useTime;
	/**
	 * Use Time Uom Id
	 */
	@Getter
	@Setter
	private String useTimeUomId;
	/**
	 * Use Role Type Id
	 */
	@Getter
	@Setter
	private String useRoleTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		productId, contentId, productContentTypeId, fromDate, thruDate, purchaseFromDate, purchaseThruDate, useCountLimit, useTime, useTimeUomId, useRoleTypeId, sequenceNum
	}

	public ProductContent(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		contentId = (String) value.get(Fields.contentId.name());
		productContentTypeId = (String) value.get(Fields.productContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		purchaseFromDate = (Timestamp) value
				.get(Fields.purchaseFromDate.name());
		purchaseThruDate = (Timestamp) value
				.get(Fields.purchaseThruDate.name());
		useCountLimit = (Long) value.get(Fields.useCountLimit.name());
		useTime = (Long) value.get(Fields.useTime.name());
		useTimeUomId = (String) value.get(Fields.useTimeUomId.name());
		useRoleTypeId = (String) value.get(Fields.useRoleTypeId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductContent(value);
	}

	public static List<ProductContent> fromValues(List<GenericValue> values) {
		List<ProductContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductContent(value));
		}
		return entities;
	}
}