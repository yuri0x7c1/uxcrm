package org.apache.ofbiz.entity.synchronization;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EntitySync implements Serializable {

	public static final long serialVersionUID = 5364878165476986880L;
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

	public EntitySync(GenericValue value) {
		entitySyncId = (String) value.get(FIELD_ENTITY_SYNC_ID);
		runStatusId = (String) value.get(FIELD_RUN_STATUS_ID);
		lastSuccessfulSynchTime = (Timestamp) value
				.get(FIELD_LAST_SUCCESSFUL_SYNCH_TIME);
		lastHistoryStartDate = (Timestamp) value
				.get(FIELD_LAST_HISTORY_START_DATE);
		preOfflineSynchTime = (Timestamp) value
				.get(FIELD_PRE_OFFLINE_SYNCH_TIME);
		offlineSyncSplitMillis = (Long) value
				.get(FIELD_OFFLINE_SYNC_SPLIT_MILLIS);
		syncSplitMillis = (Long) value.get(FIELD_SYNC_SPLIT_MILLIS);
		syncEndBufferMillis = (Long) value.get(FIELD_SYNC_END_BUFFER_MILLIS);
		maxRunningNoUpdateMillis = (Long) value
				.get(FIELD_MAX_RUNNING_NO_UPDATE_MILLIS);
		targetServiceName = (String) value.get(FIELD_TARGET_SERVICE_NAME);
		targetDelegatorName = (String) value.get(FIELD_TARGET_DELEGATOR_NAME);
		keepRemoveInfoHours = (Double) value.get(FIELD_KEEP_REMOVE_INFO_HOURS);
		forPullOnly = (String) value.get(FIELD_FOR_PULL_ONLY);
		forPushOnly = (String) value.get(FIELD_FOR_PUSH_ONLY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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