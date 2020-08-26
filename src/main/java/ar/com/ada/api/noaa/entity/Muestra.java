package ar.com.ada.api.noaa.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "muestra")
public class Muestra {
    @Id
    @Column(name = "id_muestra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMuestra;
    @Column(name = "horario_muestra")
    private Date horarioMuestra;
    @Column(name = "matricula_embarcacion")
    private String matriculaEmbarcacion;
    private double longitud;
    private double latitud;
    @Column(name = "altura_nivel_mar")
    private double nivelDelMar;

    @ManyToOne
    @JoinColumn(name = "id_boya", referencedColumnName = "id_boya")
    private Boya boya;

	public Integer getIdMuestra() {
		return idMuestra;
	}

	public void setIdMuestra(Integer idMuestra) {
		this.idMuestra = idMuestra;
	}

	public String getMatriculaEmbarcacion() {
		return matriculaEmbarcacion;
	}

	public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
		this.matriculaEmbarcacion = matriculaEmbarcacion;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getNivelDelMar() {
		return nivelDelMar;
	}

	public void setNivelDelMar(double nivelDelMar) {
		this.nivelDelMar = nivelDelMar;
	}

	public Boya getBoya() {
		return boya;
	}

	public void setBoya(Boya boya) {
		this.boya = boya;
	}

  




  /*   * @param pais the pais to set
     /
    public void setPais(Boya pais) {
        this.pais = pais;
        this.pais.getTemperaturas().add(this);
        */
    }

