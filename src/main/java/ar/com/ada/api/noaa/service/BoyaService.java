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

    public Boya crearBoya( Integer idBoya, double longitudInstalacion, double latitudInstalacion) {
        Boya boya = new Boya();
        boya.setIdBoya(idBoya);
        boya.setLatitudInstalacion(latitudInstalacion);
        boya.setLongitudInstalacion(longitudInstalacion);
        grabar(boya);
        return boya;

    }

    public void grabar(Boya boya) {
        boyaRepository.save(boya);

    }

    public List<Boya> listarBoyas() {
        return boyaRepository.findAll();
    }

    public Boya listarBoyasPorId(Integer id) { Optional<Boya> boyas =
        boyaRepository.findById(id); if (boyas.isPresent()) return boyas.get(); 
        return
         null;
    }
}

   