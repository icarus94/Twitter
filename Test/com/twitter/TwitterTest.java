/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Nikola
 *
 */
public class TwitterTest {
	Twitter tviter;
	TwitterPoruka poruka;
	LinkedList<TwitterPoruka> pomLista;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tviter = new Twitter();
		poruka = new TwitterPoruka();
		pomLista = new LinkedList<TwitterPoruka>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tviter  = null;
		poruka = null;
		pomLista = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeNull() {
		assertEquals(pomLista, tviter.vratiSvePoruke());
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeJedan() {
		poruka.setKorisnik("Dzonyboy");
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
		pomLista.addLast(poruka);
		tviter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		assertEquals(pomLista, tviter.vratiSvePoruke());
	}
	//problem sa metodom unesi ne unosi korisnika ,samo postavlja vrednost na "korisnik"
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePorukeMulti() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka("Random poruka");
		poruka.setKorisnik("Dzonyboy");
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
		pomLista.addLast(poruka);
		pomLista.addLast(tp);
		tviter.unesi(poruka.getKorisnik(),poruka.getPoruka());
		tviter.unesi(tp.getKorisnik(),tp.getPoruka());
		
		assertEquals(pomLista, tviter.vratiSvePoruke());
	}
	
	
	

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		poruka.setKorisnik("Dzonyboy");
		poruka.setPoruka("Najveca trauma detinjstva: \"Pricacemo kad odu gosti\"!");
		tviter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		pomLista.addLast(poruka);
		assertEquals(pomLista,tviter.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		TwitterPoruka p3 = new TwitterPoruka();
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[2];
		p1.setKorisnik("Dzony");
		p2.setKorisnik("LudaLuda");
		p3.setKorisnik("MyMan");
		p1.setPoruka("poruka 1");
		p2.setPoruka("poruka 2");
		p3.setPoruka("no-no");
		tviter.unesi(p1.getKorisnik(), p1.getPoruka());
		tviter.unesi(p2.getKorisnik(), p2.getPoruka());
		tviter.unesi(p3.getKorisnik(), p3.getPoruka());
		pomocniNiz[0] = p1;
		pomocniNiz[1] = p2;
		assertArrayEquals(pomocniNiz, tviter.vratiPoruke(2, "poruka")); 
	} //primecen Error koji je ukazao na lose ispsian kod (problem "brojac+1")
	//
	@Test
	public void testVratiPorukeMAX() {
		TwitterPoruka [] pomocni = tviter.vratiPoruke(-6, "Bla");
		assertEquals(100,pomocni.length);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagJeNull() {
		tviter.vratiPoruke(50, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag() {
		tviter.vratiPoruke(50, "");
	}

}
