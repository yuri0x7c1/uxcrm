package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Acctg Pref And Group
 */
@FieldNameConstants
public class PartyAcctgPrefAndGroup implements Serializable {

	public static final long serialVersionUID = 7988577528480863232L;
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

	public PartyAcctgPrefAndGroup(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		baseCurrencyUomId = (String) value.get(FIELD_BASE_CURRENCY_UOM_ID);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
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