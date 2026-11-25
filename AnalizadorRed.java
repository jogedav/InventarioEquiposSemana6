public class AnalizadorRed {
    private EquipoRed[] equipos;

    public AnalizadorRed(EquipoRed[] equipos) {
        this.equipos = equipos;
    }

    public String listarEquipos() {
        String resultado = "";
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                resultado += equipos[i].mostrarInformacion() + "\n";
            }
        }
        return resultado;
    }

    public int contarActivos() {
        int contador = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null && equipos[i].isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularVelocidadPromedio() {
        double suma = 0;
        int cantidad = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                suma += equipos[i].getVelocidadMbps();
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return 0;
        }
        return suma / cantidad;
    }

    public EquipoRed buscarPorIP(String direccionIP) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null && equipos[i].getDireccionIP().equals(direccionIP)) {
                return equipos[i];
            }
        }
        return null;
    }

    public EquipoRed obtenerEquipoMasRapido() {
        EquipoRed masRapido = null;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                if (masRapido == null || equipos[i].getVelocidadMbps() > masRapido.getVelocidadMbps()) {
                    masRapido = equipos[i];
                }
            }
        }
        return masRapido;
    }
}
