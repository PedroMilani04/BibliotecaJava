/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.biblioteca1;

/**
 *
 * @author Pedro
 */
import java.util.ArrayList;

public interface Subject {
    void adicionarObserver(Observer observer);
    void removerObserver(Observer observer);
    void notificarObservers(Multa multa);
}
