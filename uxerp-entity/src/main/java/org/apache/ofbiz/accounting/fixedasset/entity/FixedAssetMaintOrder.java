package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Maint Order
 */
public class FixedAssetMaintOrder implements Serializable {

	public static final long serialVersionUID = 2308250388523461632L;
	public static final String NAME = "FixedAssetMaintOrder";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;

	public enum Fields {
		fixedAssetId, maintHistSeqId, orderId, orderItemSeqId
	}

	public FixedAssetMaintOrder(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
	}

	public static FixedAssetMaintOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMaintOrder(value);
	}

	public static List<FixedAssetMaintOrder> fromValues(
			List<GenericValue> values) {
		List<FixedAssetMaintOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMaintOrder(value));
		}
		return entities;
	}
}