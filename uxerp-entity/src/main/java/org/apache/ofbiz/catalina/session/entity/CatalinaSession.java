package org.apache.ofbiz.catalina.session.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Catalina Session
 */
public class CatalinaSession implements Serializable {

	public static final long serialVersionUID = 1352401477061500928L;
	public static final String NAME = "CatalinaSession";
	/**
	 * Session Id
	 */
	@Getter
	@Setter
	private String sessionId;
	/**
	 * Session Size
	 */
	@Getter
	@Setter
	private Long sessionSize;
	/**
	 * Session Info
	 */
	@Getter
	@Setter
	private Blob sessionInfo;
	/**
	 * Is Valid
	 */
	@Getter
	@Setter
	private String isValid;
	/**
	 * Max Idle
	 */
	@Getter
	@Setter
	private Long maxIdle;
	/**
	 * Last Accessed
	 */
	@Getter
	@Setter
	private Long lastAccessed;

	public enum Fields {
		sessionId, sessionSize, sessionInfo, isValid, maxIdle, lastAccessed
	}

	public CatalinaSession(GenericValue value) {
		sessionId = (String) value.get(Fields.sessionId.name());
		sessionSize = (Long) value.get(Fields.sessionSize.name());
		sessionInfo = (Blob) value.get(Fields.sessionInfo.name());
		isValid = (String) value.get(Fields.isValid.name());
		maxIdle = (Long) value.get(Fields.maxIdle.name());
		lastAccessed = (Long) value.get(Fields.lastAccessed.name());
	}

	public static CatalinaSession fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CatalinaSession(value);
	}

	public static List<CatalinaSession> fromValues(List<GenericValue> values) {
		List<CatalinaSession> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CatalinaSession(value));
		}
		return entities;
	}
}