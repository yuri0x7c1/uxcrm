package org.apache.ofbiz.accounting.finaccount;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans Type Attr
 */
public class FinAccountTransTypeAttr implements Serializable {

	public static final long serialVersionUID = 5172068698101416960L;
	public static final String NAME = "FinAccountTransTypeAttr";
	/**
	 * Fin Account Trans Type Id
	 */
	@Getter
	@Setter
	private String finAccountTransTypeId;
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
		finAccountTransTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FinAccountTransTypeAttr(GenericValue value) {
		finAccountTransTypeId = (String) value.get(Fields.finAccountTransTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FinAccountTransTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTransTypeAttr(value);
	}

	public static List<FinAccountTransTypeAttr> fromValues(
			List<GenericValue> values) {
		List<FinAccountTransTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTransTypeAttr(value));
		}
		return entities;
	}
}