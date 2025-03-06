/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaRender;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author pc
 */
public class validacionFecha implements DateValidator{
    private DateTimeFormatter format;
    
    public validacionFecha(DateTimeFormatter format){
        this.format = format;
    }
    
    @Override
    public boolean isValid(String dateStr){
        try{
            this.format.parse(dateStr);
        }catch(DateTimeParseException e){
            return false;
        }
        return true;
    }
    
}
