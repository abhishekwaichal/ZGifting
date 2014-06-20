/**
 * 
 */
package com.gifting.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/**
 * @author Abhishek
 *
 */
public class test implements JsonDeserializer<ProductDetails> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		test t = new test();
		t.getList();
		//,{"color":"Arctic White","imageUrl":"http:\/\/www.zappos.com\/images\/z\/1\/7\/8\/8\/2\/1\/1788212-p-DETAILED.jpg","styleId":"1788212","originalPrice":"$64.95","price":"$64.95","productUrl":"http:\/\/www.zappos.com\/product\/7515478\/color\/51609","percentOff":"0%"},{"color":"Black Boa","imageUrl":"http:\/\/www.zappos.com\/images\/z\/1\/7\/8\/8\/2\/2\/1788220-p-DETAILED.jpg","styleId":"1788220","originalPrice":"$64.95","price":"$64.95","productUrl":"http:\/\/www.zappos.com\/product\/7515478\/color\/14065","percentOff":"0%"}
	
	}

	
	public List<ProductDetails> getList() {
		
		
		Gson gson = new Gson();
		List<ProductDetails> pList = new ArrayList<ProductDetails>();
		Type typeOfT = null ;
        JsonDeserializationContext context = null;
		 
		try {
	 
			BufferedReader br = 
				new BufferedReader(new FileReader(new File("c:\\IMP\\result.txt")));
			
			//  new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			JsonElement json = new JsonParser().parse(br);
			JsonArray arr = json.getAsJsonArray();
			Iterator iter = arr.iterator();
			
			//convert the json string back to object
			
			while(iter.hasNext()){
	 
			JsonElement json2 = (JsonElement)iter.next();
//			Gson gson2 = new Gson();
			
			ProductDetails obj = deserialize(json2, typeOfT, context);
			pList.add(obj);
			
			System.out.println(obj);
			
			}
	 
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return pList;
		
		
	}


	@Override
	public ProductDetails deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {

		JsonObject jsonObject = json.getAsJsonObject();

		ProductDetails obj = new ProductDetails();
		
		obj.setColor(jsonObject.get("color").getAsString());
		obj.setImageUrl(jsonObject.get("imageUrl").getAsString());
		obj.setStyleId(jsonObject.get("styleId").getAsInt());
		obj.setProductUrl(jsonObject.get("productUrl").getAsString());

        try {
            String price = jsonObject.get("price").getAsString();
            String originalPrice = jsonObject.get("originalPrice").getAsString();
            String percentOff = jsonObject.get("percentOff").getAsString();

            obj.setPrice(Double.valueOf(price.substring(1)));
            obj.setOriginalPrice(Double.valueOf(originalPrice.substring(1)));
            obj.setPercentOff(Integer.valueOf(percentOff.substring(0,
                    percentOff.length() - 1)));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return obj;
		
	}
	
	
}
