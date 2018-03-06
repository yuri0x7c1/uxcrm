package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Content Type
 */
public class OrderContentType implements Serializable {

	public static final long serialVersionUID = 5729845079328681984L;
	public static final String NAME = "OrderContentType";
	/**
	 * Order Content Type Id
	 */
	@Getter
	@Setter
	private String orderContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		orderContentTypeId, parentTypeId, hasTable, description
	}

	public OrderContentType(GenericValue value) {
		orderContentTypeId = (String) value.get(Fields.orderContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderContentType(value);
	}

	public static List<OrderContentType> fromValues(List<GenericValue> values) {
		List<OrderContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderContentType(value));
		}
		return entities;
	}
}