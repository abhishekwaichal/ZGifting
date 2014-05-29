package com.gifting.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gifting.beans.ProductDetails;

/**
 * Servlet implementation class Gifting
 */
@WebServlet("/Gifting")
public class Gifting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gifting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out= response.getWriter();

		String qty = request.getParameter("qty");
		String amt = request.getParameter("amt");
		
//		out.println("Qty: "+qty+" Amt: "+amt);
		
		String key = new String("b05dcd698e5ca2eab4a0cd1eee4117e7db2a10c4");
		String url1 = "http://api.zappos.com/Product/7515478?includes=[%22styles%22]&key="+key;
		
		URL url = new URL(url1);
        URLConnection yc = url.openConnection();
        InputStreamReader is= new InputStreamReader(yc.getInputStream());
        	
		BufferedReader in = new BufferedReader(is);
		
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			out.println(inputLine);
		in.close();
		
		List<ProductDetails> pList = null;
		try {
			pList = getList(is);
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for(int i = 0; i < pList.size() ; i++ )
			try {
				saveImage(pList.get(i));
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			out.println("Saved Image");

		
		
	}
	
	public void saveImage(ProductDetails p) throws Throwable{
		
//		System.out.println("opening connection");
		String imgUrl =  p.getImageUrl();
		URL url = new URL(imgUrl);
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File(p.getProductUrl()+".jpg"));

//		System.out.println("reading file...");
		int length = -1;
		byte[] buffer = new byte[1024];
		while ((length = in.read(buffer)) > -1) {
		    fos.write(buffer, 0, length);
		}
		fos.close();
		in.close();
//		System.out.println("file was downloaded");
		
	} 
	
	public List<ProductDetails> getList(InputStreamReader is) throws Throwable{
		
		List<ProductDetails> pList = new ArrayList<ProductDetails>();

//		String productObject;
		JSONObject obj = new JSONObject(is);
		JSONArray array = obj.getJSONArray("product");
		for(int i = 0 ; i < array.length() ; i++){

		    ProductDetails p = new ProductDetails(array.getJSONObject(i).getString("productUrl"),
		    		array.getJSONObject(i).getString("color"), 
		    		Float.parseFloat(array.getJSONObject(i).getString("originalPrice")), 
		    		array.getJSONObject(i).getInt("percentOff"), 
		    		array.getJSONObject(i).getString("imageUrl"), 
		    		Float.parseFloat(array.getJSONObject(i).getString("price")), 
		    		array.getJSONObject(i).getInt("styleId"));
			
					pList.add(p);		
		}
		return pList; 
	}
}
