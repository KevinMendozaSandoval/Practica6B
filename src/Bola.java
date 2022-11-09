
public class Bola {

    private String color;

     //Crea una bola con el color dado
    public Bola(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

     // Verifica que el color de la bola sea un color aceptable
    public boolean verificarColorDeBola() {
        if (color.equalsIgnoreCase("RO") || color.equalsIgnoreCase("NA") || color.equalsIgnoreCase("AZ") || color.equalsIgnoreCase("AM") || color.equalsIgnoreCase("VE") || color.equalsIgnoreCase("MO")) {
            return true;
        }
        System.out.println("Color incorrecto");
        return false;
    }

    /**
     * Compara el color de una bola con otra
     * True si los colores coinciden, si no False.
     */
    public boolean compararColor(Bola bola) {
        return color.equalsIgnoreCase(bola.getColor());
    }

    @Override
    public String toString() {
        return color;
    }

}
