package org.apache.ofbiz.product.product.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.product.product.VendorProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.product.store.ProductStoreGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class VendorProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public VendorProductBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count VendorProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(VendorProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find VendorProducts
	 */
	public List<VendorProduct> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<VendorProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(VendorProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VendorProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one VendorProduct
	 */
	public Optional<VendorProduct> findOne(Object productId,
			Object vendorPartyId, Object productStoreGroupId) {
		List<VendorProduct> entityList = null;
		In in = new In();
		in.setEntityName(VendorProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("vendorPartyId", EntityOperator.EQUALS,
						vendorPartyId), new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, productStoreGroupId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VendorProduct.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get product
	 */
	public Optional<Product> getProduct(VendorProduct vendorProduct) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						vendorProduct.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get vendor party
	 */
	public Optional<Party> getVendorParty(VendorProduct vendorProduct) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						vendorProduct.getVendorPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
						.fromValues(out.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get product store group
	 */
	public Optional<ProductStoreGroup> getProductStoreGroup(
			VendorProduct vendorProduct) {
		List<ProductStoreGroup> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, vendorProduct
								.getProductStoreGroupId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreGroup.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}
}