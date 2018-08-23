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
 * Party Data Source
 */
@FieldNameConstants
public class PartyDataSource implements Serializable {

	public static final long serialVersionUID = 3448804815709723648L;
	public static final String NAME = "PartyDataSource";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Is Create
	 */
	@Getter
	@Setter
	private String isCreate;
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

	public PartyDataSource(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		visitId = (String) value.get(FIELD_VISIT_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		isCreate = (String) value.get(FIELD_IS_CREATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyDataSource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyDataSource(value);
	}

	public static List<PartyDataSource> fromValues(List<GenericValue> values) {
		List<PartyDataSource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyDataSource(value));
		}
		return entities;
	}
}