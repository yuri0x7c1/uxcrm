package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Group Member
 */
public class GlAccountGroupMember implements Serializable {

	public static final long serialVersionUID = 4958692239060912128L;
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
		glAccountId, glAccountGroupTypeId, glAccountGroupId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountGroupMember(GenericValue value) {
		glAccountId = (String) value.get(Fields.glAccountId.name());
		glAccountGroupTypeId = (String) value.get(Fields.glAccountGroupTypeId
				.name());
		glAccountGroupId = (String) value.get(Fields.glAccountGroupId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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