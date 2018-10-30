package fr.form.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.form.SpringJv.Identifiant;



@Entity
@Table(name="games")
public class JeuVideo {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String titre;
	
	@Column
	private LocalDate dateSortie;
	
	@Column
	private String editeur;
	public JeuVideo() {
		getId();
		getTitre();
		getDateSortie();
		getEditeur();
	}	
	public JeuVideo(String titre, LocalDate date, String editeur)
	{
		this.titre = titre;
		this.dateSortie = date;
		this.editeur = editeur;
	}
	
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitre(String title) {
		this.titre = title;
	}
	/**
	 * @return the dateSortie
	 */
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	/**
	 * @param dateSortie the dateSortie to set
	 */
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	/**
	 * @return the editeur
	 */
	public String getEditeur() {
		return editeur;
	}
	/**
	 * @param editeur the editeur to set
	 */
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " " + this.titre + " " + this.dateSortie+ " "+ this.editeur;
	}
}
