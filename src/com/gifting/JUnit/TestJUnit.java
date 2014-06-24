/**
 * 
 */
package com.gifting.JUnit;

import org.junit.Test;

import com.gifting.controller.Gifting;

import static org.junit.Assert.assertEquals;

/**
 * @author Abhishek
 *
 */
public class TestJUnit {

	Integer numb = 3;
	Gifting g = new Gifting(numb);
	Integer numb1 = 4;
	@Test
	public void testGifting(){
		assertEquals(numb1, g.is5());
	}
	
}
