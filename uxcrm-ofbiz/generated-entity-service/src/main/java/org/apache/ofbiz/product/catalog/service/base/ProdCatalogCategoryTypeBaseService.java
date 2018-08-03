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
import org.apache.ofbiz.product.catalog.ProdCatalogCategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.catalog.ProdCatalogCategory;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProdCatalogCategoryTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProdCatalogCategoryTypeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProdCatalogCategoryTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProdCatalogCategoryType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProdCatalogCategoryTypes
	 */
	public List<ProdCatalogCategoryType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProdCatalogCategoryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogCategoryType.NAME);
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
				entityList = ProdCatalogCategoryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProdCatalogCategoryType
	 */
	public Optional<ProdCatalogCategoryType> findOne(
			Object prodCatalogCategoryTypeId) {
		List<ProdCatalogCategoryType> entityList = null;
		In in = new In();
		in.setEntityName(ProdCatalogCategoryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogCategoryTypeId",
						EntityOperator.EQUALS, prodCatalogCategoryTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogCategoryType.fromValues(out.getListIt()
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
	 * Get parent prod catalog category type
	 */
	public Optional<ProdCatalogCategoryType> getParentProdCatalogCategoryType(
			ProdCatalogCategoryType prodCatalogCategoryType) {
		List<ProdCatalogCategoryType> entityList = null;
		In in = new In();
		in.setEntityName(ProdCatalogCategoryType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("prodCatalogCategoryTypeId",
						EntityOperator.EQUALS, prodCatalogCategoryType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogCategoryType.fromValues(out.getListIt()
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
	 * Get prod catalog categories
	 */
	public List<ProdCatalogCategory> getProdCatalogCategories(
			ProdCatalogCategoryType prodCatalogCategoryType, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("prodCatalogCategoryTypeId",
						EntityOperator.EQUALS, prodCatalogCategoryType
								.getProdCatalogCategoryTypeId())),
				EntityOperator.AND));
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
	 * Get child prod catalog category types
	 */
	public List<ProdCatalogCategoryType> getChildProdCatalogCategoryTypes(
			ProdCatalogCategoryType prodCatalogCategoryType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProdCatalogCategoryType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProdCatalogCategoryType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentTypeId",
						EntityOperator.EQUALS, prodCatalogCategoryType
								.getProdCatalogCategoryTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProdCatalogCategoryType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}