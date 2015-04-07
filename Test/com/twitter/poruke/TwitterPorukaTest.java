/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikola
 *
 */
public class TwitterPorukaTest {
	
	
	private TwitterPoruka poruka;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);;
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan() {
		poruka.setKorisnik("");
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test 
	public void testSetKorisnikUsername() {
		poruka.setKorisnik("Dzonyboy");
		assertEquals("Dzonyboy", poruka.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}


	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
		assertEquals("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!",poruka.getPoruka());
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuza() {
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+
				"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"
				+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"+
				"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!"
				+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		poruka.setKorisnik("Dzonyboy");
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
		assertEquals("KORISNIK:"+"Dzonyboy"+" PORUKA:"+"Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!",poruka.toString());
	}

}
