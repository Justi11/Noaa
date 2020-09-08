package ar.com.ada.api.noaa.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.noaa.entity.Boya;
import ar.com.ada.api.noaa.entity.Muestra;
import ar.com.ada.api.noaa.model.request.MuestraRequest;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {
    @Autowired
    MuestraRepository muestraRepo;

    @Autowired
    BoyaService boyaService;

    public Optional<Muestra> crearNuevaMuestra(Date horarioMuestra, String matriculaEmbarcacion, Double longitud,
            Double latitud, Double nivelDelMar, Integer idBoya) {
        Optional<Boya> boya = boyaService.obtenerBoyaPorId(idBoya);
        if (boya.isPresent()) {
            boya.get().setColorLuz(boyaService.colorBoya(nivelDelMar));
            Muestra muestra = new Muestra(horarioMuestra, matriculaEmbarcacion, longitud, latitud, nivelDelMar,
                    boya.get());
            grabar(muestra);
            return Optional.of(muestra);
        }
        return Optional.empty();
    }

    public void grabar(Muestra muestra) {
        muestraRepo.save(muestra);

    }
}