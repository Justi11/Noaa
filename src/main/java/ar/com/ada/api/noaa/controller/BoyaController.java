package ar.com.ada.api.noaa.controller;

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
import ar.com.ada.api.noaa.model.request.BoyaRequest;
import ar.com.ada.api.noaa.model.response.GenericResponse;
import ar.com.ada.api.noaa.service.BoyaService;


@RestController
public class BoyaController {

    @Autowired
    BoyaService boyaService;

    @PostMapping("/api/boya")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody BoyaRequest boyaRequest) {
        boyaService.crearBoya(boyaRequest.longitud_instalacion, boyaRequest.latitud_instalacion  );
        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.message = "Boya Creada con exito";
        r.id = boyaRequest.boyaId;
        return ResponseEntity.ok(r);

    }

    @GetMapping("/api/boyas")
    public ResponseEntity<?> listarBoyas() {
        return ResponseEntity.ok(boyaService.listarBoyas());
    }

    @GetMapping("/api/boyas/{id}")
    public ResponseEntity<?> listarBoyaPorId(@PathVariable int id) {
        return ResponseEntity.ok(boyaService.listarBoyaPorId(id));

    }

}