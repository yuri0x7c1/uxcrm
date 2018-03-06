package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Profile Default
 */
public class PartyProfileDefault implements Serializable {

	public static final long serialVersionUID = 5587638443734454272L;
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

	public enum Fields {
		partyId, productStoreId, defaultShipAddr, defaultBillAddr, defaultPayMeth, defaultShipMeth
	}

	public PartyProfileDefault(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		defaultShipAddr = (String) value.get(Fields.defaultShipAddr.name());
		defaultBillAddr = (String) value.get(Fields.defaultBillAddr.name());
		defaultPayMeth = (String) value.get(Fields.defaultPayMeth.name());
		defaultShipMeth = (String) value.get(Fields.defaultShipMeth.name());
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