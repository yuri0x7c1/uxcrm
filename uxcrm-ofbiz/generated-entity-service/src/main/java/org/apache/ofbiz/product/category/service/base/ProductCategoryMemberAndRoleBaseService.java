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
import org.apache.ofbiz.product.category.ProductCategoryMemberAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.category.ProductCategoryMember;
import org.apache.ofbiz.product.category.ProductCategoryRole;
import org.apache.ofbiz.product.category.ProductCategory;
import org.apache.ofbiz.product.product.Product;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductCategoryMemberAndRoleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductCategoryMemberAndRoleBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductCategoryMemberAndRoles
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductCategoryMemberAndRole.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductCategoryMemberAndRoles
	 */
	public List<ProductCategoryMemberAndRole> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ProductCategoryMemberAndRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCategoryMemberAndRole.NAME);
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
				entityList = ProductCategoryMemberAndRole.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductCategoryMemberAndRole
	 */
	public Optional<ProductCategoryMemberAndRole> findOne(Object productId,
			Object productCategoryId, Object fromDate, Object partyId,
			Object roleTypeId, Object roleFromDate) {
		List<ProductCategoryMemberAndRole> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryMemberAndRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productId), new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategoryId),
						new EntityExpr("fromDate", EntityOperator.EQUALS,
								fromDate), new EntityExpr("partyId",
								EntityOperator.EQUALS, partyId),
						new EntityExpr("roleTypeId", EntityOperator.EQUALS,
								roleTypeId), new EntityExpr("roleFromDate",
								EntityOperator.EQUALS, roleFromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryMemberAndRole.fromValues(out
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
			ProductCategoryMemberAndRole productCategoryMemberAndRole) {
		List<ProductCategoryMember> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryMember.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getProductCategoryId()),
				new EntityExpr("productId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getProductId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getFromDate())),
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
	 * Get product category role
	 */
	public Optional<ProductCategoryRole> getProductCategoryRole(
			ProductCategoryMemberAndRole productCategoryMemberAndRole) {
		List<ProductCategoryRole> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategoryRole.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productCategoryId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getProductCategoryId()),
				new EntityExpr("partyId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getRoleTypeId()),
				new EntityExpr("fromDate", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getRoleFromDate())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCategoryRole.fromValues(out.getListIt()
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
			ProductCategoryMemberAndRole productCategoryMemberAndRole) {
		List<ProductCategory> entityList = null;
		In in = new In();
		in.setEntityName(ProductCategory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productCategoryId",
						EntityOperator.EQUALS, productCategoryMemberAndRole
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
			ProductCategoryMemberAndRole productCategoryMemberAndRole) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productCategoryMemberAndRole.getProductId())),
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