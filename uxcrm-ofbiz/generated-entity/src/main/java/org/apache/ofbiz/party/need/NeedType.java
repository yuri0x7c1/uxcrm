package org.apache.ofbiz.party.need;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class NeedType implements Serializable {

	public static final long serialVersionUID = 5935778444424049664L;
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

	public NeedType(GenericValue value) {
		needTypeId = (String) value.get(FIELD_NEED_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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