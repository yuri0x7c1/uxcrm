package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Product
 */
public class FixedAssetProduct implements Serializable {

	public static final long serialVersionUID = 6360304061773923328L;
	public static final String NAME = "FixedAssetProduct";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Fixed Asset Product Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetProductTypeId;
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
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;

	public enum Fields {
		fixedAssetId, productId, fixedAssetProductTypeId, fromDate, thruDate, comments, sequenceNum, quantity, quantityUomId
	}

	public FixedAssetProduct(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		productId = (String) value.get(Fields.productId.name());
		fixedAssetProductTypeId = (String) value
				.get(Fields.fixedAssetProductTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
	}

	public static FixedAssetProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetProduct(value);
	}

	public static List<FixedAssetProduct> fromValues(List<GenericValue> values) {
		List<FixedAssetProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetProduct(value));
		}
		return entities;
	}
}