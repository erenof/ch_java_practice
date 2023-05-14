package NormalClasses;

public class Gato extends Animal{
    private String alimentoPreferido;

    //Sobre escritura de metodos usando Override
    @Override
    public void hablar() {
        //Armamos nuestra propia implementación, eliminando:
        //super.hablar();
        System.out.println("Miau miau...");
    }

    //getter y setter
    public String getAlimentoPreferido() {
        return alimentoPreferido;
    }

    public void setAlimentoPreferido(String alimentoPreferido) {
        this.alimentoPreferido = alimentoPreferido;
    }

    //constructor

    public Gato(int cantidadPatas, boolean isAmistoso, String alimentoPreferido) {
        super(cantidadPatas, isAmistoso);
        this.alimentoPreferido = alimentoPreferido;
    }

    public Gato() {
    }
}
