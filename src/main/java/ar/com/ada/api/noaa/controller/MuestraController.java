package ar.com.ada.api.noaa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entity.Boya;
import ar.com.ada.api.noaa.entity.Muestra;
import ar.com.ada.api.noaa.model.request.BoyaActualizarColorRequest;
import ar.com.ada.api.noaa.model.request.MuestraRequest;
import ar.com.ada.api.noaa.model.response.GenericResponse;
import ar.com.ada.api.noaa.model.response.MuestraColorResponse;
import ar.com.ada.api.noaa.service.BoyaService;
import ar.com.ada.api.noaa.service.MuestraService;

@RestController
public class MuestraController {

    @Autowired
   MuestraService muestraService;
   @Autowired
   BoyaService boyaService;

@PostMapping("/api/muestras")
    public ResponseEntity<MuestraColorResponse> crearMuestra(@RequestBody MuestraRequest muestraRequest) {
       Optional<Muestra> muestra = muestraService.crearNuevaMuestra(  muestraRequest.horarioMuestra,  muestraRequest.matriculaEmbarcacion, muestraRequest.longitud, muestraRequest.latitud, muestraRequest.nivelDelMar, muestraRequest.boyaId)
    
       if (muestra.isPresent()) {


            return ResponseEntity.ok(muestra.get().getIdMuestra(), boyaService.colorBoya(muestraRequest.nivelDelMar)));
        }
        return ResponseEntity.badRequest().build();

    }

  /*  @GetMapping("/api/muestras")
    public ResponseEntity<List<Muestra>> listarMuestras() {
        return ResponseEntity.ok(muestraService.listarMuestras());
    }*/

    // hacer la validacion, chequear si la lista esta vacia/
    @GetMapping("/api/muestras/boyas/{id}")
    public ResponseEntity<List<Muestra>> obtenerMuestrasPorId(@PathVariable Integer id) {
        List<Muestra> listaDeMuestraXBoya = boyaService.obtenerBoyaPorId(id).get().getMuestras();
        if (listaDeMuestraXBoya.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(listaDeMuestraXBoya);

      }



}