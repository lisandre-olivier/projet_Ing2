package fr.eisti.cergy.jee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Pompier generated by hbm2java
 */
@Entity
@Table(name = "POMPIER")
public class Pompier implements java.io.Serializable {

	private Long  idPompier;
	private String nomPompier;
	private String prenomPompier;
	private Long  agePompier;


	public Pompier() {
	}


	public Pompier(Long  idPompier, String prenomPompier, String nomPompier, Long  agePompier) {
		this.idPompier = idPompier;
		this.nomPompier = nomPompier;
		this.prenomPompier = prenomPompier;
		this.agePompier = agePompier;
	}

	@Id
	@Column(name = "ID_POMPIER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="POMPIER_gen_seq")
    @SequenceGenerator(name="POMPIER_gen_seq", sequenceName="SEQ_ID_POMPIER", allocationSize=1)

	public Long  getIdPompier() {
		return this.idPompier;
	}

	public void setIdPompier(Long  idPompier) {
		this.idPompier = idPompier;
	}


	@Column(name = "NOM", length = 100)
	public String getNomPompier() {
		return this.nomPompier;
	}

	public void setNomPompier(String nomPompier) {
		this.nomPompier = nomPompier;
	}

	@Column(name = "PRENOM", length = 100)
	public String  getPrenomPompier() {
		return this.prenomPompier;
	}

	public void setPrenomPompier(String  prenomPompier) {
		this.prenomPompier = prenomPompier;
	}


	@Column(name = "AGE", length = 2)
	public Long getAgePompier() {
		return this.agePompier;
	}

	public void setAgePompier(Long agePompier) {
		this.agePompier = agePompier;
	}
 
}