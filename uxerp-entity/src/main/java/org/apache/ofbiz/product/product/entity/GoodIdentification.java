package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Good Identification
 */
public class GoodIdentification implements Serializable {

	public static final long serialVersionUID = 8924219737085134848L;
	public static final String NAME = "GoodIdentification";
	/**
	 * Good Identification Type Id
	 */
	@Getter
	@Setter
	private String goodIdentificationTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;

	public enum Fields {
		goodIdentificationTypeId, productId, idValue
	}

	public GoodIdentification(GenericValue value) {
		goodIdentificationTypeId = (String) value
				.get(Fields.goodIdentificationTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		idValue = (String) value.get(Fields.idValue.name());
	}

	public static GoodIdentification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GoodIdentification(value);
	}

	public static List<GoodIdentification> fromValues(List<GenericValue> values) {
		List<GoodIdentification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GoodIdentification(value));
		}
		return entities;
	}
}