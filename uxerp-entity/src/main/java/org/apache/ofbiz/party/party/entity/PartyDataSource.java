package org.apache.ofbiz.party.party.entity;

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

	public static final long serialVersionUID = 5377036448592292864L;
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

	public enum Fields {
		partyId, dataSourceId, fromDate, visitId, comments, isCreate
	}

	public PartyDataSource(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		visitId = (String) value.get(Fields.visitId.name());
		comments = (String) value.get(Fields.comments.name());
		isCreate = (String) value.get(Fields.isCreate.name());
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