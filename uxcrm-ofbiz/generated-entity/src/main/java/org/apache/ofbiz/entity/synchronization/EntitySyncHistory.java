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
 * Entity Sync History
 */
@FieldNameConstants
public class EntitySyncHistory implements Serializable {

	public static final long serialVersionUID = 5618339037524047872L;
	public static final String NAME = "EntitySyncHistory";
	/**
	 * Entity Sync Id
	 */
	@Getter
	@Setter
	private String entitySyncId;
	/**
	 * Start Date
	 */
	@Getter
	@Setter
	private Timestamp startDate;
	/**
	 * Run Status Id
	 */
	@Getter
	@Setter
	private String runStatusId;
	/**
	 * Beginning Synch Time
	 */
	@Getter
	@Setter
	private Timestamp beginningSynchTime;
	/**
	 * Last Successful Synch Time
	 */
	@Getter
	@Setter
	private Timestamp lastSuccessfulSynchTime;
	/**
	 * Last Candidate End Time
	 */
	@Getter
	@Setter
	private Timestamp lastCandidateEndTime;
	/**
	 * Last Split Start Time
	 */
	@Getter
	@Setter
	private Long lastSplitStartTime;
	/**
	 * To Create Inserted
	 */
	@Getter
	@Setter
	private Long toCreateInserted;
	/**
	 * To Create Updated
	 */
	@Getter
	@Setter
	private Long toCreateUpdated;
	/**
	 * To Create Not Updated
	 */
	@Getter
	@Setter
	private Long toCreateNotUpdated;
	/**
	 * To Store Inserted
	 */
	@Getter
	@Setter
	private Long toStoreInserted;
	/**
	 * To Store Updated
	 */
	@Getter
	@Setter
	private Long toStoreUpdated;
	/**
	 * To Store Not Updated
	 */
	@Getter
	@Setter
	private Long toStoreNotUpdated;
	/**
	 * To Remove Deleted
	 */
	@Getter
	@Setter
	private Long toRemoveDeleted;
	/**
	 * To Remove Already Deleted
	 */
	@Getter
	@Setter
	private Long toRemoveAlreadyDeleted;
	/**
	 * Total Rows Exported
	 */
	@Getter
	@Setter
	private Long totalRowsExported;
	/**
	 * Total Rows To Create
	 */
	@Getter
	@Setter
	private Long totalRowsToCreate;
	/**
	 * Total Rows To Store
	 */
	@Getter
	@Setter
	private Long totalRowsToStore;
	/**
	 * Total Rows To Remove
	 */
	@Getter
	@Setter
	private Long totalRowsToRemove;
	/**
	 * Total Splits
	 */
	@Getter
	@Setter
	private Long totalSplits;
	/**
	 * Total Store Calls
	 */
	@Getter
	@Setter
	private Long totalStoreCalls;
	/**
	 * Running Time Millis
	 */
	@Getter
	@Setter
	private Long runningTimeMillis;
	/**
	 * Per Split Min Millis
	 */
	@Getter
	@Setter
	private Long perSplitMinMillis;
	/**
	 * Per Split Max Millis
	 */
	@Getter
	@Setter
	private Long perSplitMaxMillis;
	/**
	 * Per Split Min Items
	 */
	@Getter
	@Setter
	private Long perSplitMinItems;
	/**
	 * Per Split Max Items
	 */
	@Getter
	@Setter
	private Long perSplitMaxItems;
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

	public EntitySyncHistory(GenericValue value) {
		entitySyncId = (String) value.get(FIELD_ENTITY_SYNC_ID);
		startDate = (Timestamp) value.get(FIELD_START_DATE);
		runStatusId = (String) value.get(FIELD_RUN_STATUS_ID);
		beginningSynchTime = (Timestamp) value.get(FIELD_BEGINNING_SYNCH_TIME);
		lastSuccessfulSynchTime = (Timestamp) value
				.get(FIELD_LAST_SUCCESSFUL_SYNCH_TIME);
		lastCandidateEndTime = (Timestamp) value
				.get(FIELD_LAST_CANDIDATE_END_TIME);
		lastSplitStartTime = (Long) value.get(FIELD_LAST_SPLIT_START_TIME);
		toCreateInserted = (Long) value.get(FIELD_TO_CREATE_INSERTED);
		toCreateUpdated = (Long) value.get(FIELD_TO_CREATE_UPDATED);
		toCreateNotUpdated = (Long) value.get(FIELD_TO_CREATE_NOT_UPDATED);
		toStoreInserted = (Long) value.get(FIELD_TO_STORE_INSERTED);
		toStoreUpdated = (Long) value.get(FIELD_TO_STORE_UPDATED);
		toStoreNotUpdated = (Long) value.get(FIELD_TO_STORE_NOT_UPDATED);
		toRemoveDeleted = (Long) value.get(FIELD_TO_REMOVE_DELETED);
		toRemoveAlreadyDeleted = (Long) value
				.get(FIELD_TO_REMOVE_ALREADY_DELETED);
		totalRowsExported = (Long) value.get(FIELD_TOTAL_ROWS_EXPORTED);
		totalRowsToCreate = (Long) value.get(FIELD_TOTAL_ROWS_TO_CREATE);
		totalRowsToStore = (Long) value.get(FIELD_TOTAL_ROWS_TO_STORE);
		totalRowsToRemove = (Long) value.get(FIELD_TOTAL_ROWS_TO_REMOVE);
		totalSplits = (Long) value.get(FIELD_TOTAL_SPLITS);
		totalStoreCalls = (Long) value.get(FIELD_TOTAL_STORE_CALLS);
		runningTimeMillis = (Long) value.get(FIELD_RUNNING_TIME_MILLIS);
		perSplitMinMillis = (Long) value.get(FIELD_PER_SPLIT_MIN_MILLIS);
		perSplitMaxMillis = (Long) value.get(FIELD_PER_SPLIT_MAX_MILLIS);
		perSplitMinItems = (Long) value.get(FIELD_PER_SPLIT_MIN_ITEMS);
		perSplitMaxItems = (Long) value.get(FIELD_PER_SPLIT_MAX_ITEMS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EntitySyncHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EntitySyncHistory(value);
	}

	public static List<EntitySyncHistory> fromValues(List<GenericValue> values) {
		List<EntitySyncHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EntitySyncHistory(value));
		}
		return entities;
	}
}