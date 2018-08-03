package org.apache.ofbiz.product.category.service.base;

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
import org.apache.ofbiz.product.category.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategoryType;
import org.apache.ofbiz.product.category.ProductCategoryTypeAttr;
import org.apache.ofbiz.product.supplier.MarketInterest;
import org.apache.ofbiz.product.product.OldProductKeywordResult;
import org.apache.ofbiz.party.need.PartyNeed;
import org.apache.ofbiz.product.catalog.ProdCatalogCategory;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.category.ProductCategoryAttribute;
import org.apache.ofbiz.product.category.ProductCategoryContent;
import org.apache.ofbiz.product.category.ProductCategoryGlAccount;
import org.apache.ofbiz.product.category.ProductCategoryLink;
import org.apache.ofbiz.product.category.ProductCategoryMember;
import org.apache.ofbiz.product.category.ProductCategoryRole;
import org.apache.ofbiz.product.category.ProductCategoryRollup;
import org.apache.ofbiz.product.feature.ProductFeatureCatGrpAppl;
import org.apache.ofbiz.product.feature.ProductFeatureCategoryAppl;
import org.apache.ofbiz.product.promo.ProductPromoCategory;
import org.apache.ofbiz.product.store.ProductStoreSurveyAppl;
import org.apache.ofbiz.marketing.opportunity.SalesForecastDetail;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.accounting.tax.TaxAuthorityCategory;
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductCategoryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductCategoryBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductCategories
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductCategories
	 */
	public List<ProductCategory> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
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
				entityList = ProductCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductCategory
	 */
	public Optional<ProductCategory> findOne(Object productCategoryId) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategoryId)),
				EntityOperator.AND));
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
	 * Get product category type
	 */
	public Optional<ProductCategoryType> getProductCategoryType(
			ProductCategory productCategory) {
		List<ProductCategoryType> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryType.fromValues(out.getListIt()
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
	 * Get product category type attrs
	 */
	public List<ProductCategoryTypeAttr> getProductCategoryTypeAttrs(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryTypeId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get primary parent product category
	 */
	public Optional<ProductCategory> getPrimaryParentProductCategory(
			ProductCategory productCategory) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getPrimaryParentCategoryId())),
				EntityOperator.AND));
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
	 * Get primary child product categories
	 */
	public List<ProductCategory> getPrimaryChildProductCategories(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("primaryParentCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get market interests
	 */
	public List<MarketInterest> getMarketInterests(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketInterest> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketInterest.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketInterest.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old product keyword results
	 */
	public List<OldProductKeywordResult> getOldProductKeywordResults(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<OldProductKeywordResult> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldProductKeywordResult.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldProductKeywordResult.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get party needs
	 */
	public List<PartyNeed> getPartyNeeds(ProductCategory productCategory,
			Integer start, Integer number, List<String> orderBy) {
		List<PartyNeed> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyNeed.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyNeed.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get prod catalog categories
	 */
	public List<ProdCatalogCategory> getProdCatalogCategories(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProdCatalogCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get primary products
	 */
	public List<Product> getPrimaryProducts(ProductCategory productCategory,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("primaryProductCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
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
	 * Get product category attributes
	 */
	public List<ProductCategoryAttribute> getProductCategoryAttributes(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryAttribute.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category contents
	 */
	public List<ProductCategoryContent> getProductCategoryContents(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category gl accounts
	 */
	public List<ProductCategoryGlAccount> getProductCategoryGlAccounts(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryGlAccount.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category links
	 */
	public List<ProductCategoryLink> getProductCategoryLinks(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryLink> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryLink.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryLink.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category members
	 */
	public List<ProductCategoryMember> getProductCategoryMembers(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryMember.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryMember.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product category roles
	 */
	public List<ProductCategoryRole> getProductCategoryRoles(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get current product category rollups
	 */
	public List<ProductCategoryRollup> getCurrentProductCategoryRollups(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get parent product category rollups
	 */
	public List<ProductCategoryRollup> getParentProductCategoryRollups(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCategoryRollup> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryRollup.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentProductCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryRollup.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product feature cat grp appls
	 */
	public List<ProductFeatureCatGrpAppl> getProductFeatureCatGrpAppls(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFeatureCatGrpAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureCatGrpAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureCatGrpAppl.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product feature category appls
	 */
	public List<ProductFeatureCategoryAppl> getProductFeatureCategoryAppls(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFeatureCategoryAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFeatureCategoryAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFeatureCategoryAppl.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promo categories
	 */
	public List<ProductPromoCategory> getProductPromoCategories(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store survey appls
	 */
	public List<ProductStoreSurveyAppl> getProductStoreSurveyAppls(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreSurveyAppl> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreSurveyAppl.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreSurveyAppl.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sales forecast details
	 */
	public List<SalesForecastDetail> getSalesForecastDetails(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
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
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
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
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(ProductCategory productCategory,
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
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
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
	 * Get tax authority categories
	 */
	public List<TaxAuthorityCategory> getTaxAuthorityCategories(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority rate products
	 */
	public List<TaxAuthorityRateProduct> getTaxAuthorityRateProducts(
			ProductCategory productCategory, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategory
								.getProductCategoryId())), EntityOperator.AND));
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
}