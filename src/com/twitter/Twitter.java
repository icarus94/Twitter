package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Predstavlja skup twittova
 * @author Nikola
 *
 */
public class Twitter {
	/**
	 * Lista twittova
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca listu svih tvitova
	 * @return poruke kao listu TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda unosi novi twit na kraj liste na osnovu
	 * ulaznih parametara
	 * @param korisnik - username
	 * @param poruka -sadrzaj tvita
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		//tp.setKorisnik("korisnik"); // otkrivena testiranjem 
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda proverava da li u listi TwitterPoruka postoji poruka
	 * sa tagom 
	 * @param maxBroj br max poruka koji se upisuju
	 * @param tag key za pretrazivanje
	 * @return TwitterPoruka[] niz od maxBroj koji sadrzi poruke sa tagom
	 * @throws java.lang.RuntimeException ako je uneti tag
	 * <ul>
	 * <li>null</li>
	 * <li>prazanString</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
			//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
		//			rezultat[brojac+1]=poruke.get(i); //problem sto bojac je podginut za 1
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 