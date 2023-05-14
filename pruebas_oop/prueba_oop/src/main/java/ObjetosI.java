public class ObjetosI {
    public static void main(String[] args) {

        // Instanciamos un objeto de clase perro
        Perro dogui = new Perro(95, "Dogui", "doberman");

        Perro doguiDuplicado = new Perro(95, "Dogui", "doberman");

        System.out.println(dogui.getNombre());

        //Usamos el metodo hashCode para mostrar valores de objetos
        System.out.println(dogui.hashCode());
        System.out.println(doguiDuplicado.hashCode());

        //Usamos el metodo equals para comparar valores
        System.out.println(dogui.equals(doguiDuplicado));

        //Usamos el metodo toString() generado en la clase Perro
        System.out.println(dogui.toString());

        // Probando herencia
        Gato michi = new Gato();
        michi.setAlimentoPreferido("Pez");
        System.out.println("El alimento preferido de mi gatos es: " + michi.getAlimentoPreferido());


    }
}
