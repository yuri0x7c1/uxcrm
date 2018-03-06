package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deduction
 */
public class Deduction implements Serializable {

	public static final long serialVersionUID = 5472322370886579200L;
	public static final String NAME = "Deduction";
	/**
	 * Deduction Id
	 */
	@Getter
	@Setter
	private String deductionId;
	/**
	 * Deduction Type Id
	 */
	@Getter
	@Setter
	private String deductionTypeId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public enum Fields {
		deductionId, deductionTypeId, paymentId, amount
	}

	public Deduction(GenericValue value) {
		deductionId = (String) value.get(Fields.deductionId.name());
		deductionTypeId = (String) value.get(Fields.deductionTypeId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static Deduction fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Deduction(value);
	}

	public static List<Deduction> fromValues(List<GenericValue> values) {
		List<Deduction> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Deduction(value));
		}
		return entities;
	}
}