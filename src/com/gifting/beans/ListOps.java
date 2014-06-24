/**
 * 
 */
package com.gifting.beans;

import java.io.BufferedReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class ListOps implements JsonDeserializer<ProductDetails> {

	BufferedReader br ;
	public ListOps(BufferedReader brIn ) {

		br = brIn;
	
	}
	
	public ListOps() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductDetails> getList() {
		
		
		List<ProductDetails> pList = new ArrayList<ProductDetails>();
		Type typeOfT = null ;
        JsonDeserializationContext context = null;
		 
	 
//			BufferedReader br = 
//				new BufferedReader(new FileReader(new File("c:\\IMP\\result.txt")));
			
			//  new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			JsonElement json = new JsonParser().parse(br);
			JsonArray arr = json.getAsJsonArray();
			Iterator iter = arr.iterator();
			
			//convert the json string back to object
			while(iter.hasNext()){
	 
			JsonElement json2 = (JsonElement)iter.next();
			
			ProductDetails obj = deserialize(json2, typeOfT, context);
			pList.add(obj);
			
//			System.out.println(obj);
			
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
