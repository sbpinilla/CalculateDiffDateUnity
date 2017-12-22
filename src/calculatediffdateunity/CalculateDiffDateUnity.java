/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatediffdateunity;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sergio
 */
public class CalculateDiffDateUnity {

    private static final int SECOND_UNITY = 1;
    private static final int MINUTE_UNITY = 2;
    private static final int DAY_UNITY = 3;

    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println("Direfencia en minutos:"+calculateDiffDateUnity(new Date(),new Date("2018/02/21 15:00:00"), SECOND_UNITY));
        System.out.println("Direfencia en horas:"+calculateDiffDateUnity(new Date(),new Date("2018/02/21 15:00:00"), MINUTE_UNITY));
        System.out.println("Direfencia en Dias:"+calculateDiffDateUnity(new Date(),new Date("2018/02/21 15:00:00"), DAY_UNITY));
        
    }

    public static long calculateDiffDateUnity(Date fechaInicio, Date fechaFin, int iUnity) {

        long milis1, milis2, diff;

        Calendar cinicio = Calendar.getInstance();
        Calendar cfinal = Calendar.getInstance();

        //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
        cinicio.setTime(fechaInicio);
        cfinal.setTime(fechaFin);

        milis1 = cinicio.getTimeInMillis();

        milis2 = cfinal.getTimeInMillis();

        diff = milis2 - milis1;

        if (diff >= 0) {

            // calcular la diferencia en segundos
            long diffSegundos = Math.abs(diff / 1000);

            // calcular la diferencia en minutos
            long diffMinutos = Math.abs(diff / (60 * 1000));

            long restominutos = diffMinutos % 60;

            // calcular la diferencia en horas
            long diffHoras = (diff / (60 * 60 * 1000));

            // calcular la diferencia en dias
            long diffdias = Math.abs(diff / (24 * 60 * 60 * 1000));

            if (iUnity == SECOND_UNITY) {
                
                return diffSegundos;
                
            } else if (iUnity == MINUTE_UNITY) {
                
                return diffMinutos;
                
            } else if (iUnity == DAY_UNITY) {
                
                return diffdias;
                
            } else {
                return -1;
            }
       
        } else {
            return 0;
        }

    }

}
