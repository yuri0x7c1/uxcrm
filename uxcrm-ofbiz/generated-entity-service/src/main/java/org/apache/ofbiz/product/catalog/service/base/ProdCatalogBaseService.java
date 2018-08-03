package org.apache.ofbiz.product.catalog.service.base;

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
import org.apache.ofbiz.product.catalog.ProdCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.shoppingcart.CartAbandonedLine;
import org.apache.ofbiz.product.catalog.ProdCatalogCategory;
import org.apache.ofbiz.product.catalog.ProdCatalogInvFacility;
import org.apache.ofbiz.product.catalog.ProdCatalogRole;
import org.apache.ofbiz.product.store.ProductStoreCatalog;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProdCatalogBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProdCatalogBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProdCatalogs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProdCatalog.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProdCatalogs
	 */
	public List<ProdCatalog> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProdCatalog> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalog.NAME);
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
				entityList = ProdCatalog.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProdCatalog
	 */
	public Optional<ProdCatalog> findOne(Object prodCatalogId) {
		List<ProdCatalog> entityList = null;
		In in = new In();
		in.setEntityName(ProdCatalog.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalogId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalog.fromValues(out.getListIt()
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
	 * Get cart abandoned lines
	 */
	public List<CartAbandonedLine> getCartAbandonedLines(
			ProdCatalog prodCatalog, Integer start, Integer number,
			List<String> orderBy) {
		List<CartAbandonedLine> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CartAbandonedLine.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalog.getProdCatalogId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CartAbandonedLine.fromValues(out.getListIt()
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
			ProdCatalog prodCatalog, Integer start, Integer number,
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
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalog.getProdCatalogId())), EntityOperator.AND));
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
	 * Get prod catalog inv facilities
	 */
	public List<ProdCatalogInvFacility> getProdCatalogInvFacilities(
			ProdCatalog prodCatalog, Integer start, Integer number,
			List<String> orderBy) {
		List<ProdCatalogInvFacility> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogInvFacility.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalog.getProdCatalogId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogInvFacility.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get prod catalog roles
	 */
	public List<ProdCatalogRole> getProdCatalogRoles(ProdCatalog prodCatalog,
			Integer start, Integer number, List<String> orderBy) {
		List<ProdCatalogRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalog.getProdCatalogId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product store catalogs
	 */
	public List<ProductStoreCatalog> getProductStoreCatalogs(
			ProdCatalog prodCatalog, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreCatalog> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreCatalog.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogId", EntityOperator.EQUALS,
						prodCatalog.getProdCatalogId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreCatalog.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}