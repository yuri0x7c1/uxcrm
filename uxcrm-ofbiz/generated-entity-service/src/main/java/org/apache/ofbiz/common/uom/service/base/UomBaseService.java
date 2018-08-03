package org.apache.ofbiz.common.uom.service.base;

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
import org.apache.ofbiz.common.uom.Uom;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.uom.UomType;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.accounting.payment.BillingAccount;
import org.apache.ofbiz.accounting.payment.BillingAccountTerm;
import org.apache.ofbiz.product.cost.CostComponent;
import org.apache.ofbiz.product.cost.CostComponentCalc;
import org.apache.ofbiz.order.request.CustRequest;
import org.apache.ofbiz.product.facility.Facility;
import org.apache.ofbiz.accounting.finaccount.FinAccount;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetProduct;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetStdCost;
import org.apache.ofbiz.common.geo.GeoPoint;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.marketing.campaign.MarketingCampaign;
import org.apache.ofbiz.workeffort.timesheet.OldPartyRate;
import org.apache.ofbiz.order.order.OrderDeliverySchedule;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.order.order.OrderTerm;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.ledger.PartyAcctgPreference;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.payment.PaymentGatewayResponse;
import org.apache.ofbiz.common.period.PeriodType;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.product.ProductContent;
import org.apache.ofbiz.product.feature.ProductFeature;
import org.apache.ofbiz.product.price.ProductFeaturePrice;
import org.apache.ofbiz.product.product.ProductMaint;
import org.apache.ofbiz.product.product.ProductMeter;
import org.apache.ofbiz.product.product.ProductMeterType;
import org.apache.ofbiz.product.price.ProductPrice;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.product.subscription.ProductSubscriptionResource;
import org.apache.ofbiz.order.quote.Quote;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.accounting.rate.RateAmount;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.marketing.opportunity.SalesForecast;
import org.apache.ofbiz.marketing.opportunity.SalesForecastDetail;
import org.apache.ofbiz.marketing.opportunity.SalesForecastHistory;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunityHistory;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.ShipmentBoxType;
import org.apache.ofbiz.shipment.shipment.ShipmentCostEstimate;
import org.apache.ofbiz.shipment.shipment.ShipmentPackage;
import org.apache.ofbiz.shipment.shipment.ShipmentPackageRouteSeg;
import org.apache.ofbiz.shipment.shipment.ShipmentRouteSegment;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.product.supplier.SupplierProduct;
import org.apache.ofbiz.product.supplier.SupplierProductFeature;
import org.apache.ofbiz.common.uom.UomConversion;
import org.apache.ofbiz.common.uom.UomConversionDated;
import org.apache.ofbiz.common.uom.UomGroup;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class UomBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public UomBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Uoms
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Uom.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Uoms
	 */
	public List<Uom> find(Integer start, Integer number, List<String> orderBy,
			EntityConditionList conditions) {
		List<Uom> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Uom.NAME);
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
				entityList = Uom.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Uom
	 */
	public Optional<Uom> findOne(Object uomId) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uomId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get uom type
	 */
	public Optional<UomType> getUomType(Uom uom) {
		List<UomType> entityList = null;
		In in = new In();
		in.setEntityName(UomType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomTypeId", EntityOperator.EQUALS, uom
						.getUomTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UomType.fromValues(out.getListIt()
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
	 * Get currency acctg trans entries
	 */
	public List<AcctgTransEntry> getCurrencyAcctgTransEntries(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<AcctgTransEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get orig currency acctg trans entries
	 */
	public List<AcctgTransEntry> getOrigCurrencyAcctgTransEntries(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<AcctgTransEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("origCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get billing accounts
	 */
	public List<BillingAccount> getBillingAccounts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<BillingAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("accountCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get billing account terms
	 */
	public List<BillingAccountTerm> getBillingAccountTerms(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<BillingAccountTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BillingAccountTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BillingAccountTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency cost components
	 */
	public List<CostComponent> getCurrencyCostComponents(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<CostComponent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponent.fromValues(out.getListIt()
						.getPartialList(start, number));
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
	public List<CostComponentCalc> getCostComponentCalcs(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
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
	 * Get maximum amount cust requests
	 */
	public List<CustRequest> getMaximumAmountCustRequests(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<CustRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("maximumAmountUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency cust requests
	 */
	public List<CustRequest> getCurrencyCustRequests(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<CustRequest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CustRequest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustRequest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get dimension facilities
	 */
	public List<Facility> getDimensionFacilities(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Facility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Facility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultDimensionUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get weight facilities
	 */
	public List<Facility> getWeightFacilities(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Facility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Facility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultWeightUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get facility size facilities
	 */
	public List<Facility> getFacilitySizeFacilities(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Facility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Facility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilitySizeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Facility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency fin accounts
	 */
	public List<FinAccount> getCurrencyFinAccounts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<FinAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed assets
	 */
	public List<FixedAsset> getFixedAssets(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<FixedAsset> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get interval fixed asset maints
	 */
	public List<FixedAssetMaint> getIntervalFixedAssetMaints(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetMaint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("intervalUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset products
	 */
	public List<FixedAssetProduct> getFixedAssetProducts(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset std costs
	 */
	public List<FixedAssetStdCost> getFixedAssetStdCosts(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAssetStdCost> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetStdCost.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("amountUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetStdCost.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get elevation geo points
	 */
	public List<GeoPoint> getElevationGeoPoints(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<GeoPoint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GeoPoint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("elevationUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GeoPoint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get inventory items
	 */
	public List<InventoryItem> getInventoryItems(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<InventoryItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency inventory items
	 */
	public List<InventoryItem> getCurrencyInventoryItems(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<InventoryItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency invoices
	 */
	public List<Invoice> getCurrencyInvoices(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Invoice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Invoice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Invoice.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get invoice items
	 */
	public List<InvoiceItem> getInvoiceItems(Uom uom, Integer start,
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
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get marketing campaigns
	 */
	public List<MarketingCampaign> getMarketingCampaigns(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<MarketingCampaign> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaign.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaign.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency old party rates
	 */
	public List<OldPartyRate> getCurrencyOldPartyRates(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<OldPartyRate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldPartyRate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldPartyRate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get total cubic order delivery schedules
	 */
	public List<OrderDeliverySchedule> getTotalCubicOrderDeliverySchedules(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<OrderDeliverySchedule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderDeliverySchedule.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("totalCubicUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderDeliverySchedule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get total weight order delivery schedules
	 */
	public List<OrderDeliverySchedule> getTotalWeightOrderDeliverySchedules(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<OrderDeliverySchedule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderDeliverySchedule.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("totalWeightUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderDeliverySchedule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order headers
	 */
	public List<OrderHeader> getOrderHeaders(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderHeader> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUom", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get recurring freq order items
	 */
	public List<OrderItem> getRecurringFreqOrderItems(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurringFreqUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order terms
	 */
	public List<OrderTerm> getOrderTerms(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get parties
	 */
	public List<Party> getParties(Uom uom, Integer start, Integer number,
			List<String> orderBy) {
		List<Party> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Party.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("preferredCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party acctg preferences
	 */
	public List<PartyAcctgPreference> getPartyAcctgPreferences(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("baseCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
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
	 * Get currency payments
	 */
	public List<Payment> getCurrencyPayments(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Payment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get actual currency payments
	 */
	public List<Payment> getActualCurrencyPayments(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Payment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Payment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("actualCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment gateway responses
	 */
	public List<PaymentGatewayResponse> getPaymentGatewayResponses(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<PaymentGatewayResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentGatewayResponse.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentGatewayResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get period types
	 */
	public List<PeriodType> getPeriodTypes(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<PeriodType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PeriodType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PeriodType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quantity products
	 */
	public List<Product> getQuantityProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get weight products
	 */
	public List<Product> getWeightProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("weightUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get height products
	 */
	public List<Product> getHeightProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("heightUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get width products
	 */
	public List<Product> getWidthProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("widthUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get depth products
	 */
	public List<Product> getDepthProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("depthUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get diameter products
	 */
	public List<Product> getDiameterProducts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Product> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Product.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("diameterUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get use time product contents
	 */
	public List<ProductContent> getUseTimeProductContents(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("useTimeUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product features
	 */
	public List<ProductFeature> getProductFeatures(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency product feature prices
	 */
	public List<ProductFeaturePrice> getCurrencyProductFeaturePrices(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductFeaturePrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeaturePrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeaturePrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get interval product maints
	 */
	public List<ProductMaint> getIntervalProductMaints(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductMaint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMaint.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("intervalUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMaint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get meter product meters
	 */
	public List<ProductMeter> getMeterProductMeters(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMeter.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("meterUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get default product meter types
	 */
	public List<ProductMeterType> getDefaultProductMeterTypes(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductMeterType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMeterType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency product prices
	 */
	public List<ProductPrice> getCurrencyProductPrices(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
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
	 * Get term product prices
	 */
	public List<ProductPrice> getTermProductPrices(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get product stores
	 */
	public List<ProductStore> getProductStores(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("defaultCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get use time product subscription resources
	 */
	public List<ProductSubscriptionResource> getUseTimeProductSubscriptionResources(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("useTimeUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cancel time product subscription resources
	 */
	public List<ProductSubscriptionResource> getCancelTimeProductSubscriptionResources(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("canclAutmExtTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get available time product subscription resources
	 */
	public List<ProductSubscriptionResource> getAvailableTimeProductSubscriptionResources(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("availableTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get max life time product subscription resources
	 */
	public List<ProductSubscriptionResource> getMaxLifeTimeProductSubscriptionResources(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("maxLifeTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get grace period product subscription resources
	 */
	public List<ProductSubscriptionResource> getGracePeriodProductSubscriptionResources(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ProductSubscriptionResource> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductSubscriptionResource.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("gracePeriodOnExpiryUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductSubscriptionResource.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quotes
	 */
	public List<Quote> getQuotes(Uom uom, Integer start, Integer number,
			List<String> orderBy) {
		List<Quote> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Quote.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Quote.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote items
	 */
	public List<QuoteItem> getQuoteItems(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get rate amounts
	 */
	public List<RateAmount> getRateAmounts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<RateAmount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RateAmount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateCurrencyUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateAmount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return headers
	 */
	public List<ReturnHeader> getReturnHeaders(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnHeader> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales forecasts
	 */
	public List<SalesForecast> getSalesForecasts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<SalesForecast> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecast.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecast.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quantity sales forecast details
	 */
	public List<SalesForecastDetail> getQuantitySalesForecastDetails(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecastDetail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecastDetail.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecastDetail.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales forecast histories
	 */
	public List<SalesForecastHistory> getSalesForecastHistories(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesForecastHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesForecastHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesForecastHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales opportunities
	 */
	public List<SalesOpportunity> getSalesOpportunities(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<SalesOpportunity> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunity.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunity.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales opportunity histories
	 */
	public List<SalesOpportunityHistory> getSalesOpportunityHistories(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SalesOpportunityHistory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SalesOpportunityHistory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunityHistory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency shipments
	 */
	public List<Shipment> getCurrencyShipments(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Shipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Shipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get dimension shipment box types
	 */
	public List<ShipmentBoxType> getDimensionShipmentBoxTypes(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentBoxType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentBoxType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dimensionUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentBoxType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get weight shipment box types
	 */
	public List<ShipmentBoxType> getWeightShipmentBoxTypes(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentBoxType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentBoxType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("weightUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentBoxType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get weight shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getWeightShipmentCostEstimates(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("weightUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quantity shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getQuantityShipmentCostEstimates(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get price shipment cost estimates
	 */
	public List<ShipmentCostEstimate> getPriceShipmentCostEstimates(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentCostEstimate> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentCostEstimate.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("priceUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentCostEstimate.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get dimension shipment packages
	 */
	public List<ShipmentPackage> getDimensionShipmentPackages(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentPackage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentPackage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("dimensionUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get weight shipment packages
	 */
	public List<ShipmentPackage> getWeightShipmentPackages(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentPackage> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentPackage.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("weightUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackage.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency shipment package route segs
	 */
	public List<ShipmentPackageRouteSeg> getCurrencyShipmentPackageRouteSegs(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ShipmentPackageRouteSeg> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentPackageRouteSeg.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackageRouteSeg.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency shipment route segments
	 */
	public List<ShipmentRouteSegment> getCurrencyShipmentRouteSegments(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentRouteSegment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get billing weight shipment route segments
	 */
	public List<ShipmentRouteSegment> getBillingWeightShipmentRouteSegments(
			Uom uom, Integer start, Integer number, List<String> orderBy) {
		List<ShipmentRouteSegment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentRouteSegment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("billingWeightUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentRouteSegment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get use time subscriptions
	 */
	public List<Subscription> getUseTimeSubscriptions(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("useTimeUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cancel time subscriptions
	 */
	public List<Subscription> getCancelTimeSubscriptions(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("canclAutmExtTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get available time subscriptions
	 */
	public List<Subscription> getAvailableTimeSubscriptions(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("availableTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get max life time subscriptions
	 */
	public List<Subscription> getMaxLifeTimeSubscriptions(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("maxLifeTimeUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get grace period subscriptions
	 */
	public List<Subscription> getGracePeriodSubscriptions(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("gracePeriodOnExpiryUomId",
						EntityOperator.EQUALS, uom.getUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get currency supplier products
	 */
	public List<SupplierProduct> getCurrencySupplierProducts(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SupplierProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quantity supplier products
	 */
	public List<SupplierProduct> getQuantitySupplierProducts(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SupplierProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quantityUomId", EntityOperator.EQUALS,
						uom.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get supplier product features
	 */
	public List<SupplierProductFeature> getSupplierProductFeatures(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
		List<SupplierProductFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SupplierProductFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SupplierProductFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get main uom conversions
	 */
	public List<UomConversion> getMainUomConversions(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get conv to uom conversions
	 */
	public List<UomConversion> getConvToUomConversions(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("uomIdTo", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get dated main uom conversion dateds
	 */
	public List<UomConversionDated> getDatedMainUomConversionDateds(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get dated conv to uom conversion dateds
	 */
	public List<UomConversionDated> getDatedConvToUomConversionDateds(Uom uom,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("uomIdTo", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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
	 * Get uom groups
	 */
	public List<UomGroup> getUomGroups(Uom uom, Integer start, Integer number,
			List<String> orderBy) {
		List<UomGroup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(UomGroup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UomGroup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get money work efforts
	 */
	public List<WorkEffort> getMoneyWorkEfforts(Uom uom, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("moneyUomId", EntityOperator.EQUALS, uom
						.getUomId())), EntityOperator.AND));
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