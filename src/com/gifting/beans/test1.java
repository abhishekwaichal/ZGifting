/**
 * 
 */
package com.gifting.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek
 *
 */
public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		test t = new test();
		List<ProductDetails> pList = t.getList();
		List<ProductDetails[]> resultList ;
		
		
		
		int qty = 3;
		int amt = 150;
		
		
		int listCnt = 0;
		while(listCnt <= 3){
			ProductDetails[] array = new ProductDetails[3];
			int i = 0;
			
			for(int j = 0; j< pList.size(); j++){
				array[i] = pList.get(j);
				for(int k = 0; k< pList.size(); k++){
					if(cost(array)+pList.get(k).getPrice() < amt && notExist(array, resultList))
							if(array.length != qty)
								array[i] = pList.get(k);
							else
								break;
			}
			break;
			listCnt++;
		}
		
		
	}

}
