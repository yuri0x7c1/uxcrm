package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Group Member
 */
public class GlAccountGroupMember implements Serializable {

	public static final long serialVersionUID = 6199387983199363072L;
	public static final String NAME = "GlAccountGroupMember";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Gl Account Group Type Id
	 */
	@Getter
	@Setter
	private String glAccountGroupTypeId;
	/**
	 * Gl Account Group Id
	 */
	@Getter
	@Setter
	private String glAccountGroupId;

	public enum Fields {
		glAccountId, glAccountGroupTypeId, glAccountGroupId
	}

	public GlAccountGroupMember(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountGroupTypeId = (String) value.get(Fields.glAccountGroupTypeId
				.name());
		glAccountGroupId = (String) value.get(Fields.glAccountGroupId.name());
	}

	public static GlAccountGroupMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountGroupMember(value);
	}

	public static List<GlAccountGroupMember> fromValues(
			List<GenericValue> values) {
		List<GlAccountGroupMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountGroupMember(value));
		}
		return entities;
	}
}