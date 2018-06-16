package org.apache.ofbiz.service.semaphore;

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
public class ServiceSemaphore implements Serializable {

	public static final long serialVersionUID = 6983672628390825984L;
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

	public enum Fields {
		serviceName, lockedByInstanceId, lockThread, lockTime, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ServiceSemaphore(GenericValue value) {
		serviceName = (String) value.get(Fields.serviceName.name());
		lockedByInstanceId = (String) value.get(Fields.lockedByInstanceId
				.name());
		lockThread = (String) value.get(Fields.lockThread.name());
		lockTime = (Timestamp) value.get(Fields.lockTime.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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