package org.apache.ofbiz.shipment.shipment;

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
public class ShippingDocument implements Serializable {

	public static final long serialVersionUID = 7237406865206616064L;
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

	public enum Fields {
		documentId, shipmentId, shipmentItemSeqId, shipmentPackageSeqId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShippingDocument(GenericValue value) {
		documentId = (String) value.get(Fields.documentId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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