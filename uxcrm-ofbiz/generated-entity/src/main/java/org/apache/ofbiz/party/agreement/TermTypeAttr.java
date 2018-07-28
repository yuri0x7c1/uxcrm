package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Term Type Attr
 */
public class TermTypeAttr implements Serializable {

	public static final long serialVersionUID = 5219618360298283008L;
	public static final String NAME = "TermTypeAttr";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		termTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TermTypeAttr(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TermTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TermTypeAttr(value);
	}

	public static List<TermTypeAttr> fromValues(List<GenericValue> values) {
		List<TermTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TermTypeAttr(value));
		}
		return entities;
	}
}