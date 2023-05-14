package NormalClasses;

public class Animal {
    private int cantidadPatas;
    boolean isAmistoso;

    //Metodos
    public void hablar(){
        System.out.println("Soy un animal hablando...");
    }



    // getter y setter
    public int getCantidadPatas() {
        return cantidadPatas;
    }

    public void setCantidadPatas(int cantidadPatas) {
        this.cantidadPatas = cantidadPatas;
    }

    public boolean isAmistoso() {
        return isAmistoso;
    }

    public void setAmistoso(boolean amistoso) {
        isAmistoso = amistoso;
    }

    //constructor
    public Animal(int cantidadPatas, boolean isAmistoso) {
        this.cantidadPatas = cantidadPatas;
        this.isAmistoso = isAmistoso;
    }

    public Animal(){

    }

    // metodo tostring
    @Override
    public String toString() {
        return "Animal{" +
                "cantidadPatas=" + cantidadPatas +
                ", isAmistoso=" + isAmistoso +
                '}';
    }

}
