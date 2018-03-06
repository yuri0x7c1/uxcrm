package org.apache.ofbiz.humanres.ability.entity;

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

	public static final long serialVersionUID = 3467424847923687424L;
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

	public enum Fields {
		partyId, skillTypeId, yearsExperience, rating, skillLevel, startedUsingDate
	}

	public PartySkill(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		yearsExperience = (Long) value.get(Fields.yearsExperience.name());
		rating = (Long) value.get(Fields.rating.name());
		skillLevel = (Long) value.get(Fields.skillLevel.name());
		startedUsingDate = (Timestamp) value
				.get(Fields.startedUsingDate.name());
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