/**
 * 
 */
package com.gifting.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Abhishek
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//,{"color":"Arctic White","imageUrl":"http:\/\/www.zappos.com\/images\/z\/1\/7\/8\/8\/2\/1\/1788212-p-DETAILED.jpg","styleId":"1788212","originalPrice":"$64.95","price":"$64.95","productUrl":"http:\/\/www.zappos.com\/product\/7515478\/color\/51609","percentOff":"0%"},{"color":"Black Boa","imageUrl":"http:\/\/www.zappos.com\/images\/z\/1\/7\/8\/8\/2\/2\/1788220-p-DETAILED.jpg","styleId":"1788220","originalPrice":"$64.95","price":"$64.95","productUrl":"http:\/\/www.zappos.com\/product\/7515478\/color\/14065","percentOff":"0%"}
	
	}

	
	public List<ProductDetails> getList() {
		
		
		Gson gson = new Gson();
		List<ProductDetails> pList = new ArrayList<ProductDetails>();
		 
		try {
	 
			BufferedReader br = new BufferedReader(
				new FileReader("c:\\IMP\\result.txt"));
			
			//  new BufferedReader(new InputStreamReader(is, "UTF-8"));
	 
			JsonElement json = new JsonParser().parse(br);
			JsonArray arr = json.getAsJsonArray();
			Iterator iter = arr.iterator();
			
			
			//convert the json string back to object
			
			while(iter.hasNext()){
	 
			JsonElement json2 = (JsonElement)iter.next();
			Gson gson2 = new Gson();
			
			ProductDetails obj = gson.fromJson(json2, ProductDetails.class);
			pList.add(obj);
			
			System.out.println(obj);
			
			}
	 
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return pList;
		
		
	}
	
	
}
