package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Journal
 */
public class GlJournal implements Serializable {

	public static final long serialVersionUID = 2418412147072654336L;
	public static final String NAME = "GlJournal";
	/**
	 * Gl Journal Id
	 */
	@Getter
	@Setter
	private String glJournalId;
	/**
	 * Gl Journal Name
	 */
	@Getter
	@Setter
	private String glJournalName;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Is Posted
	 */
	@Getter
	@Setter
	private String isPosted;
	/**
	 * Posted Date
	 */
	@Getter
	@Setter
	private Timestamp postedDate;
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
		glJournalId, glJournalName, organizationPartyId, isPosted, postedDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlJournal(GenericValue value) {
		glJournalId = (String) value.get(Fields.glJournalId.name());
		glJournalName = (String) value.get(Fields.glJournalName.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		isPosted = (String) value.get(Fields.isPosted.name());
		postedDate = (Timestamp) value.get(Fields.postedDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlJournal fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GlJournal(value);
	}

	public static List<GlJournal> fromValues(List<GenericValue> values) {
		List<GlJournal> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlJournal(value));
		}
		return entities;
	}
}