package org.apache.ofbiz.webapp.visit;

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
public class ServerHitBin implements Serializable {

	public static final long serialVersionUID = 994809362269258752L;
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

	public enum Fields {
		serverHitBinId, contentId, hitTypeId, serverIpAddress, serverHostName, binStartDateTime, binEndDateTime, numberHits, totalTimeMillis, minTimeMillis, maxTimeMillis, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp, internalContentId
	}

	public ServerHitBin(GenericValue value) {
		serverHitBinId = (String) value.get(Fields.serverHitBinId.name());
		contentId = (String) value.get(Fields.contentId.name());
		hitTypeId = (String) value.get(Fields.hitTypeId.name());
		serverIpAddress = (String) value.get(Fields.serverIpAddress.name());
		serverHostName = (String) value.get(Fields.serverHostName.name());
		binStartDateTime = (Timestamp) value
				.get(Fields.binStartDateTime.name());
		binEndDateTime = (Timestamp) value.get(Fields.binEndDateTime.name());
		numberHits = (Long) value.get(Fields.numberHits.name());
		totalTimeMillis = (Long) value.get(Fields.totalTimeMillis.name());
		minTimeMillis = (Long) value.get(Fields.minTimeMillis.name());
		maxTimeMillis = (Long) value.get(Fields.maxTimeMillis.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
		internalContentId = (String) value.get(Fields.internalContentId.name());
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