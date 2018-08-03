package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Class
 */
public class GlAccountClass implements Serializable {

	public static final long serialVersionUID = 8732948357757047808L;
	public static final String NAME = "GlAccountClass";
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Parent Class Id
	 */
	@Getter
	@Setter
	private String parentClassId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Asset Class
	 */
	@Getter
	@Setter
	private String isAssetClass;
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
		glAccountClassId, parentClassId, description, isAssetClass, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlAccountClass(GenericValue value) {
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		parentClassId = (String) value.get(Fields.parentClassId.name());
		description = (String) value.get(Fields.description.name());
		isAssetClass = (String) value.get(Fields.isAssetClass.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlAccountClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountClass(value);
	}

	public static List<GlAccountClass> fromValues(List<GenericValue> values) {
		List<GlAccountClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountClass(value));
		}
		return entities;
	}
}