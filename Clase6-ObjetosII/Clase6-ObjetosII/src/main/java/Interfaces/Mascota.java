package Interfaces;

public interface Mascota {
    boolean isAmistosa();
    void Jugar();

    default void talk(){
        System.out.println("Animal is talking by default");
    }
}
