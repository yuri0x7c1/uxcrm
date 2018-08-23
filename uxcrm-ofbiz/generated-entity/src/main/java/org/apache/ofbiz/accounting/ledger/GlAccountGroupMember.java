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
 * Gl Account Group Member
 */
@FieldNameConstants
public class GlAccountGroupMember implements Serializable {

	public static final long serialVersionUID = 659685680623330304L;
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

	public GlAccountGroupMember(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		glAccountGroupTypeId = (String) value
				.get(FIELD_GL_ACCOUNT_GROUP_TYPE_ID);
		glAccountGroupId = (String) value.get(FIELD_GL_ACCOUNT_GROUP_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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