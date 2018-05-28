package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Package Route Seg
 */
public class ShipmentPackageRouteSeg implements Serializable {

	public static final long serialVersionUID = 6832870442866608128L;
	public static final String NAME = "ShipmentPackageRouteSeg";
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
	 * Shipment Route Segment Id
	 */
	@Getter
	@Setter
	private String shipmentRouteSegmentId;
	/**
	 * Tracking Code
	 */
	@Getter
	@Setter
	private String trackingCode;
	/**
	 * Box Number
	 */
	@Getter
	@Setter
	private String boxNumber;
	/**
	 * Label Image
	 */
	@Getter
	@Setter
	private byte[] labelImage;
	/**
	 * Label Intl Sign Image
	 */
	@Getter
	@Setter
	private byte[] labelIntlSignImage;
	/**
	 * Label Html
	 */
	@Getter
	@Setter
	private String labelHtml;
	/**
	 * Label Printed
	 */
	@Getter
	@Setter
	private String labelPrinted;
	/**
	 * International Invoice
	 */
	@Getter
	@Setter
	private byte[] internationalInvoice;
	/**
	 * Package Transport Cost
	 */
	@Getter
	@Setter
	private BigDecimal packageTransportCost;
	/**
	 * Package Service Cost
	 */
	@Getter
	@Setter
	private BigDecimal packageServiceCost;
	/**
	 * Package Other Cost
	 */
	@Getter
	@Setter
	private BigDecimal packageOtherCost;
	/**
	 * Cod Amount
	 */
	@Getter
	@Setter
	private BigDecimal codAmount;
	/**
	 * Insured Amount
	 */
	@Getter
	@Setter
	private BigDecimal insuredAmount;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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
		shipmentId, shipmentPackageSeqId, shipmentRouteSegmentId, trackingCode, boxNumber, labelImage, labelIntlSignImage, labelHtml, labelPrinted, internationalInvoice, packageTransportCost, packageServiceCost, packageOtherCost, codAmount, insuredAmount, currencyUomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentPackageRouteSeg(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		shipmentRouteSegmentId = (String) value
				.get(Fields.shipmentRouteSegmentId.name());
		trackingCode = (String) value.get(Fields.trackingCode.name());
		boxNumber = (String) value.get(Fields.boxNumber.name());
		labelImage = (byte[]) value.get(Fields.labelImage.name());
		labelIntlSignImage = (byte[]) value.get(Fields.labelIntlSignImage
				.name());
		labelHtml = (String) value.get(Fields.labelHtml.name());
		labelPrinted = (String) value.get(Fields.labelPrinted.name());
		internationalInvoice = (byte[]) value.get(Fields.internationalInvoice
				.name());
		packageTransportCost = (BigDecimal) value
				.get(Fields.packageTransportCost.name());
		packageServiceCost = (BigDecimal) value.get(Fields.packageServiceCost
				.name());
		packageOtherCost = (BigDecimal) value.get(Fields.packageOtherCost
				.name());
		codAmount = (BigDecimal) value.get(Fields.codAmount.name());
		insuredAmount = (BigDecimal) value.get(Fields.insuredAmount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentPackageRouteSeg fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentPackageRouteSeg(value);
	}

	public static List<ShipmentPackageRouteSeg> fromValues(
			List<GenericValue> values) {
		List<ShipmentPackageRouteSeg> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentPackageRouteSeg(value));
		}
		return entities;
	}
}