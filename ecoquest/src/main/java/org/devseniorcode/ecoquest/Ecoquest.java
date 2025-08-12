/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.devseniorcode.ecoquest;

import java.util.Scanner;

import org.devseniorcode.ecoquest.controllers.MenuPrincipalController;

/**
 *
 * @author jorao
 */
public class Ecoquest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        MenuPrincipalController menuPrincipal = new MenuPrincipalController(scan);

        menuPrincipal.mostrarInterfaz();   

        scan.close();
    }
}
