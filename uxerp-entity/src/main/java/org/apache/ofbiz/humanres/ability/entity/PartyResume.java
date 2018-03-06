package org.apache.ofbiz.humanres.ability.entity;

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
public class PartyResume implements Serializable {

	public static final long serialVersionUID = 3264404237501114368L;
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

	public enum Fields {
		resumeId, partyId, contentId, resumeDate, resumeText
	}

	public PartyResume(GenericValue value) {
		resumeId = (String) value.get(Fields.resumeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		contentId = (String) value.get(Fields.contentId.name());
		resumeDate = (Timestamp) value.get(Fields.resumeDate.name());
		resumeText = (String) value.get(Fields.resumeText.name());
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