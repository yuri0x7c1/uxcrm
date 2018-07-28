package org.apache.ofbiz.party.need;

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
public class PartyNeed implements Serializable {

	public static final long serialVersionUID = 4192717187251652608L;
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

	public enum Fields {
		partyNeedId, partyId, roleTypeId, partyTypeId, needTypeId, communicationEventId, productId, productCategoryId, visitId, datetimeRecorded, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyNeed(GenericValue value) {
		partyNeedId = (String) value.get(Fields.partyNeedId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		needTypeId = (String) value.get(Fields.needTypeId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		productId = (String) value.get(Fields.productId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		visitId = (String) value.get(Fields.visitId.name());
		datetimeRecorded = (Timestamp) value
				.get(Fields.datetimeRecorded.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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