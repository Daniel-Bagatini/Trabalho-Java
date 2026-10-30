/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vigilancia;

import java.time.DayOfWeek;

/**
 *
 * @author 2025001594
 */
public enum diaSemana {
    Segunda_feira(DayOfWeek.MONDAY),
    Terca_feira(DayOfWeek.TUESDAY),
    Quarta_feira(DayOfWeek.WEDNESDAY), 
    Quinta_feira(DayOfWeek.THURSDAY), 
    Sexta_feira(DayOfWeek.FRIDAY), 
    Sabado(DayOfWeek.SATURDAY), 
    Domingo(DayOfWeek.SUNDAY);
    
    private final DayOfWeek dayOfWeekJava;

    diaSemana(DayOfWeek dayOfWeekJava) {
        this.dayOfWeekJava = dayOfWeekJava;
    }
    
     public static diaSemana de(DayOfWeek doW) {
        for (diaSemana dia : values()) {
            if (dia.dayOfWeekJava == doW) {
                return dia;
            }
        }
        return null; // Caso a data seja nula
     }
}
