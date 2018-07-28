package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Category Type
 */
public class GlAccountCategoryType implements Serializable {

	public static final long serialVersionUID = 2448166067673877504L;
	public static final String NAME = "GlAccountCategoryType";
	/**
	 * Gl Account Category Type Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryTypeId;
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
		glAccountCategoryTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountCategoryType(GenericValue value) {
		glAccountCategoryTypeId = (String) value
				.get(Fields.glAccountCategoryTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlAccountCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountCategoryType(value);
	}

	public static List<GlAccountCategoryType> fromValues(
			List<GenericValue> values) {
		List<GlAccountCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountCategoryType(value));
		}
		return entities;
	}
}