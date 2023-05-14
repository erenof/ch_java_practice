package Abstract;

public abstract class Animal {
    protected String nombre;
    protected int peso;
    protected int altura;

    //Metodos abstractos, los metodos abstactos no pueden tener cuerpo, no pueden tener implementación
    //la implementación va a estar en la clase hija.
    public abstract String getAlimento();

    // Metodo no abstracto
    protected int getHorasDescanso(){
        return 6;
    }

    // getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    //Constructor
    public Animal(String nombre, int peso, int altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public Animal(){

    }
}
