package org.apache.ofbiz.product.product;

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
 * Product Maint
 */
@FieldNameConstants
public class ProductMaint implements Serializable {

	public static final long serialVersionUID = 6544249201913036800L;
	public static final String NAME = "ProductMaint";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Maint Seq Id
	 */
	@Getter
	@Setter
	private String productMaintSeqId;
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Maint Name
	 */
	@Getter
	@Setter
	private String maintName;
	/**
	 * Maint Template Work Effort Id
	 */
	@Getter
	@Setter
	private String maintTemplateWorkEffortId;
	/**
	 * Interval Quantity
	 */
	@Getter
	@Setter
	private BigDecimal intervalQuantity;
	/**
	 * Interval Uom Id
	 */
	@Getter
	@Setter
	private String intervalUomId;
	/**
	 * Interval Meter Type Id
	 */
	@Getter
	@Setter
	private String intervalMeterTypeId;
	/**
	 * Repeat Count
	 */
	@Getter
	@Setter
	private Long repeatCount;
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

	public ProductMaint(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productMaintSeqId = (String) value.get(FIELD_PRODUCT_MAINT_SEQ_ID);
		productMaintTypeId = (String) value.get(FIELD_PRODUCT_MAINT_TYPE_ID);
		maintName = (String) value.get(FIELD_MAINT_NAME);
		maintTemplateWorkEffortId = (String) value
				.get(FIELD_MAINT_TEMPLATE_WORK_EFFORT_ID);
		intervalQuantity = (BigDecimal) value.get(FIELD_INTERVAL_QUANTITY);
		intervalUomId = (String) value.get(FIELD_INTERVAL_UOM_ID);
		intervalMeterTypeId = (String) value.get(FIELD_INTERVAL_METER_TYPE_ID);
		repeatCount = (Long) value.get(FIELD_REPEAT_COUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductMaint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMaint(value);
	}

	public static List<ProductMaint> fromValues(List<GenericValue> values) {
		List<ProductMaint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMaint(value));
		}
		return entities;
	}
}