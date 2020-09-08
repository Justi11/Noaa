package ar.com.ada.api.noaa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entity.Boya;
import ar.com.ada.api.noaa.model.request.BoyaActualizarColorRequest;
import ar.com.ada.api.noaa.model.request.BoyaRequest;
import ar.com.ada.api.noaa.model.response.GenericResponse;
import ar.com.ada.api.noaa.service.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService boyaService;

    @PostMapping("/api/boyas")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody BoyaRequest boyaRequest) {
        Boya boya = boyaService.crearBoya(boyaRequest.longitudInstalacion, boyaRequest.latitudInstalacion);
        if (boya != null) {

            return ResponseEntity.ok(new GenericResponse(true, "Boya creada con exito", boya.getIdBoya()));
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/api/boyas")
    public ResponseEntity<List<Boya>> listarBoyas() {
        return ResponseEntity.ok(boyaService.listarBoyas());
    }

    // hacer la validacion, chequear si la lista esta vacia/
    @GetMapping("/api/boyas/{id}")
    public ResponseEntity<Boya> obtenerBoyaPorId(@PathVariable Integer id) {
        Optional<Boya> boyaOp = boyaService.obtenerBoyaPorId(id);
        if (boyaOp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(boyaOp.get());

    }

    @PutMapping("/api/boyas/{id}")
    public ResponseEntity<GenericResponse> actualizarColorBoya(@PathVariable Integer id,
            @RequestBody BoyaActualizarColorRequest boyaActualizarColor) {
        boolean boyaActualizada = boyaService.actualizarColorBoya(id, boyaActualizarColor.color);
        if (boyaActualizada) {
            return ResponseEntity.ok(new GenericResponse(true, "Boya actualizada", id));
        }
        return ResponseEntity.badRequest().build();

    }

}