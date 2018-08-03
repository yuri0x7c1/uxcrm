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
import org.apache.ofbiz.product.category.ProductCategoryAndMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategoryMember;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.product.product.Product;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductCategoryAndMemberBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductCategoryAndMemberBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductCategoryAndMembers
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductCategoryAndMember.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductCategoryAndMembers
	 */
	public List<ProductCategoryAndMember> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductCategoryAndMember> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryAndMember.NAME);
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
				entityList = ProductCategoryAndMember.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductCategoryAndMember
	 */
	public Optional<ProductCategoryAndMember> findOne(Object productCategoryId,
			Object fromDate, Object productId) {
		List<ProductCategoryAndMember> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryAndMember.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate), new EntityExpr(
						"productId", EntityOperator.EQUALS, productId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryAndMember.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get product category member
	 */
	public Optional<ProductCategoryMember> getProductCategoryMember(
			ProductCategoryAndMember productCategoryAndMember) {
		List<ProductCategoryMember> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryMember.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryAndMember.getProductCategoryId()),
				new EntityExpr("productId", EntityOperator.EQUALS,
						productCategoryAndMember.getProductId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productCategoryAndMember.getFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryMember.fromValues(out.getListIt()
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
			ProductCategoryAndMember productCategoryAndMember) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategoryAndMember
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
	 * Get product
	 */
	public Optional<Product> getProduct(
			ProductCategoryAndMember productCategoryAndMember) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productCategoryAndMember.getProductId())),
				EntityOperator.AND));
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
}