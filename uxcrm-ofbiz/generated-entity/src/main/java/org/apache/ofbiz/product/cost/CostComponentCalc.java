package org.apache.ofbiz.product.cost;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component Calc
 */
@FieldNameConstants
public class CostComponentCalc implements Serializable {

	public static final long serialVersionUID = 5455937069781706752L;
	public static final String NAME = "CostComponentCalc";
	/**
	 * Cost Component Calc Id
	 */
	@Getter
	@Setter
	private String costComponentCalcId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Cost Gl Account Type Id
	 */
	@Getter
	@Setter
	private String costGlAccountTypeId;
	/**
	 * Offsetting Gl Account Type Id
	 */
	@Getter
	@Setter
	private String offsettingGlAccountTypeId;
	/**
	 * Fixed Cost
	 */
	@Getter
	@Setter
	private BigDecimal fixedCost;
	/**
	 * Variable Cost
	 */
	@Getter
	@Setter
	private BigDecimal variableCost;
	/**
	 * Per Milli Second
	 */
	@Getter
	@Setter
	private Long perMilliSecond;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Cost Custom Method Id
	 */
	@Getter
	@Setter
	private String costCustomMethodId;
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

	public CostComponentCalc(GenericValue value) {
		costComponentCalcId = (String) value.get(FIELD_COST_COMPONENT_CALC_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		costGlAccountTypeId = (String) value.get(FIELD_COST_GL_ACCOUNT_TYPE_ID);
		offsettingGlAccountTypeId = (String) value
				.get(FIELD_OFFSETTING_GL_ACCOUNT_TYPE_ID);
		fixedCost = (BigDecimal) value.get(FIELD_FIXED_COST);
		variableCost = (BigDecimal) value.get(FIELD_VARIABLE_COST);
		perMilliSecond = (Long) value.get(FIELD_PER_MILLI_SECOND);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		costCustomMethodId = (String) value.get(FIELD_COST_CUSTOM_METHOD_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CostComponentCalc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentCalc(value);
	}

	public static List<CostComponentCalc> fromValues(List<GenericValue> values) {
		List<CostComponentCalc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentCalc(value));
		}
		return entities;
	}
}