package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Profile Default
 */
@FieldNameConstants
public class PartyProfileDefault implements Serializable {

	public static final long serialVersionUID = 9049378760440971264L;
	public static final String NAME = "PartyProfileDefault";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Default Ship Addr
	 */
	@Getter
	@Setter
	private String defaultShipAddr;
	/**
	 * Default Bill Addr
	 */
	@Getter
	@Setter
	private String defaultBillAddr;
	/**
	 * Default Pay Meth
	 */
	@Getter
	@Setter
	private String defaultPayMeth;
	/**
	 * Default Ship Meth
	 */
	@Getter
	@Setter
	private String defaultShipMeth;
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

	public PartyProfileDefault(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		defaultShipAddr = (String) value.get(FIELD_DEFAULT_SHIP_ADDR);
		defaultBillAddr = (String) value.get(FIELD_DEFAULT_BILL_ADDR);
		defaultPayMeth = (String) value.get(FIELD_DEFAULT_PAY_METH);
		defaultShipMeth = (String) value.get(FIELD_DEFAULT_SHIP_METH);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyProfileDefault fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyProfileDefault(value);
	}

	public static List<PartyProfileDefault> fromValues(List<GenericValue> values) {
		List<PartyProfileDefault> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyProfileDefault(value));
		}
		return entities;
	}
}