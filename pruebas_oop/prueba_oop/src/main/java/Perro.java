public class Perro {
    private int tamanio;
    private String nombre;
    private String raza;

    // constructor
    public Perro(int tamanio, String nombre, String raza) {
        this.tamanio = tamanio;
        this.nombre = nombre;
        this.raza = raza;
    }

    //  getter y setter
    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    //Sobreescribimos el metodo hashcode y equals
    // alt+ins y elegimos "equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perro perro)) return false;

        if (getTamanio() != perro.getTamanio()) return false;
        if (!getNombre().equals(perro.getNombre())) return false;
        return getRaza().equals(perro.getRaza());
    }

    @Override
    public int hashCode() {
        int result = getTamanio();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getRaza().hashCode();
        return result;
    }

    // metodo tostring para que imprima todos los datos del objeto
    @Override
    public String toString() {
        return "Perro{" +
                "tamanio=" + tamanio +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
