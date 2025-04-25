package Vista;

public class Vista {
    public static void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("-----------------------------------\n" +
                           "-------- APP ESCALADA VISA --------\n" +
                           "-----------------------------------\n" +
                           "1. Crear\n" +
                           "2. Modificar\n" +
                           "3. Llistar un\n" +
                           "4. Llistar tots\n" +
                           "5. Eliminar\n" +
                           "6. Consultes precreades\n" +
                           "0. Acabar");
    }

    public static void mostrarMenuCrear() {
        System.out.println("-----------------------------------\n" +
                           "-------------- CREAR --------------\n" +
                           "-----------------------------------\n" +
                           "1.\tEscalador\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tVia\n" +
                           "0.\tTornar\n");
    }

    public static void mostrarMenuLlistarTots() {
        System.out.println("-----------------------------------\n" +
                           "-------- LLISTAR TOTS --------\n" +
                           "-----------------------------------\n" +
                           "1.\tEscalador\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tVia\n" +
                           "0.\tTornar\n");
    }

    public static void mostrarMenuActualitzar() {
        System.out.println("-----------------------------------\n" +
                           "------- ACTUALITZAR OBJECTE -------\n" +
                           "-----------------------------------\n" +
                           "1.\tEscalador\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tVia\n" +
                           "0.\tTornar\n");
    }

    public static void mostrarMenuLlistarObjecte() {
        System.out.println("-----------------------------------\n" +
                           "-------- LLISTAR OBJECTE --------\n" +
                           "-----------------------------------\n" +
                           "1.\tEscalador\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tVia\n" +
                           "0.\tTornar\n");
    }

    public static void mostrarMenuEliminar() {
        System.out.println("-----------------------------------\n" +
                           "----------- ELIMINAR OBJECTE --------\n" +
                           "-----------------------------------\n" +
                           "1.\tEscalador\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tVia\n" +
                           "0.\tTornar\n");
    }

}
