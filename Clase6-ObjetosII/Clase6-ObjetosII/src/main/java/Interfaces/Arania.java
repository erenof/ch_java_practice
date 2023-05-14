package Interfaces;

public class Arania implements Mascota, SerVivo{

    private boolean amistoso;

    //Tengo que implementar los métodos de la interface Mascota, los metodos default no hace falta implementar
    @Override
    public boolean isAmistosa() {
        return false;
    }

    @Override
    public void Jugar() {
        System.out.println("Soy una araña jugando");
    }

    //Implemento el metodo de la otra interfaz
    @Override
    public void respirar() {
        System.out.println("Araña respirando");
    }
}
