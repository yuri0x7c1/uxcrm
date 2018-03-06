package org.ofbiz.specialpurpose.pos.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pos Terminal
 */
public class PosTerminal implements Serializable {

	public static final long serialVersionUID = 725393749638937600L;
	public static final String NAME = "PosTerminal";
	/**
	 * Pos Terminal Id
	 */
	@Getter
	@Setter
	private String posTerminalId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Push Entity Sync Id
	 */
	@Getter
	@Setter
	private String pushEntitySyncId;
	/**
	 * Terminal Name
	 */
	@Getter
	@Setter
	private String terminalName;

	public enum Fields {
		posTerminalId, facilityId, pushEntitySyncId, terminalName
	}

	public PosTerminal(GenericValue value) {
		posTerminalId = (String) value.get(Fields.posTerminalId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		pushEntitySyncId = (String) value.get(Fields.pushEntitySyncId.name());
		terminalName = (String) value.get(Fields.terminalName.name());
	}

	public static PosTerminal fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PosTerminal(value);
	}

	public static List<PosTerminal> fromValues(List<GenericValue> values) {
		List<PosTerminal> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PosTerminal(value));
		}
		return entities;
	}
}