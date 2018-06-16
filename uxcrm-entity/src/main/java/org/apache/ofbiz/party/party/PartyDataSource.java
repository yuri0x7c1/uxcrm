package org.apache.ofbiz.party.party;

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
public class PartyDataSource implements Serializable {

	public static final long serialVersionUID = 8335366593937276928L;
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

	public enum Fields {
		partyId, dataSourceId, fromDate, visitId, comments, isCreate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyDataSource(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		visitId = (String) value.get(Fields.visitId.name());
		comments = (String) value.get(Fields.comments.name());
		isCreate = (String) value.get(Fields.isCreate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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