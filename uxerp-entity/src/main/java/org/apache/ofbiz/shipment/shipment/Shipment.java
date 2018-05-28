package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment
 */
public class Shipment implements Serializable {

	public static final long serialVersionUID = 1332975114885474304L;
	public static final String NAME = "Shipment";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Type Id
	 */
	@Getter
	@Setter
	private String shipmentTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Primary Return Id
	 */
	@Getter
	@Setter
	private String primaryReturnId;
	/**
	 * Primary Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String primaryShipGroupSeqId;
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Estimated Ready Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedReadyDate;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Estimated Ship Work Eff Id
	 */
	@Getter
	@Setter
	private String estimatedShipWorkEffId;
	/**
	 * Estimated Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedArrivalDate;
	/**
	 * Estimated Arrival Work Eff Id
	 */
	@Getter
	@Setter
	private String estimatedArrivalWorkEffId;
	/**
	 * Latest Cancel Date
	 */
	@Getter
	@Setter
	private Timestamp latestCancelDate;
	/**
	 * Estimated Ship Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedShipCost;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Handling Instructions
	 */
	@Getter
	@Setter
	private String handlingInstructions;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Destination Facility Id
	 */
	@Getter
	@Setter
	private String destinationFacilityId;
	/**
	 * Origin Contact Mech Id
	 */
	@Getter
	@Setter
	private String originContactMechId;
	/**
	 * Origin Telecom Number Id
	 */
	@Getter
	@Setter
	private String originTelecomNumberId;
	/**
	 * Destination Contact Mech Id
	 */
	@Getter
	@Setter
	private String destinationContactMechId;
	/**
	 * Destination Telecom Number Id
	 */
	@Getter
	@Setter
	private String destinationTelecomNumberId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Additional Shipping Charge
	 */
	@Getter
	@Setter
	private BigDecimal additionalShippingCharge;
	/**
	 * Addtl Shipping Charge Desc
	 */
	@Getter
	@Setter
	private String addtlShippingChargeDesc;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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
		shipmentId, shipmentTypeId, statusId, primaryOrderId, primaryReturnId, primaryShipGroupSeqId, picklistBinId, estimatedReadyDate, estimatedShipDate, estimatedShipWorkEffId, estimatedArrivalDate, estimatedArrivalWorkEffId, latestCancelDate, estimatedShipCost, currencyUomId, handlingInstructions, originFacilityId, destinationFacilityId, originContactMechId, originTelecomNumberId, destinationContactMechId, destinationTelecomNumberId, partyIdTo, partyIdFrom, additionalShippingCharge, addtlShippingChargeDesc, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Shipment(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentTypeId = (String) value.get(Fields.shipmentTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		primaryReturnId = (String) value.get(Fields.primaryReturnId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		estimatedReadyDate = (Timestamp) value.get(Fields.estimatedReadyDate
				.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		estimatedShipWorkEffId = (String) value
				.get(Fields.estimatedShipWorkEffId.name());
		estimatedArrivalDate = (Timestamp) value
				.get(Fields.estimatedArrivalDate.name());
		estimatedArrivalWorkEffId = (String) value
				.get(Fields.estimatedArrivalWorkEffId.name());
		latestCancelDate = (Timestamp) value
				.get(Fields.latestCancelDate.name());
		estimatedShipCost = (BigDecimal) value.get(Fields.estimatedShipCost
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		handlingInstructions = (String) value.get(Fields.handlingInstructions
				.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		destinationFacilityId = (String) value.get(Fields.destinationFacilityId
				.name());
		originContactMechId = (String) value.get(Fields.originContactMechId
				.name());
		originTelecomNumberId = (String) value.get(Fields.originTelecomNumberId
				.name());
		destinationContactMechId = (String) value
				.get(Fields.destinationContactMechId.name());
		destinationTelecomNumberId = (String) value
				.get(Fields.destinationTelecomNumberId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		additionalShippingCharge = (BigDecimal) value
				.get(Fields.additionalShippingCharge.name());
		addtlShippingChargeDesc = (String) value
				.get(Fields.addtlShippingChargeDesc.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static Shipment fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Shipment(value);
	}

	public static List<Shipment> fromValues(List<GenericValue> values) {
		List<Shipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Shipment(value));
		}
		return entities;
	}
}