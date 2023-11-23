package com.training.service;
import com.training.pojo.*;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class SortByPriceComparator implements Comparator<ProductPojo>{

	@Override
	public int compare(ProductPojo o1, ProductPojo o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getSellingprice()-o2.getSellingprice());
		//Double.Compare(o1.getSellingprice(),o2.getSellingprice());
	}

	

	

}