package co.jamesfl.apps.personas;

import java.util.LinkedList;

/**
 * Created by javie on 30/09/2017.
 */

public class Datos {
    private static LinkedList<Persona> personas = new LinkedList<>();

    public static void guardarPersona(Persona p) {
        personas.add(p);
    }

    public static LinkedList<Persona> getPersonas() {
        return personas;
    }
}
