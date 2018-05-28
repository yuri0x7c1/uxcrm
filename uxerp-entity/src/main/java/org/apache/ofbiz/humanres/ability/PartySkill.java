package org.apache.ofbiz.humanres.ability;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Skill
 */
public class PartySkill implements Serializable {

	public static final long serialVersionUID = 2929330065464909824L;
	public static final String NAME = "PartySkill";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Skill Type Id
	 */
	@Getter
	@Setter
	private String skillTypeId;
	/**
	 * Years Experience
	 */
	@Getter
	@Setter
	private Long yearsExperience;
	/**
	 * Rating
	 */
	@Getter
	@Setter
	private Long rating;
	/**
	 * Skill Level
	 */
	@Getter
	@Setter
	private Long skillLevel;
	/**
	 * Started Using Date
	 */
	@Getter
	@Setter
	private Timestamp startedUsingDate;
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
		partyId, skillTypeId, yearsExperience, rating, skillLevel, startedUsingDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartySkill(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		yearsExperience = (Long) value.get(Fields.yearsExperience.name());
		rating = (Long) value.get(Fields.rating.name());
		skillLevel = (Long) value.get(Fields.skillLevel.name());
		startedUsingDate = (Timestamp) value
				.get(Fields.startedUsingDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartySkill fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartySkill(value);
	}

	public static List<PartySkill> fromValues(List<GenericValue> values) {
		List<PartySkill> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartySkill(value));
		}
		return entities;
	}
}