package org.apache.ofbiz.accounting.ledger;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Resource Type
 */
public class GlResourceType implements Serializable {

	public static final long serialVersionUID = 8340686502942688256L;
	public static final String NAME = "GlResourceType";
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
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
		glResourceTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GlResourceType(GenericValue value) {
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static GlResourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlResourceType(value);
	}

	public static List<GlResourceType> fromValues(List<GenericValue> values) {
		List<GlResourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlResourceType(value));
		}
		return entities;
	}
}