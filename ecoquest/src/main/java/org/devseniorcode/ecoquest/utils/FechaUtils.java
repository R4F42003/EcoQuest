package org.devseniorcode.ecoquest.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FechaUtils {

    private final Scanner scan;

    public FechaUtils(Scanner scan) {
        this.scan = scan;
    }

    private int leerEnteroEnRango(String texto, int min, int max) {
        while (true) {
            System.out.print(texto);
            String s = scan.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.printf("Valor inválido. Debe estar entre %d y %d.%n", min, max);
        }
    }

    public int leerAnio() {
        return leerEnteroEnRango("Año (2000-2100): ", 2000, 2100);
    }

    public int leerMes() {
        System.out.println("Mes:");
        Locale localeEs = new Locale("es", "ES");
        Arrays.stream(Month.values())
            .forEach(m -> {
                String mes = m.getDisplayName(TextStyle.FULL, localeEs);
                // Primera letra mayúscula, resto minúscula
                mes = mes.substring(0, 1).toUpperCase() + mes.substring(1).toLowerCase();
                System.out.printf("%2d. %s%n", m.getValue(), mes);
            });
        return leerEnteroEnRango("Seleccione el mes (1-12): ", 1, 12);
    }

    public int leerDiaSegunMesYAnio(int mes, int anio) {
        int diasEnMes = Month.of(mes).length(Year.isLeap(anio));
        String listaDias = IntStream.rangeClosed(1, diasEnMes)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(", "));
        System.out.println("Días disponibles: " + listaDias);
        return leerEnteroEnRango(String.format("Seleccione el día (1-%d): ", diasEnMes), 1, diasEnMes);
    }

    public LocalDate leerFechaCompleta() {
        int anio = leerAnio();
        int mes  = leerMes();
        int dia  = leerDiaSegunMesYAnio(mes, anio);
        return LocalDate.of(anio, mes, dia);
    }
}
