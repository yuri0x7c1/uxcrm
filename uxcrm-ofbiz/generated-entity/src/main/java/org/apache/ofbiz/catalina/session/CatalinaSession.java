package org.apache.ofbiz.catalina.session;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Blob;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Catalina Session
 */
@FieldNameConstants
public class CatalinaSession implements Serializable {

	public static final long serialVersionUID = 6140151854697433088L;
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

	public CatalinaSession(GenericValue value) {
		sessionId = (String) value.get(FIELD_SESSION_ID);
		sessionSize = (Long) value.get(FIELD_SESSION_SIZE);
		sessionInfo = (Blob) value.get(FIELD_SESSION_INFO);
		isValid = (String) value.get(FIELD_IS_VALID);
		maxIdle = (Long) value.get(FIELD_MAX_IDLE);
		lastAccessed = (Long) value.get(FIELD_LAST_ACCESSED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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