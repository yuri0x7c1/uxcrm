package org.apache.ofbiz.shipment.issuance;

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
 * Item Issuance
 */
@FieldNameConstants
public class ItemIssuance implements Serializable {

	public static final long serialVersionUID = 4960899281851493376L;
	public static final String NAME = "ItemIssuance";
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
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
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
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
	 * Issued Date Time
	 */
	@Getter
	@Setter
	private Timestamp issuedDateTime;
	/**
	 * Issued By User Login Id
	 */
	@Getter
	@Setter
	private String issuedByUserLoginId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public ItemIssuance(GenericValue value) {
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		issuedDateTime = (Timestamp) value.get(FIELD_ISSUED_DATE_TIME);
		issuedByUserLoginId = (String) value.get(FIELD_ISSUED_BY_USER_LOGIN_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ItemIssuance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ItemIssuance(value);
	}

	public static List<ItemIssuance> fromValues(List<GenericValue> values) {
		List<ItemIssuance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ItemIssuance(value));
		}
		return entities;
	}
}