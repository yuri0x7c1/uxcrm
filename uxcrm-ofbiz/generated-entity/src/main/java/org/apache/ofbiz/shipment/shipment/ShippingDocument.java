package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipping Document
 */
@FieldNameConstants
public class ShippingDocument implements Serializable {

	public static final long serialVersionUID = 1277783566953022464L;
	public static final String NAME = "ShippingDocument";
	/**
	 * Document Id
	 */
	@Getter
	@Setter
	private String documentId;
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
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public ShippingDocument(GenericValue value) {
		documentId = (String) value.get(FIELD_DOCUMENT_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShippingDocument fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShippingDocument(value);
	}

	public static List<ShippingDocument> fromValues(List<GenericValue> values) {
		List<ShippingDocument> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShippingDocument(value));
		}
		return entities;
	}
}