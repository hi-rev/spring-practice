package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVo;
// Pointcut
// -> 실제 Advice가 적용되는 Joinpoint
@Service
public class ProductService {

	public ProductVo find(String name) {
		System.out.println("[ProductService] finding...");
		
//		if (1-1 == 0) {
//			throw new RuntimeException("ProductService.find() Exception");
//		}
		
		return new ProductVo(name);
	}

}
