package model;
// Generated 11-Dec-2018 10:36:16 by Hibernate Tools 5.3.0.Beta2

import java.math.BigDecimal;

/**
 * Connection generated by hbm2java
 */
public class Connection implements java.io.Serializable {

	private BigDecimal id;
	private Management management;
	private RescueSearch rescueSearch;
	private Medical medical;
	private Logistic logistic;
	private Profil profil;
	private Carte carte;
	private Mission mission;
	private String cleHash;
	private Boolean autorisation;
	private String email;

	public Connection() {
	}

	public Connection(BigDecimal id, Management management, RescueSearch rescueSearch, Medical medical,
			Logistic logistic, Profil profil, Carte carte, Mission mission, String cleHash, String email) {
		this.id = id;
		this.management = management;
		this.rescueSearch = rescueSearch;
		this.medical = medical;
		this.logistic = logistic;
		this.profil = profil;
		this.carte = carte;
		this.mission = mission;
		this.cleHash = cleHash;
		this.email = email;
	}

	public Connection(BigDecimal id, Management management, RescueSearch rescueSearch, Medical medical,
			Logistic logistic, Profil profil, Carte carte, Mission mission, String cleHash, Boolean autorisation,
			String email) {
		this.id = id;
		this.management = management;
		this.rescueSearch = rescueSearch;
		this.medical = medical;
		this.logistic = logistic;
		this.profil = profil;
		this.carte = carte;
		this.mission = mission;
		this.cleHash = cleHash;
		this.autorisation = autorisation;
		this.email = email;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Management getManagement() {
		return this.management;
	}

	public void setManagement(Management management) {
		this.management = management;
	}

	public RescueSearch getRescueSearch() {
		return this.rescueSearch;
	}

	public void setRescueSearch(RescueSearch rescueSearch) {
		this.rescueSearch = rescueSearch;
	}

	public Medical getMedical() {
		return this.medical;
	}

	public void setMedical(Medical medical) {
		this.medical = medical;
	}

	public Logistic getLogistic() {
		return this.logistic;
	}

	public void setLogistic(Logistic logistic) {
		this.logistic = logistic;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Carte getCarte() {
		return this.carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getCleHash() {
		return this.cleHash;
	}

	public void setCleHash(String cleHash) {
		this.cleHash = cleHash;
	}

	public Boolean getAutorisation() {
		return this.autorisation;
	}

	public void setAutorisation(Boolean autorisation) {
		this.autorisation = autorisation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
