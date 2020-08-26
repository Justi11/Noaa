package ar.com.ada.api.noaa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "boya")
public class Boya {
    @Id
    @Column(name = "id_boya")
    private Integer idBoya;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_luz")
    private String colorLuz;
    @Column(name = "logitud_instalacion")
    private double longitudInstalacion;
    @Column(name = "latitud_instalacion")
    private double latitudInstalacion;
    
    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Muestra> muestras = new ArrayList<>();

    public Integer getIdBoya() {
        return idBoya;
    }

    public void setIdBoya(Integer idBoya) {
        this.idBoya = idBoya;
    }

    public String getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(String colorLuz) {
        this.colorLuz = colorLuz;
    }

    public double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    
   
       // this.temperaturas = temperaturas;
    

}