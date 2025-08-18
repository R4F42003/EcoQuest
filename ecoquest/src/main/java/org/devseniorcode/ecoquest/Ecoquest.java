/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.devseniorcode.ecoquest;

import java.util.Scanner;

import org.devseniorcode.ecoquest.controllers.MenuPrincipalController;
import org.devseniorcode.ecoquest.services.MisionServices;
import org.devseniorcode.ecoquest.services.VoluntarioService;
import org.devseniorcode.ecoquest.services.impl.MisionServiceImpl;
import org.devseniorcode.ecoquest.services.impl.VoluntarioServiceImpl;

/**
 *
 * @author jorao
 */
public class Ecoquest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MisionServices misionService = new MisionServiceImpl();
        VoluntarioService voluntarioService = new VoluntarioServiceImpl();
        MenuPrincipalController menuPrincipal = new MenuPrincipalController(scan, misionService, voluntarioService);

        menuPrincipal.mostrarInterfaz();   

        scan.close();
    }
}
