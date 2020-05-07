package com.naver.s5.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	@AfterReturning("execution(* com.naver.s5.transfer.Transfer.*())")
	public void cardAfter() {
		System.out.println("----------------");
		System.out.println("카드 결제");
	}
	
	@Around("execution(* com.naver.s5.transfer.Transfer.*(Integer, ..))")
	public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
		System.out.println("---------");
		
		System.out.println("카드 check in");
		Object [] ar=join.getArgs();//파라미터 같은 것
		
		for(Object o :  ar) {
			System.out.println(o);
		}
		//join에 버스나 지하철 탑승 정보가 들어옴
		
		Object obj = join.proceed();
		
		System.out.println("카드 check out");
		
		return obj;
	}
}
