package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("--- Before Adivice ---");
	}
	
	@After("execution(* *..*.ProductService.find(..))")
	public void adviceAfter() {
		System.out.println("--- After Adivice ---");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void adviceAfterReturning() {
		System.out.println("--- After Returning Adivice ---");
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("--- After Throwing Adivice " + ex + "---");
	}

	@Around("execution(* *..*.ProductService.*(..))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		/* Before */
		System.out.println("--- Around(Before) Adivice ---");
	
		/* Point Cut Method 실행 */
		// 파라미터를 바꿔주고 싶을 때
//		Object[] params = {"Camera"};
//		Object result = pjp.proceed(params);
		Object result = pjp.proceed();
		
		/* After */
		System.out.println("--- Around(After) Adivice ---");
		
		return result;
	}

}
