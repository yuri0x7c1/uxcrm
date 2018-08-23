package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class GlJournal implements Serializable {

	public static final long serialVersionUID = 4834898878728997888L;
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

	public GlJournal(GenericValue value) {
		glJournalId = (String) value.get(FIELD_GL_JOURNAL_ID);
		glJournalName = (String) value.get(FIELD_GL_JOURNAL_NAME);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		isPosted = (String) value.get(FIELD_IS_POSTED);
		postedDate = (Timestamp) value.get(FIELD_POSTED_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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