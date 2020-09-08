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
    private Double longitud;
    private Double latitud;
    @Column(name = "altura_nivel_mar")
    private Double nivelDelMar;

    @ManyToOne
    @JoinColumn(name = "id_boya", referencedColumnName = "id_boya")
    private Boya boya;

	public Muestra(){

	}

	public Muestra( Date horarioMuestra, String matriculaEmbarcacion, Double longitud, Double latitud, Double nivelDelMar, Boya boya) {
		
		this.horarioMuestra = horarioMuestra;
		this.latitud = latitud;
		this.longitud = longitud;
		this.matriculaEmbarcacion = matriculaEmbarcacion;
		this.nivelDelMar = nivelDelMar;
		this.boya = boya;
		
	}    

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

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getNivelDelMar() {
		return nivelDelMar;
	}

	public void setNivelDelMar(Double nivelDelMar) {
		this.nivelDelMar = nivelDelMar;
	}

	public Boya getBoya() {
		return boya;
	}

	public void setBoya(Boya boya) {
		this.boya = boya;
	}

	public Date getHorarioMuestra() {
		return horarioMuestra;
	}

	public void setHorarioMuestra(Date horarioMuestra) {
		this.horarioMuestra = horarioMuestra;
	}

  




  /*   * @param pais the pais to set
     /
    public void setPais(Boya pais) {
        this.pais = pais;
        this.pais.getTemperaturas().add(this);
        */
    }

