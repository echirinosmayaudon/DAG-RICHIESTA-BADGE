package bacheca.annunci.list.beans;


import java.util.Date;
import java.util.List;

public class AnnuncioBean implements java.io.Serializable, Comparable<AnnuncioBean> {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String titolo;
	private String tipologia;
	private List<String> foto;
	private String zona;
	private String categoriaNome;
	private String categoriaDescrizione;
	private String descrizione;
	private Date datainserimento;
	private Date deadline;
	private String nomeUtente;
	private String telefono;
	private String email;
	
	@Override
	public String toString() {
		return "id: " + id + ", titolo: " + titolo + ", tipologia: " + tipologia + ", zona: " + zona + ", descrizione: " + descrizione;
	}
	
	@Override
	public int compareTo(AnnuncioBean o) {
		return this.getDatainserimento().compareTo(o.getDatainserimento());
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj !=null && obj instanceof AnnuncioBean && this.id==((AnnuncioBean)obj).getId());

		
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public String getZona() {
		return zona;
	}
	
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getNomeUtente() {
		return nomeUtente;
	}
	
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDatainserimento() {
		return datainserimento;
	}
	
	public void setDatainserimento(Date datainserimento) {
		this.datainserimento = datainserimento;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	
	public String getCategoriaNome() {
		return categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	public String getCategoriaDescrizione() {
		return categoriaDescrizione;
	}

	public void setCategoriaDescrizione(String categoriaDescrizione) {
		this.categoriaDescrizione = categoriaDescrizione;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public List<String> getFoto() {
		return foto;
	}
	
	public void setFoto(List<String> foto) {
		this.foto = foto;
	}
	
}
