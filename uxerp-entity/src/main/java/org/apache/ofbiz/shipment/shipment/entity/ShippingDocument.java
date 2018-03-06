package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipping Document
 */
public class ShippingDocument implements Serializable {

	public static final long serialVersionUID = 1277117496977979392L;
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

	public enum Fields {
		documentId, shipmentId, shipmentItemSeqId, shipmentPackageSeqId, description
	}

	public ShippingDocument(GenericValue value) {
		documentId = (String) value.get(Fields.documentId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		description = (String) value.get(Fields.description.name());
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