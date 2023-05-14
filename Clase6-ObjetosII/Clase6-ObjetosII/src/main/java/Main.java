import Interfaces.Arania;
import NormalClasses.Gato;

public class Main {
    public static void main(String[] args) {

        Gato gato1 = new Gato();

        //probando herencia, agregando el metodo hablar
        gato1.hablar();

        // Las clases abstractas no se pueden instanciar, tienen que ser las clases hijas
        Abstract.Gato gato2 = new Abstract.Gato("Ramon", 6, 50, "Siames");

        System.out.println(gato2.getAlimento());;

        // probando interface
        Arania arania1 = new Arania();
        System.out.println("La araña es amistosa?: " + arania1.isAmistosa());
                arania1.Jugar();

    }
}
