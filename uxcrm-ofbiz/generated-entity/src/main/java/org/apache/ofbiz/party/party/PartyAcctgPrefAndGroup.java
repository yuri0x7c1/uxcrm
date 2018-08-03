package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Acctg Pref And Group
 */
public class PartyAcctgPrefAndGroup implements Serializable {

	public static final long serialVersionUID = 2058132788249605120L;
	public static final String NAME = "PartyAcctgPrefAndGroup";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Base Currency Uom Id
	 */
	@Getter
	@Setter
	private String baseCurrencyUomId;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		partyId, baseCurrencyUomId, groupName, roleTypeId
	}

	public PartyAcctgPrefAndGroup(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		baseCurrencyUomId = (String) value.get(Fields.baseCurrencyUomId.name());
		groupName = (String) value.get(Fields.groupName.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static PartyAcctgPrefAndGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAcctgPrefAndGroup(value);
	}

	public static List<PartyAcctgPrefAndGroup> fromValues(
			List<GenericValue> values) {
		List<PartyAcctgPrefAndGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAcctgPrefAndGroup(value));
		}
		return entities;
	}
}