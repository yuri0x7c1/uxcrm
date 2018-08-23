package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Package Content
 */
@FieldNameConstants
public class ShipmentPackageContent implements Serializable {

	public static final long serialVersionUID = 1263016351918826496L;
	public static final String NAME = "ShipmentPackageContent";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Sub Product Id
	 */
	@Getter
	@Setter
	private String subProductId;
	/**
	 * Sub Product Quantity
	 */
	@Getter
	@Setter
	private BigDecimal subProductQuantity;
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

	public ShipmentPackageContent(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		subProductId = (String) value.get(FIELD_SUB_PRODUCT_ID);
		subProductQuantity = (BigDecimal) value.get(FIELD_SUB_PRODUCT_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentPackageContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentPackageContent(value);
	}

	public static List<ShipmentPackageContent> fromValues(
			List<GenericValue> values) {
		List<ShipmentPackageContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentPackageContent(value));
		}
		return entities;
	}
}