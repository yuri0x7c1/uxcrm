package org.apache.ofbiz.accounting.ledger;

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
public class GlAccountGroup implements Serializable {

	public static final long serialVersionUID = 8667354141898663936L;
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

	public enum Fields {
		glAccountGroupId, glAccountGroupTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountGroup(GenericValue value) {
		glAccountGroupId = (String) value.get(Fields.glAccountGroupId.name());
		glAccountGroupTypeId = (String) value.get(Fields.glAccountGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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