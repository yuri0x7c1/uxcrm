package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Facility Appl
 */
public class AgreementFacilityAppl implements Serializable {

	public static final long serialVersionUID = 5490791618509548544L;
	public static final String NAME = "AgreementFacilityAppl";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
		agreementId, agreementItemSeqId, facilityId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AgreementFacilityAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AgreementFacilityAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementFacilityAppl(value);
	}

	public static List<AgreementFacilityAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementFacilityAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementFacilityAppl(value));
		}
		return entities;
	}
}