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
 * Party Qual
 */
@FieldNameConstants
public class PartyQual implements Serializable {

	public static final long serialVersionUID = 6224496466935313408L;
	public static final String NAME = "PartyQual";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Qual Type Id
	 */
	@Getter
	@Setter
	private String partyQualTypeId;
	/**
	 * Qualification Desc
	 */
	@Getter
	@Setter
	private String qualificationDesc;
	/**
	 * Title
	 */
	@Getter
	@Setter
	private String title;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Verif Status Id
	 */
	@Getter
	@Setter
	private String verifStatusId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public PartyQual(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyQualTypeId = (String) value.get(FIELD_PARTY_QUAL_TYPE_ID);
		qualificationDesc = (String) value.get(FIELD_QUALIFICATION_DESC);
		title = (String) value.get(FIELD_TITLE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		verifStatusId = (String) value.get(FIELD_VERIF_STATUS_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyQual fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyQual(value);
	}

	public static List<PartyQual> fromValues(List<GenericValue> values) {
		List<PartyQual> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyQual(value));
		}
		return entities;
	}
}