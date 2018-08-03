package org.apache.ofbiz.accounting.tax.service.base;

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
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateType;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order._return.ReturnAdjustment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TaxAuthorityRateProductBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TaxAuthorityRateProductBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TaxAuthorityRateProducts
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TaxAuthorityRateProducts
	 */
	public List<TaxAuthorityRateProduct> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TaxAuthorityRateProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
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
				entityList = TaxAuthorityRateProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TaxAuthorityRateProduct
	 */
	public Optional<TaxAuthorityRateProduct> findOne(
			Object taxAuthorityRateSeqId) {
		List<TaxAuthorityRateProduct> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateSeqId",
						EntityOperator.EQUALS, taxAuthorityRateSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateProduct.fromValues(out.getListIt()
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
	 * Get tax authority
	 */
	public Optional<TaxAuthority> getTaxAuthority(
			TaxAuthorityRateProduct taxAuthorityRateProduct) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthorityRateProduct.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthorityRateProduct.getTaxAuthPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthority.fromValues(out.getListIt()
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
	 * Get tax authority rate type
	 */
	public Optional<TaxAuthorityRateType> getTaxAuthorityRateType(
			TaxAuthorityRateProduct taxAuthorityRateProduct) {
		List<TaxAuthorityRateType> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityRateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateTypeId",
						EntityOperator.EQUALS, taxAuthorityRateProduct
								.getTaxAuthorityRateTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateType.fromValues(out.getListIt()
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(
			TaxAuthorityRateProduct taxAuthorityRateProduct) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						taxAuthorityRateProduct.getProductStoreId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	 * Get product category
	 */
	public Optional<ProductCategory> getProductCategory(
			TaxAuthorityRateProduct taxAuthorityRateProduct) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, taxAuthorityRateProduct
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategory.fromValues(out.getListIt()
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
	 * Get invoice items
	 */
	public List<InvoiceItem> getInvoiceItems(
			TaxAuthorityRateProduct taxAuthorityRateProduct, Integer start,
			Integer number, List<String> orderBy) {
		List<InvoiceItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateSeqId",
						EntityOperator.EQUALS, taxAuthorityRateProduct
								.getTaxAuthorityRateSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(
			TaxAuthorityRateProduct taxAuthorityRateProduct, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateSeqId",
						EntityOperator.EQUALS, taxAuthorityRateProduct
								.getTaxAuthorityRateSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return adjustments
	 */
	public List<ReturnAdjustment> getReturnAdjustments(
			TaxAuthorityRateProduct taxAuthorityRateProduct, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateSeqId",
						EntityOperator.EQUALS, taxAuthorityRateProduct
								.getTaxAuthorityRateSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}