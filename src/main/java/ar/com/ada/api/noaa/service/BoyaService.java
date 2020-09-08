package ar.com.ada.api.noaa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entity.Boya;
import ar.com.ada.api.noaa.repos.BoyaRepository;

@Service
public class BoyaService {

    @Autowired
    BoyaRepository boyaRepository;

    public Boya crearBoya(Double longitudInstalacion, Double latitudInstalacion) {
        Boya boya = new Boya();
        boya.setLongitudInstalacion(longitudInstalacion);
        boya.setLatitudInstalacion(latitudInstalacion);
        grabar(boya);
        return boya;

    }

    public void grabar(Boya boya) {
        boyaRepository.save(boya);

    }

    public List<Boya> listarBoyas() {
        return boyaRepository.findAll();
    }

    public Optional<Boya> obtenerBoyaPorId(Integer id) {
        Optional<Boya> boyaOp = boyaRepository.findById(id);
        if (boyaOp.isPresent())
            return boyaOp;
        return Optional.empty();
    }

    public String colorBoya(Double nivelDelMar){
       String color;
        if (nivelDelMar < -100 || nivelDelMar > 100){
             color = "rojo";
        }
            else if (nivelDelMar < -50 || nivelDelMar < 50){
                color = "amarillo";
            }
            else color = "verde";
            
            return color;
    }

    public boolean actualizarColorBoya(Integer id, String color) {
        Optional<Boya> boyaOp = boyaRepository.findById(id);
        if (boyaOp.isEmpty())
            return false;
        Boya boya = boyaOp.get();
        boya.setColorLuz(color);
        boyaRepository.save(boya);
        return true;
    }
}
