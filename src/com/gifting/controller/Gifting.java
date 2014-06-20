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

import com.gifting.beans.ListOps;
import com.gifting.beans.ProductDetails;
import com.google.gson.JsonDeserializer;

/**
 * Servlet implementation class Gifting
 */
@WebServlet("/Gifting")
public class Gifting extends HttpServlet{
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
//		Spare Keys
		String key1 = new String("12c3302e49b9b40ab8a222d7cf79a69ad11ffd78");
		String key2 = new String("5b8384087156eb88dce1a1d321c945564f4d858e");

		String url1 = "http://api.zappos.com/Product/7515478?includes=[%22styles%22]&key="+key;
		
		URL url = new URL(url1);
        URLConnection yc = url.openConnection();
        InputStreamReader is = new InputStreamReader(yc.getInputStream());
        	
		BufferedReader in = new BufferedReader(is);
		
		
		
/*		
 		String inputLine;
		while ((inputLine = in.readLine()) != null)
			out.println(inputLine);
		in.close();
*/		
		
		List<ProductDetails> pList = null;
		try {
			ListOps t = new ListOps(in);
			t.getList();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		
		for(int i = 0; i < pList.size() ; i++ )
			try {
				saveImage(pList.get(i));
			} catch (Throwable e) {
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
	
}
