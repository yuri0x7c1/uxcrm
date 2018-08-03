package org.apache.ofbiz.common.method.service.base;

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
import org.apache.ofbiz.common.method.CustomMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.method.CustomMethodType;
import org.apache.ofbiz.content.content.Content;
import org.apache.ofbiz.product.cost.CostComponentCalc;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetDepMethod;
import org.apache.ofbiz.accounting.ledger.PartyAcctgPreference;
import org.apache.ofbiz.product.product.ProductAssoc;
import org.apache.ofbiz.product.price.ProductPrice;
import org.apache.ofbiz.product.store.ProductStorePaymentSetting;
import org.apache.ofbiz.product.store.ProductStoreShipmentMeth;
import org.apache.ofbiz.common.uom.UomConversion;
import org.apache.ofbiz.common.uom.UomConversionDated;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CustomMethodBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CustomMethodBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CustomMethods
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CustomMethods
	 */
	public List<CustomMethod> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CustomMethod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
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
				entityList = CustomMethod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CustomMethod
	 */
	public Optional<CustomMethod> findOne(Object customMethodId) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						customMethodId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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
	 * Get custom method type
	 */
	public Optional<CustomMethodType> getCustomMethodType(
			CustomMethod customMethod) {
		List<CustomMethodType> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethodType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodTypeId",
						EntityOperator.EQUALS, customMethod
								.getCustomMethodTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethodType.fromValues(out.getListIt()
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
	 * Get contents
	 */
	public List<Content> getContents(CustomMethod customMethod, Integer start,
			Integer number, List<String> orderBy) {
		List<Content> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Content.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						customMethod.getCustomMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Content.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cost component calcs
	 */
	public List<CostComponentCalc> getCostComponentCalcs(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<CostComponentCalc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponentCalc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("costCustomMethodId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentCalc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset dep methods
	 */
	public List<FixedAssetDepMethod> getFixedAssetDepMethods(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetDepMethod> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetDepMethod.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("depreciationCustomMethodId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetDepMethod.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice party acctg preferences
	 */
	public List<PartyAcctgPreference> getInvoicePartyAcctgPreferences(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("invoiceSeqCustMethId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote party acctg preferences
	 */
	public List<PartyAcctgPreference> getQuotePartyAcctgPreferences(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("quoteSeqCustMethId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order party acctg preferences
	 */
	public List<PartyAcctgPreference> getOrderPartyAcctgPreferences(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("orderSeqCustMethId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product assocs
	 */
	public List<ProductAssoc> getProductAssocs(CustomMethod customMethod,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("estimateCalcMethod",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product prices
	 */
	public List<ProductPrice> getProductPrices(CustomMethod customMethod,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("customPriceCalcService",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store payment settings
	 */
	public List<ProductStorePaymentSetting> getProductStorePaymentSettings(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStorePaymentSetting> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStorePaymentSetting.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("paymentCustomMethodId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStorePaymentSetting.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store shipment meths
	 */
	public List<ProductStoreShipmentMeth> getProductStoreShipmentMeths(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreShipmentMeth> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreShipmentMeth.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("shipmentCustomMethodId",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreShipmentMeth.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get uom custom method uom conversions
	 */
	public List<UomConversion> getUomCustomMethodUomConversions(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<UomConversion> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UomConversion.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						customMethod.getCustomMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UomConversion.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get uom custom method uom conversion dateds
	 */
	public List<UomConversionDated> getUomCustomMethodUomConversionDateds(
			CustomMethod customMethod, Integer start, Integer number,
			List<String> orderBy) {
		List<UomConversionDated> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UomConversionDated.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						customMethod.getCustomMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UomConversionDated.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work efforts
	 */
	public List<WorkEffort> getWorkEfforts(CustomMethod customMethod,
			Integer start, Integer number, List<String> orderBy) {
		List<WorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("estimateCalcMethod",
						EntityOperator.EQUALS, customMethod.getCustomMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}