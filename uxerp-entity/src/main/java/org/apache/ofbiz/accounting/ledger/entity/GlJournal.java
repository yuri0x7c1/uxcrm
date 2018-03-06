package org.apache.ofbiz.accounting.ledger.entity;

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

	public static final long serialVersionUID = 7028008778695330816L;
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

	public enum Fields {
		glJournalId, glJournalName, organizationPartyId, isPosted, postedDate
	}

	public GlJournal(GenericValue value) {
		glJournalId = (String) value.get(Fields.glJournalId.name());
		glJournalName = (String) value.get(Fields.glJournalName.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		isPosted = (String) value.get(Fields.isPosted.name());
		postedDate = (Timestamp) value.get(Fields.postedDate.name());
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