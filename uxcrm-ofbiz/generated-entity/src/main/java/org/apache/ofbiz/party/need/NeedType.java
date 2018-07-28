package org.apache.ofbiz.party.need;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Need Type
 */
public class NeedType implements Serializable {

	public static final long serialVersionUID = 699906775643580416L;
	public static final String NAME = "NeedType";
	/**
	 * Need Type Id
	 */
	@Getter
	@Setter
	private String needTypeId;
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
		needTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public NeedType(GenericValue value) {
		needTypeId = (String) value.get(Fields.needTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static NeedType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new NeedType(value);
	}

	public static List<NeedType> fromValues(List<GenericValue> values) {
		List<NeedType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new NeedType(value));
		}
		return entities;
	}
}