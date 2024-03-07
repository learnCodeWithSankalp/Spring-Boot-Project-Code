package com.lcwsankalp.movieticket.utility;

import java.util.HashMap;
import java.util.Map;

import com.lcwsankalp.movieticket.exception.InsufficentBalanceError;

public class ValidatePaymentInfo {
	
	private static Map<String,Double> paymentInfo= new HashMap<>();
	
	static {
		paymentInfo.put("acc1", 1000.0);
		paymentInfo.put("acc2", 500.0);
		paymentInfo.put("acc3", 2000.0);
		
	}
	
	public static boolean validateCreditLimit(String accNo,double paidAmount) {
		if(paidAmount > paymentInfo.get(accNo)) {
		  throw new InsufficentBalanceError("Insufficent Balance!!!");
		}else {
			return true;
		}
	}

}
