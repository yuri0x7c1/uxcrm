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
 * Gl Account Group
 */
@FieldNameConstants
public class GlAccountGroup implements Serializable {

	public static final long serialVersionUID = 9146330345475627008L;
	public static final String NAME = "GlAccountGroup";
	/**
	 * Gl Account Group Id
	 */
	@Getter
	@Setter
	private String glAccountGroupId;
	/**
	 * Gl Account Group Type Id
	 */
	@Getter
	@Setter
	private String glAccountGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public GlAccountGroup(GenericValue value) {
		glAccountGroupId = (String) value.get(FIELD_GL_ACCOUNT_GROUP_ID);
		glAccountGroupTypeId = (String) value
				.get(FIELD_GL_ACCOUNT_GROUP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlAccountGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountGroup(value);
	}

	public static List<GlAccountGroup> fromValues(List<GenericValue> values) {
		List<GlAccountGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountGroup(value));
		}
		return entities;
	}
}