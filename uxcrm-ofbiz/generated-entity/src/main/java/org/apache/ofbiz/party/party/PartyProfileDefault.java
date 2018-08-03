package org.apache.ofbiz.party.party;

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
public class PartyProfileDefault implements Serializable {

	public static final long serialVersionUID = 3379541017142423552L;
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

	public enum Fields {
		partyId, productStoreId, defaultShipAddr, defaultBillAddr, defaultPayMeth, defaultShipMeth, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyProfileDefault(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		defaultShipAddr = (String) value.get(Fields.defaultShipAddr.name());
		defaultBillAddr = (String) value.get(Fields.defaultBillAddr.name());
		defaultPayMeth = (String) value.get(Fields.defaultPayMeth.name());
		defaultShipMeth = (String) value.get(Fields.defaultShipMeth.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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