package org.apache.ofbiz.entity.audit.entity;

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
public class EntityAuditLog implements Serializable {

	public static final long serialVersionUID = 8768926434203277312L;
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

	public enum Fields {
		auditHistorySeqId, changedEntityName, changedFieldName, pkCombinedValueText, oldValueText, newValueText, changedDate, changedByInfo, changedSessionInfo
	}

	public EntityAuditLog(GenericValue value) {
		auditHistorySeqId = (String) value.get(Fields.auditHistorySeqId.name());
		changedEntityName = (String) value.get(Fields.changedEntityName.name());
		changedFieldName = (String) value.get(Fields.changedFieldName.name());
		pkCombinedValueText = (String) value.get(Fields.pkCombinedValueText
				.name());
		oldValueText = (String) value.get(Fields.oldValueText.name());
		newValueText = (String) value.get(Fields.newValueText.name());
		changedDate = (Timestamp) value.get(Fields.changedDate.name());
		changedByInfo = (String) value.get(Fields.changedByInfo.name());
		changedSessionInfo = (String) value.get(Fields.changedSessionInfo
				.name());
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