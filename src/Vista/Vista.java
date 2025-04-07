package Vista;

public class Vista {
    public static void mostrarMissatge(String missatge) {
        System.out.println(missatge + "\n");
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
                           "1.\tEscola\n" +
                           "2.\tSector\n" +
                           "3.\tVia\n" +
                           "4.\tEscalador\n" +
                           "0.\tTornar\n");
    }
}
