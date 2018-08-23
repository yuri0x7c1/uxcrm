package org.apache.ofbiz.service.semaphore;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Service Semaphore
 */
@FieldNameConstants
public class ServiceSemaphore implements Serializable {

	public static final long serialVersionUID = 1938294269131914240L;
	public static final String NAME = "ServiceSemaphore";
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Locked By Instance Id
	 */
	@Getter
	@Setter
	private String lockedByInstanceId;
	/**
	 * Lock Thread
	 */
	@Getter
	@Setter
	private String lockThread;
	/**
	 * Lock Time
	 */
	@Getter
	@Setter
	private Timestamp lockTime;
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

	public ServiceSemaphore(GenericValue value) {
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		lockedByInstanceId = (String) value.get(FIELD_LOCKED_BY_INSTANCE_ID);
		lockThread = (String) value.get(FIELD_LOCK_THREAD);
		lockTime = (Timestamp) value.get(FIELD_LOCK_TIME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ServiceSemaphore fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ServiceSemaphore(value);
	}

	public static List<ServiceSemaphore> fromValues(List<GenericValue> values) {
		List<ServiceSemaphore> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ServiceSemaphore(value));
		}
		return entities;
	}
}