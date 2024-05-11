package com.shopme.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopme.entities.Product;
import com.shopme.entities.User;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductFinalPrice(Double productPrice);
	List<Product>  findByProductDiscount(Double discountPrice);
	Product  findByProductId(int productId);
	//List<Product> findProductByCategory(String companyName);
	List<Product> findByproductName(String name);
	
	@Query(value= "select * from product where categoryname = ?1",nativeQuery = true)
	List<Product> findByCname(String cname);
	
	@Query(value= "select * from product where subcategoryname = ?1",nativeQuery = true)
	List<Product> findBySname(String sname);
	
}
