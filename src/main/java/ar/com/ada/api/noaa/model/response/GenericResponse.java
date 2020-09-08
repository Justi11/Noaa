package ar.com.ada.api.noaa.model.response;

public class GenericResponse {
    public boolean isOk;
    public String message = " ";
    public Integer id;
    
    public GenericResponse(){

    } 

    public GenericResponse(boolean isOk, String message, Integer id){
        this.isOk = isOk;
        this.message = message;
        this.id = id;

        
    }
}