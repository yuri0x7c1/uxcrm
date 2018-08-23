package org.apache.ofbiz.webapp.visit;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Server Hit Bin
 */
@FieldNameConstants
public class ServerHitBin implements Serializable {

	public static final long serialVersionUID = 4813974047726545920L;
	public static final String NAME = "ServerHitBin";
	/**
	 * Server Hit Bin Id
	 */
	@Getter
	@Setter
	private String serverHitBinId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Hit Type Id
	 */
	@Getter
	@Setter
	private String hitTypeId;
	/**
	 * Server Ip Address
	 */
	@Getter
	@Setter
	private String serverIpAddress;
	/**
	 * Server Host Name
	 */
	@Getter
	@Setter
	private String serverHostName;
	/**
	 * Bin Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp binStartDateTime;
	/**
	 * Bin End Date Time
	 */
	@Getter
	@Setter
	private Timestamp binEndDateTime;
	/**
	 * Number Hits
	 */
	@Getter
	@Setter
	private Long numberHits;
	/**
	 * Total Time Millis
	 */
	@Getter
	@Setter
	private Long totalTimeMillis;
	/**
	 * Min Time Millis
	 */
	@Getter
	@Setter
	private Long minTimeMillis;
	/**
	 * Max Time Millis
	 */
	@Getter
	@Setter
	private Long maxTimeMillis;
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
	/**
	 * Internal Content Id
	 */
	@Getter
	@Setter
	private String internalContentId;

	public ServerHitBin(GenericValue value) {
		serverHitBinId = (String) value.get(FIELD_SERVER_HIT_BIN_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		hitTypeId = (String) value.get(FIELD_HIT_TYPE_ID);
		serverIpAddress = (String) value.get(FIELD_SERVER_IP_ADDRESS);
		serverHostName = (String) value.get(FIELD_SERVER_HOST_NAME);
		binStartDateTime = (Timestamp) value.get(FIELD_BIN_START_DATE_TIME);
		binEndDateTime = (Timestamp) value.get(FIELD_BIN_END_DATE_TIME);
		numberHits = (Long) value.get(FIELD_NUMBER_HITS);
		totalTimeMillis = (Long) value.get(FIELD_TOTAL_TIME_MILLIS);
		minTimeMillis = (Long) value.get(FIELD_MIN_TIME_MILLIS);
		maxTimeMillis = (Long) value.get(FIELD_MAX_TIME_MILLIS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		internalContentId = (String) value.get(FIELD_INTERNAL_CONTENT_ID);
	}

	public static ServerHitBin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ServerHitBin(value);
	}

	public static List<ServerHitBin> fromValues(List<GenericValue> values) {
		List<ServerHitBin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ServerHitBin(value));
		}
		return entities;
	}
}