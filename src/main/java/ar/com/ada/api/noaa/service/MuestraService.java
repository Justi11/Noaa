import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entity.Muestra;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {
    @Autowired
    MuestraRepository muestraRepo;

    @Autowired
    BoyaService boyaService;

    public Muestra crearNuevaMuestra(MuestraRequest muestraReq) {
        Boya boya = boyaService.buscarPorId(muestraReq.boyaId);
        if(boya  != null){
        
        Muestra muestra = new Muestra();
        muestra.setAltura(muestraReq.altura);
        muestra.setHorarioMuestra(muestraReq.horarioMuestra);
        muestra.setLatitud(muestraReq.latitud);
        muestra.setLongitud(muestraReq.longitud);
        muestra.setMatriculaEmbarcacion(muestraReq.matriculaEmbarcacion);
        muestra.setBoya(boya);
            grabarMuestra(muestra);
            return muestra;
        }else{
            return null;
        }