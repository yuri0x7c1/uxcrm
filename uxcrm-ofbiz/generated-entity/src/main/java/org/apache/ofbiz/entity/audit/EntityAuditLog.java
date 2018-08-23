package org.apache.ofbiz.entity.audit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Audit Log
 */
@FieldNameConstants
public class EntityAuditLog implements Serializable {

	public static final long serialVersionUID = 312696769796760576L;
	public static final String NAME = "EntityAuditLog";
	/**
	 * Audit History Seq Id
	 */
	@Getter
	@Setter
	private String auditHistorySeqId;
	/**
	 * Changed Entity Name
	 */
	@Getter
	@Setter
	private String changedEntityName;
	/**
	 * Changed Field Name
	 */
	@Getter
	@Setter
	private String changedFieldName;
	/**
	 * Pk Combined Value Text
	 */
	@Getter
	@Setter
	private String pkCombinedValueText;
	/**
	 * Old Value Text
	 */
	@Getter
	@Setter
	private String oldValueText;
	/**
	 * New Value Text
	 */
	@Getter
	@Setter
	private String newValueText;
	/**
	 * Changed Date
	 */
	@Getter
	@Setter
	private Timestamp changedDate;
	/**
	 * Changed By Info
	 */
	@Getter
	@Setter
	private String changedByInfo;
	/**
	 * Changed Session Info
	 */
	@Getter
	@Setter
	private String changedSessionInfo;
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

	public EntityAuditLog(GenericValue value) {
		auditHistorySeqId = (String) value.get(FIELD_AUDIT_HISTORY_SEQ_ID);
		changedEntityName = (String) value.get(FIELD_CHANGED_ENTITY_NAME);
		changedFieldName = (String) value.get(FIELD_CHANGED_FIELD_NAME);
		pkCombinedValueText = (String) value.get(FIELD_PK_COMBINED_VALUE_TEXT);
		oldValueText = (String) value.get(FIELD_OLD_VALUE_TEXT);
		newValueText = (String) value.get(FIELD_NEW_VALUE_TEXT);
		changedDate = (Timestamp) value.get(FIELD_CHANGED_DATE);
		changedByInfo = (String) value.get(FIELD_CHANGED_BY_INFO);
		changedSessionInfo = (String) value.get(FIELD_CHANGED_SESSION_INFO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EntityAuditLog fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntityAuditLog(value);
	}

	public static List<EntityAuditLog> fromValues(List<GenericValue> values) {
		List<EntityAuditLog> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntityAuditLog(value));
		}
		return entities;
	}
}