package com.jwd.test.model;

import java.util.List;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prevoznik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique = true)
	private String naziv;
	@Column
	private String adresa;
	@Column(nullable = false,unique = true)
	private String pib;
	@OneToMany(mappedBy = "prevoznik",cascade = CascadeType.ALL)
	private List<Linija> linije;
	public Prevoznik(Long id, String naziv, String adresa, String pib, List<Linija> linije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
		this.linije = linije;
	}
	public Prevoznik(String naziv, String adresa, String pib, List<Linija> linije) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
		this.linije = linije;
	}
	public Prevoznik() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prevoznik other = (Prevoznik) obj;
		return Objects.equals(id, other.id);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public List<Linija> getLinije() {
		return linije;
	}
	public void setLinije(List<Linija> linije) {
		this.linije = linije;
	}
	
	
	

}
