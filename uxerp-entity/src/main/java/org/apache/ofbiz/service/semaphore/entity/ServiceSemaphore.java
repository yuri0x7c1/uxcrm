package org.apache.ofbiz.service.semaphore.entity;

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

	public static final long serialVersionUID = 5022338549092257792L;
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

	public enum Fields {
		serviceName, lockedByInstanceId, lockThread, lockTime
	}

	public ServiceSemaphore(GenericValue value) {
		serviceName = (String) value.get(Fields.serviceName.name());
		lockedByInstanceId = (String) value.get(Fields.lockedByInstanceId
				.name());
		lockThread = (String) value.get(Fields.lockThread.name());
		lockTime = (Timestamp) value.get(Fields.lockTime.name());
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