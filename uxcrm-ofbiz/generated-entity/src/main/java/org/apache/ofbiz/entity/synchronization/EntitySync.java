package org.apache.ofbiz.entity.synchronization;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity Sync
 */
public class EntitySync implements Serializable {

	public static final long serialVersionUID = 7841577058953101312L;
	public static final String NAME = "EntitySync";
	/**
	 * Entity Sync Id
	 */
	@Getter
	@Setter
	private String entitySyncId;
	/**
	 * Run Status Id
	 */
	@Getter
	@Setter
	private String runStatusId;
	/**
	 * Last Successful Synch Time
	 */
	@Getter
	@Setter
	private Timestamp lastSuccessfulSynchTime;
	/**
	 * Last History Start Date
	 */
	@Getter
	@Setter
	private Timestamp lastHistoryStartDate;
	/**
	 * Pre Offline Synch Time
	 */
	@Getter
	@Setter
	private Timestamp preOfflineSynchTime;
	/**
	 * Offline Sync Split Millis
	 */
	@Getter
	@Setter
	private Long offlineSyncSplitMillis;
	/**
	 * Sync Split Millis
	 */
	@Getter
	@Setter
	private Long syncSplitMillis;
	/**
	 * Sync End Buffer Millis
	 */
	@Getter
	@Setter
	private Long syncEndBufferMillis;
	/**
	 * Max Running No Update Millis
	 */
	@Getter
	@Setter
	private Long maxRunningNoUpdateMillis;
	/**
	 * Target Service Name
	 */
	@Getter
	@Setter
	private String targetServiceName;
	/**
	 * Target Delegator Name
	 */
	@Getter
	@Setter
	private String targetDelegatorName;
	/**
	 * Keep Remove Info Hours
	 */
	@Getter
	@Setter
	private Double keepRemoveInfoHours;
	/**
	 * For Pull Only
	 */
	@Getter
	@Setter
	private String forPullOnly;
	/**
	 * For Push Only
	 */
	@Getter
	@Setter
	private String forPushOnly;
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
		entitySyncId, runStatusId, lastSuccessfulSynchTime, lastHistoryStartDate, preOfflineSynchTime, offlineSyncSplitMillis, syncSplitMillis, syncEndBufferMillis, maxRunningNoUpdateMillis, targetServiceName, targetDelegatorName, keepRemoveInfoHours, forPullOnly, forPushOnly, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntitySync(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		runStatusId = (String) value.get(Fields.runStatusId.name());
		lastSuccessfulSynchTime = (Timestamp) value
				.get(Fields.lastSuccessfulSynchTime.name());
		lastHistoryStartDate = (Timestamp) value
				.get(Fields.lastHistoryStartDate.name());
		preOfflineSynchTime = (Timestamp) value.get(Fields.preOfflineSynchTime
				.name());
		offlineSyncSplitMillis = (Long) value.get(Fields.offlineSyncSplitMillis
				.name());
		syncSplitMillis = (Long) value.get(Fields.syncSplitMillis.name());
		syncEndBufferMillis = (Long) value.get(Fields.syncEndBufferMillis
				.name());
		maxRunningNoUpdateMillis = (Long) value
				.get(Fields.maxRunningNoUpdateMillis.name());
		targetServiceName = (String) value.get(Fields.targetServiceName.name());
		targetDelegatorName = (String) value.get(Fields.targetDelegatorName
				.name());
		keepRemoveInfoHours = (Double) value.get(Fields.keepRemoveInfoHours
				.name());
		forPullOnly = (String) value.get(Fields.forPullOnly.name());
		forPushOnly = (String) value.get(Fields.forPushOnly.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static EntitySync fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySync(value);
	}

	public static List<EntitySync> fromValues(List<GenericValue> values) {
		List<EntitySync> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySync(value));
		}
		return entities;
	}
}