package org.apache.ofbiz.humanres.ability;

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
public class PartyQual implements Serializable {

	public static final long serialVersionUID = 1216469535303409664L;
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

	public enum Fields {
		partyId, partyQualTypeId, qualificationDesc, title, statusId, verifStatusId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyQual(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyQualTypeId = (String) value.get(Fields.partyQualTypeId.name());
		qualificationDesc = (String) value.get(Fields.qualificationDesc.name());
		title = (String) value.get(Fields.title.name());
		statusId = (String) value.get(Fields.statusId.name());
		verifStatusId = (String) value.get(Fields.verifStatusId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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