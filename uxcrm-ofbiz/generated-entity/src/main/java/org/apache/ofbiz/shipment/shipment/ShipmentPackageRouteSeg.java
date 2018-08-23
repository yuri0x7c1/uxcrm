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
 * Shipment Package Route Seg
 */
@FieldNameConstants
public class ShipmentPackageRouteSeg implements Serializable {

	public static final long serialVersionUID = 8190554919232997376L;
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

	public ShipmentPackageRouteSeg(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		shipmentRouteSegmentId = (String) value
				.get(FIELD_SHIPMENT_ROUTE_SEGMENT_ID);
		trackingCode = (String) value.get(FIELD_TRACKING_CODE);
		boxNumber = (String) value.get(FIELD_BOX_NUMBER);
		labelImage = (byte[]) value.get(FIELD_LABEL_IMAGE);
		labelIntlSignImage = (byte[]) value.get(FIELD_LABEL_INTL_SIGN_IMAGE);
		labelHtml = (String) value.get(FIELD_LABEL_HTML);
		labelPrinted = (String) value.get(FIELD_LABEL_PRINTED);
		internationalInvoice = (byte[]) value.get(FIELD_INTERNATIONAL_INVOICE);
		packageTransportCost = (BigDecimal) value
				.get(FIELD_PACKAGE_TRANSPORT_COST);
		packageServiceCost = (BigDecimal) value.get(FIELD_PACKAGE_SERVICE_COST);
		packageOtherCost = (BigDecimal) value.get(FIELD_PACKAGE_OTHER_COST);
		codAmount = (BigDecimal) value.get(FIELD_COD_AMOUNT);
		insuredAmount = (BigDecimal) value.get(FIELD_INSURED_AMOUNT);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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