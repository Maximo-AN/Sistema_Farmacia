/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablaRender;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.time.LocalDate;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author pc
 */
public class ColorCelda extends JTable{
    
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
        Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);
        //Pequeño "constructor" para ayuda de validacion de fechas
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US)
                     .withResolverStyle(ResolverStyle.STRICT);
             DateValidator validacion = new validacionFecha(dateFormatter);
            if(validacion.isValid(this.getValueAt(rowIndex, columnIndex).toString())){
            //Otro constructo para la ayuda de comparacion de fechas    
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            LocalDate fechalocal = LocalDate.parse(this.getValueAt(rowIndex, columnIndex).toString()
            , formato);
            java.util.Date fecha = new Date();
            String conv = format.format(fecha);
            LocalDate datenow = LocalDate.parse(conv, formato);  
                System.out.println(datenow.until(fechalocal, ChronoUnit.DAYS));
                if(datenow.isAfter(fechalocal)){
                    componente.setBackground(Color.RED);
                    componente.setForeground(Color.WHITE);
                }
                
                else if(datenow.until(fechalocal, ChronoUnit.DAYS) <= 92){
                    componente.setBackground(Color.ORANGE);
                    componente.setForeground(Color.GRAY);
                }
                
                else{
                    componente.setBackground(Color.WHITE);
                    componente.setForeground(Color.BLACK);
                }
            }
            else{
                componente.setBackground(Color.WHITE);
                componente.setForeground(Color.BLACK);
            }
        
        return componente;
    }
}
