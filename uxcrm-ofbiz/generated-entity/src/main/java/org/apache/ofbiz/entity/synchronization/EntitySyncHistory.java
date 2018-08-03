package org.apache.ofbiz.entity.synchronization;

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
public class EntitySyncHistory implements Serializable {

	public static final long serialVersionUID = 4553571739466802176L;
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

	public enum Fields {
		entitySyncId, startDate, runStatusId, beginningSynchTime, lastSuccessfulSynchTime, lastCandidateEndTime, lastSplitStartTime, toCreateInserted, toCreateUpdated, toCreateNotUpdated, toStoreInserted, toStoreUpdated, toStoreNotUpdated, toRemoveDeleted, toRemoveAlreadyDeleted, totalRowsExported, totalRowsToCreate, totalRowsToStore, totalRowsToRemove, totalSplits, totalStoreCalls, runningTimeMillis, perSplitMinMillis, perSplitMaxMillis, perSplitMinItems, perSplitMaxItems, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EntitySyncHistory(GenericValue value) {
		entitySyncId = (String) value.get(Fields.entitySyncId.name());
		startDate = (Timestamp) value.get(Fields.startDate.name());
		runStatusId = (String) value.get(Fields.runStatusId.name());
		beginningSynchTime = (Timestamp) value.get(Fields.beginningSynchTime
				.name());
		lastSuccessfulSynchTime = (Timestamp) value
				.get(Fields.lastSuccessfulSynchTime.name());
		lastCandidateEndTime = (Timestamp) value
				.get(Fields.lastCandidateEndTime.name());
		lastSplitStartTime = (Long) value.get(Fields.lastSplitStartTime.name());
		toCreateInserted = (Long) value.get(Fields.toCreateInserted.name());
		toCreateUpdated = (Long) value.get(Fields.toCreateUpdated.name());
		toCreateNotUpdated = (Long) value.get(Fields.toCreateNotUpdated.name());
		toStoreInserted = (Long) value.get(Fields.toStoreInserted.name());
		toStoreUpdated = (Long) value.get(Fields.toStoreUpdated.name());
		toStoreNotUpdated = (Long) value.get(Fields.toStoreNotUpdated.name());
		toRemoveDeleted = (Long) value.get(Fields.toRemoveDeleted.name());
		toRemoveAlreadyDeleted = (Long) value.get(Fields.toRemoveAlreadyDeleted
				.name());
		totalRowsExported = (Long) value.get(Fields.totalRowsExported.name());
		totalRowsToCreate = (Long) value.get(Fields.totalRowsToCreate.name());
		totalRowsToStore = (Long) value.get(Fields.totalRowsToStore.name());
		totalRowsToRemove = (Long) value.get(Fields.totalRowsToRemove.name());
		totalSplits = (Long) value.get(Fields.totalSplits.name());
		totalStoreCalls = (Long) value.get(Fields.totalStoreCalls.name());
		runningTimeMillis = (Long) value.get(Fields.runningTimeMillis.name());
		perSplitMinMillis = (Long) value.get(Fields.perSplitMinMillis.name());
		perSplitMaxMillis = (Long) value.get(Fields.perSplitMaxMillis.name());
		perSplitMinItems = (Long) value.get(Fields.perSplitMinItems.name());
		perSplitMaxItems = (Long) value.get(Fields.perSplitMaxItems.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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