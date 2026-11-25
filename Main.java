public class Main {
    public static void main(String[] args) {
        EquipoRed[] equipos = new EquipoRed[5];
        equipos[0] = new EquipoRed("RouterCentral", "192.168.1.1", "Router", 1000, true);
        equipos[1] = new EquipoRed("Switch01", "192.168.1.10", "Switch", 1000, true);
        equipos[2] = new EquipoRed("AP01", "192.168.1.20", "AccessPoint", 300, false);
        equipos[3] = new EquipoRed("Servidor01", "192.168.1.100", "Servidor", 10000, true);
        equipos[4] = new EquipoRed("Firewall01", "192.168.1.254", "Firewall", 1000, false);

        AnalizadorRed analizador = new AnalizadorRed(equipos);

        System.out.println("=== Equipos ===");
        System.out.println(analizador.listarEquipos());

        System.out.println("Activos: " + analizador.contarActivos());
        System.out.println("Velocidad promedio: " + analizador.calcularVelocidadPromedio() + " Mbps");

        System.out.println("\n=== Busqueda por IP ===");
        EquipoRed encontrado = analizador.buscarPorIP("192.168.1.1");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.mostrarInformacion());
        }
        if (analizador.buscarPorIP("10.0.0.50") == null) {
            System.out.println("IP 10.0.0.50 no encontrada (null)");
        }

        System.out.println("\n=== Desafio ===");
        EquipoRed masRapido = analizador.obtenerEquipoMasRapido();
        if (masRapido != null) {
            System.out.println("Equipo mas rapido: " + masRapido.mostrarInformacion());
        }
    }
}
