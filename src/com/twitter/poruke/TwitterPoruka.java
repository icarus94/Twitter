package com.twitter.poruke; 

/**
 * Predstavlja poruku na twitteru
 * @author Nikola
 * 
 */
public class TwitterPoruka {
	
	/**
	 * Predstavlja ime korisnika/username
	 */
	private String korisnik;
	/**
	 * Predstavlja sadrzaj poruke
	 * 
	 */
	private String poruka;
	/**
	 * metoda koja vraca ime korinsika iliti username
	 * @return korisnik kao String vrednost
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * postavlja username korisnika
	 * @param korisnik kao String vrednost 
	 * @throws java.lang.RuntimeException ako je unet username korisnika
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * vraca poruku koju je korisnik postavio
	 * @return poruka kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * postavlja sadrzaj poruke na unetu vrednost
	 * @param poruka kao String
	 * @throws java.lang.RuntimeException ako nije unesena poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * vraca informacije o tvitu
	 * 
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof TwitterPoruka))
			return false;
		TwitterPoruka tp = (TwitterPoruka) obj;
		if(tp.getKorisnik().equals(this.korisnik) && tp.getPoruka().equals(this.poruka))
			return true;
		return false;
	}
}
