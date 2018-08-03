package org.apache.ofbiz.product.facility.service.base;

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
import org.apache.ofbiz.product.facility.ProductFacilityLocationQuantityTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.product.facility.ProductFacilityLocation;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductFacilityLocationQuantityTestBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductFacilityLocationQuantityTestBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductFacilityLocationQuantityTests
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductFacilityLocationQuantityTest.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductFacilityLocationQuantityTests
	 */
	public List<ProductFacilityLocationQuantityTest> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<ProductFacilityLocationQuantityTest> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(ProductFacilityLocationQuantityTest.NAME);
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
				entityList = ProductFacilityLocationQuantityTest.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductFacilityLocationQuantityTest
	 */
	public Optional<ProductFacilityLocationQuantityTest> findOne(
			Object productId, Object facilityId, Object locationSeqId) {
		List<ProductFacilityLocationQuantityTest> entityList = null;
		In in = new In();
		in.setEntityName(ProductFacilityLocationQuantityTest.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("productId",
						EntityOperator.EQUALS, productId), new EntityExpr(
						"facilityId", EntityOperator.EQUALS, facilityId),
						new EntityExpr("locationSeqId", EntityOperator.EQUALS,
								locationSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocationQuantityTest.fromValues(out
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
	 * Get product
	 */
	public Optional<Product> getProduct(
			ProductFacilityLocationQuantityTest productFacilityLocationQuantityTest) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productFacilityLocationQuantityTest.getProductId())),
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

	/**
	 * Get facility location
	 */
	public Optional<FacilityLocation> getFacilityLocation(
			ProductFacilityLocationQuantityTest productFacilityLocationQuantityTest) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("facilityId", EntityOperator.EQUALS,
						productFacilityLocationQuantityTest.getFacilityId()),
						new EntityExpr("locationSeqId", EntityOperator.EQUALS,
								productFacilityLocationQuantityTest
										.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
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
	 * Get product facility location
	 */
	public Optional<ProductFacilityLocation> getProductFacilityLocation(
			ProductFacilityLocationQuantityTest productFacilityLocationQuantityTest) {
		List<ProductFacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(ProductFacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						productFacilityLocationQuantityTest.getProductId()),
						new EntityExpr("facilityId", EntityOperator.EQUALS,
								productFacilityLocationQuantityTest
										.getFacilityId()),
						new EntityExpr("locationSeqId", EntityOperator.EQUALS,
								productFacilityLocationQuantityTest
										.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocation.fromValues(out.getListIt()
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