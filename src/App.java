public class App {

    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String CLEAN_SCREEN = "\033[H\033[2J";

    public static void pintaCarga (int carga, String color) {
        for (int i = 0; i < carga / 2; i++)
            System.out.print(color + "█");
        for (int i = carga / 2; i < 50; i++)
            System.out.print(color + "░");
    }
    public static void main(String[] args) throws Exception {
        
        String titulo = "MONITOR DE BATERÍA VIRTUAL";
        int longTitulo = titulo.length();
        int cargaMax = 0;
        
        while (true) {
            int carga = (int)(Math.random() * 101);
            String color = (carga < 20) ? ROJO : (carga >= 20 && carga < 80) ? AMARILLO : VERDE;

            System.out.printf("""
                ╔══════════════════════════════════════════════════════╗
                ║%s║
                ╠══════════════════════════════════════════════════════╣
                ║ Nivel actual:     %s%d%%%s%33s
                ║ Carga máxima:     %s%d%%%s (Peak)%26s
                ╠══════════════════════════════════════════════════════╣
                    """,
                    String.format("%" + Math.ceil(((double)54 - longTitulo) / 2) + "s%s%" + Math.floor(((double)54 - longTitulo)/ 2) + "s", "", titulo, ""),
                    color, carga, RESET, "║",
                    color, cargaMax, RESET, "║"
                    );
            System.out.print("║ [");
            pintaCarga(carga, color);
            System.out.println(RESET + "] ║");
            System.out.printf("""
                    ║                          |                           ║
                    ╚══════════════════════════════════════════════════════╝);
                    """);

            cargaMax = Math.max(carga, cargaMax);
            Thread.sleep(500);
            System.out.println(CLEAN_SCREEN);
        }
    }
}
