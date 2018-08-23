package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Resume
 */
@FieldNameConstants
public class PartyResume implements Serializable {

	public static final long serialVersionUID = 4926179745829370880L;
	public static final String NAME = "PartyResume";
	/**
	 * Resume Id
	 */
	@Getter
	@Setter
	private String resumeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Resume Date
	 */
	@Getter
	@Setter
	private Timestamp resumeDate;
	/**
	 * Resume Text
	 */
	@Getter
	@Setter
	private String resumeText;
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

	public PartyResume(GenericValue value) {
		resumeId = (String) value.get(FIELD_RESUME_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		resumeDate = (Timestamp) value.get(FIELD_RESUME_DATE);
		resumeText = (String) value.get(FIELD_RESUME_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyResume fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyResume(value);
	}

	public static List<PartyResume> fromValues(List<GenericValue> values) {
		List<PartyResume> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyResume(value));
		}
		return entities;
	}
}