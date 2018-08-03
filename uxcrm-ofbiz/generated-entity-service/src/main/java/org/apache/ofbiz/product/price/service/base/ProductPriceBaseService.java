package org.apache.ofbiz.product.price.service.base;

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
import org.apache.ofbiz.product.price.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.price.ProductPriceType;
import org.apache.ofbiz.product.price.ProductPricePurpose;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.product.store.ProductStoreGroup;
import org.apache.ofbiz.common.method.CustomMethod;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.product.price.ProductPriceChange;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPriceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPriceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPrices
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPrices
	 */
	public List<ProductPrice> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one ProductPrice
	 */
	public Optional<ProductPrice> findOne(Object productId,
			Object productPriceTypeId, Object productPricePurposeId,
			Object currencyUomId, Object productStoreGroupId, Object fromDate) {
		List<ProductPrice> entityList = null;
		In in = new In();
		in.setEntityName(ProductPrice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productId),
				new EntityExpr("productPriceTypeId", EntityOperator.EQUALS,
						productPriceTypeId), new EntityExpr(
						"productPricePurposeId", EntityOperator.EQUALS,
						productPricePurposeId), new EntityExpr("currencyUomId",
						EntityOperator.EQUALS, currencyUomId), new EntityExpr(
						"productStoreGroupId", EntityOperator.EQUALS,
						productStoreGroupId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPrice.fromValues(out.getListIt()
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
	public Optional<Product> getProduct(ProductPrice productPrice) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productPrice.getProductId())), EntityOperator.AND));
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
	 * Get product price type
	 */
	public Optional<ProductPriceType> getProductPriceType(
			ProductPrice productPrice) {
		List<ProductPriceType> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceTypeId",
						EntityOperator.EQUALS, productPrice
								.getProductPriceTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceType.fromValues(out.getListIt()
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
	 * Get product price purpose
	 */
	public Optional<ProductPricePurpose> getProductPricePurpose(
			ProductPrice productPrice) {
		List<ProductPricePurpose> entityList = null;
		In in = new In();
		in.setEntityName(ProductPricePurpose.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPricePurposeId",
						EntityOperator.EQUALS, productPrice
								.getProductPricePurposeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPricePurpose.fromValues(out.getListIt()
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
	 * Get currency uom
	 */
	public Optional<Uom> getCurrencyUom(ProductPrice productPrice) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						productPrice.getCurrencyUomId())), EntityOperator.AND));
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
	 * Get term uom
	 */
	public Optional<Uom> getTermUom(ProductPrice productPrice) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						productPrice.getTermUomId())), EntityOperator.AND));
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
	 * Get product store group
	 */
	public Optional<ProductStoreGroup> getProductStoreGroup(
			ProductPrice productPrice) {
		List<ProductStoreGroup> entityList = null;
		In in = new In();
		in.setEntityName(ProductStoreGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreGroupId",
						EntityOperator.EQUALS, productPrice
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

	/**
	 * Get custom method
	 */
	public Optional<CustomMethod> getCustomMethod(ProductPrice productPrice) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						productPrice.getCustomPriceCalcService())),
				EntityOperator.AND));
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
	 * Get tax authority party
	 */
	public Optional<Party> getTaxAuthorityParty(ProductPrice productPrice) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						productPrice.getTaxAuthPartyId())), EntityOperator.AND));
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
	 * Get tax authority geo
	 */
	public Optional<Geo> getTaxAuthorityGeo(ProductPrice productPrice) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						productPrice.getTaxAuthGeoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get created by user login
	 */
	public Optional<UserLogin> getCreatedByUserLogin(ProductPrice productPrice) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						productPrice.getCreatedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get last modified by user login
	 */
	public Optional<UserLogin> getLastModifiedByUserLogin(
			ProductPrice productPrice) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						productPrice.getLastModifiedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get product price changes
	 */
	public List<ProductPriceChange> getProductPriceChanges(
			ProductPrice productPrice, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPriceChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS, productPrice
						.getProductId()),
				new EntityExpr("productPriceTypeId", EntityOperator.EQUALS,
						productPrice.getProductPriceTypeId()),
				new EntityExpr("productPricePurposeId", EntityOperator.EQUALS,
						productPrice.getProductPricePurposeId()),
				new EntityExpr("currencyUomId", EntityOperator.EQUALS,
						productPrice.getCurrencyUomId()),
				new EntityExpr("productStoreGroupId", EntityOperator.EQUALS,
						productPrice.getProductStoreGroupId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS, productPrice
						.getFromDate())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}