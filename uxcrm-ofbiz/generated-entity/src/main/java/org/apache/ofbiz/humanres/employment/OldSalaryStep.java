package org.apache.ofbiz.humanres.employment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Salary Step
 */
public class OldSalaryStep implements Serializable {

	public static final long serialVersionUID = 1551583850432359424L;
	public static final String NAME = "OldSalaryStep";
	/**
	 * Salary Step Seq Id
	 */
	@Getter
	@Setter
	private String salaryStepSeqId;
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
	/**
	 * Date Modified
	 */
	@Getter
	@Setter
	private Timestamp dateModified;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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
		salaryStepSeqId, payGradeId, dateModified, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldSalaryStep(GenericValue value) {
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		dateModified = (Timestamp) value.get(Fields.dateModified.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldSalaryStep fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldSalaryStep(value);
	}

	public static List<OldSalaryStep> fromValues(List<GenericValue> values) {
		List<OldSalaryStep> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldSalaryStep(value));
		}
		return entities;
	}
}