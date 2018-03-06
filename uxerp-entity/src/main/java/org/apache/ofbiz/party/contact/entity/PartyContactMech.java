package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Contact Mech
 */
public class PartyContactMech implements Serializable {

	public static final long serialVersionUID = 4042355550365753344L;
	public static final String NAME = "PartyContactMech";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Verified
	 */
	@Getter
	@Setter
	private String verified;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Years With Contact Mech
	 */
	@Getter
	@Setter
	private Long yearsWithContactMech;
	/**
	 * Months With Contact Mech
	 */
	@Getter
	@Setter
	private Long monthsWithContactMech;

	public enum Fields {
		partyId, contactMechId, fromDate, thruDate, roleTypeId, allowSolicitation, extension, verified, comments, yearsWithContactMech, monthsWithContactMech
	}

	public PartyContactMech(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
		extension = (String) value.get(Fields.extension.name());
		verified = (String) value.get(Fields.verified.name());
		comments = (String) value.get(Fields.comments.name());
		yearsWithContactMech = (Long) value.get(Fields.yearsWithContactMech
				.name());
		monthsWithContactMech = (Long) value.get(Fields.monthsWithContactMech
				.name());
	}

	public static PartyContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContactMech(value);
	}

	public static List<PartyContactMech> fromValues(List<GenericValue> values) {
		List<PartyContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContactMech(value));
		}
		return entities;
	}
}