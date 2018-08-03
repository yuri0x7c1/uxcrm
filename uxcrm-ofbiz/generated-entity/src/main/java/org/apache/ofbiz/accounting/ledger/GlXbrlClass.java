package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Xbrl Class
 */
public class GlXbrlClass implements Serializable {

	public static final long serialVersionUID = 67897438855521280L;
	public static final String NAME = "GlXbrlClass";
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
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
		glXbrlClassId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlXbrlClass(GenericValue value) {
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlXbrlClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlXbrlClass(value);
	}

	public static List<GlXbrlClass> fromValues(List<GenericValue> values) {
		List<GlXbrlClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlXbrlClass(value));
		}
		return entities;
	}
}