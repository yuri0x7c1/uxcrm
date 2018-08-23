package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Server Hit Type
 */
@FieldNameConstants
public class ServerHitType implements Serializable {

	public static final long serialVersionUID = 5411514809202105344L;
	public static final String NAME = "ServerHitType";
	/**
	 * Hit Type Id
	 */
	@Getter
	@Setter
	private String hitTypeId;
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

	public ServerHitType(GenericValue value) {
		hitTypeId = (String) value.get(FIELD_HIT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ServerHitType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ServerHitType(value);
	}

	public static List<ServerHitType> fromValues(List<GenericValue> values) {
		List<ServerHitType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ServerHitType(value));
		}
		return entities;
	}
}