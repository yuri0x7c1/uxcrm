package org.apache.ofbiz.shipment.shipment;

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
 * Shipment
 */
@FieldNameConstants
public class Shipment implements Serializable {

	public static final long serialVersionUID = 3997886590468391936L;
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

	public Shipment(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentTypeId = (String) value.get(FIELD_SHIPMENT_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
		primaryReturnId = (String) value.get(FIELD_PRIMARY_RETURN_ID);
		primaryShipGroupSeqId = (String) value
				.get(FIELD_PRIMARY_SHIP_GROUP_SEQ_ID);
		picklistBinId = (String) value.get(FIELD_PICKLIST_BIN_ID);
		estimatedReadyDate = (Timestamp) value.get(FIELD_ESTIMATED_READY_DATE);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		estimatedShipWorkEffId = (String) value
				.get(FIELD_ESTIMATED_SHIP_WORK_EFF_ID);
		estimatedArrivalDate = (Timestamp) value
				.get(FIELD_ESTIMATED_ARRIVAL_DATE);
		estimatedArrivalWorkEffId = (String) value
				.get(FIELD_ESTIMATED_ARRIVAL_WORK_EFF_ID);
		latestCancelDate = (Timestamp) value.get(FIELD_LATEST_CANCEL_DATE);
		estimatedShipCost = (BigDecimal) value.get(FIELD_ESTIMATED_SHIP_COST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		handlingInstructions = (String) value.get(FIELD_HANDLING_INSTRUCTIONS);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		destinationFacilityId = (String) value
				.get(FIELD_DESTINATION_FACILITY_ID);
		originContactMechId = (String) value.get(FIELD_ORIGIN_CONTACT_MECH_ID);
		originTelecomNumberId = (String) value
				.get(FIELD_ORIGIN_TELECOM_NUMBER_ID);
		destinationContactMechId = (String) value
				.get(FIELD_DESTINATION_CONTACT_MECH_ID);
		destinationTelecomNumberId = (String) value
				.get(FIELD_DESTINATION_TELECOM_NUMBER_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		additionalShippingCharge = (BigDecimal) value
				.get(FIELD_ADDITIONAL_SHIPPING_CHARGE);
		addtlShippingChargeDesc = (String) value
				.get(FIELD_ADDTL_SHIPPING_CHARGE_DESC);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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