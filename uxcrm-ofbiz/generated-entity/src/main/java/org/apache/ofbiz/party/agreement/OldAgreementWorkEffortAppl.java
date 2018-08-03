package org.apache.ofbiz.party.agreement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Agreement Work Effort Appl
 */
public class OldAgreementWorkEffortAppl implements Serializable {

	public static final long serialVersionUID = 97060736514655232L;
	public static final String NAME = "OldAgreementWorkEffortAppl";
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
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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
		agreementId, agreementItemSeqId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldAgreementWorkEffortAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldAgreementWorkEffortAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldAgreementWorkEffortAppl(value);
	}

	public static List<OldAgreementWorkEffortAppl> fromValues(
			List<GenericValue> values) {
		List<OldAgreementWorkEffortAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldAgreementWorkEffortAppl(value));
		}
		return entities;
	}
}