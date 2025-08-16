/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.devseniorcode.ecoquest;

import java.util.Scanner;

import org.devseniorcode.ecoquest.controllers.MenuPrincipalController;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.impl.MisionServiceImpl;

/**
 *
 * @author jorao
 */
public class Ecoquest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MisionServices misionService = new MisionServiceImpl();
        MenuPrincipalController menuPrincipal = new MenuPrincipalController(scan, misionService);

        menuPrincipal.mostrarInterfaz();   

        scan.close();
    }
}
