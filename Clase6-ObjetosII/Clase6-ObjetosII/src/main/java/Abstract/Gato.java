package Abstract;

public class Gato extends Animal{

    private String razaGato;

    //Siempre hay que implementar el metodo abstracto de la clase madre
    @Override
    public String getAlimento() {
        //Añadir la logica para getAlimento
        return "Whiskas";
    }


    //Constructor
    public Gato(String nombre, int peso, int altura, String razaGato) {
        super(nombre, peso, altura);
        this.razaGato = razaGato;
    }
}
