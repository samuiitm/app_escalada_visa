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
                           "1.\tLocalitzacio\n" +
                           "2.\tEscola\n" +
                           "3.\tSector\n" +
                           "4.\tEscalador\n" +
                           "5.\tTipus_Via\n" +
                           "6.\tVia\n" +
                           "7.\tAncoratge\n" +
                           "8.\tTipus_Roca\n" +
                           "9.\tMaterial\n" +
                           "10.\tTram\n" +
                           "11.\tDificultat\n");
    }
}
