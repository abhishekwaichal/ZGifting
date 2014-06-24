/**
 * 
 */
package com.gifting.strategy;

import java.util.ArrayList;
import java.util.List;

import com.gifting.beans.ListOps;
import com.gifting.beans.ProductDetails;

/**
 * @author Abhishek
 * 
 */
public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListOps t = new ListOps();
		List<ProductDetails> pList = t.getList();
		List<ProductDetails[]> resultList = new ArrayList<ProductDetails[]>();

		int qty = 3;
		int amt = 150;

		int listCnt = 0;
		while (listCnt <= 5) {
			ProductDetails[] array = new ProductDetails[3];
			int i = 0;
			for (int j = 0; j < pList.size(); j++) {
				array[i] = pList.get(j);
				i++;
				for (int k = 0; k < pList.size(); k++) {
					if(j!=k)
					if (cost(array) + pList.get(k).getPrice() < amt
							&& notExist(array, resultList))
						if (array.length != qty){
							array[i] = pList.get(k);
							i++;
							}
						else {
							resultList.add(array);
							listCnt++;
							break;
						}
				}
			}

		}

	}

	private static Float cost(ProductDetails[] array) {
		int i = 0;
		Float sum = 0.0f;
		while (i < array.length) {
//			sum += array[i].getPrice();
			i++;
		}

		return sum;
	}

	private static boolean notExist(ProductDetails[] array,
			List<ProductDetails[]> resultList) {

		int i = 0;
		int refHash = 0;
		while (i < array.length) {
			refHash += array[i].hashCode();
			i++;
		}

		i = 0;
		int j = 0;
		while (j < resultList.size()) {
			i = 0;
			int nowHash1 = 0;
			ProductDetails[] tempArr = resultList.get(j);
			while (i < 3) {
				nowHash1 += tempArr[i].hashCode();
				i++;
			}

			if (refHash == nowHash1)
				return false;
			j++;
		}

		return true;
	}

}
