package org.apache.ofbiz.party.need;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Need
 */
@FieldNameConstants
public class PartyNeed implements Serializable {

	public static final long serialVersionUID = 7392511424950191104L;
	public static final String NAME = "PartyNeed";
	/**
	 * Party Need Id
	 */
	@Getter
	@Setter
	private String partyNeedId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Need Type Id
	 */
	@Getter
	@Setter
	private String needTypeId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Datetime Recorded
	 */
	@Getter
	@Setter
	private Timestamp datetimeRecorded;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public PartyNeed(GenericValue value) {
		partyNeedId = (String) value.get(FIELD_PARTY_NEED_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		needTypeId = (String) value.get(FIELD_NEED_TYPE_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		datetimeRecorded = (Timestamp) value.get(FIELD_DATETIME_RECORDED);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyNeed fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNeed(value);
	}

	public static List<PartyNeed> fromValues(List<GenericValue> values) {
		List<PartyNeed> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNeed(value));
		}
		return entities;
	}
}