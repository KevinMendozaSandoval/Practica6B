import java.awt.Color;

public class MastermindGrafico
{
    private Circle circulo;
    private Canvas graficoMastermind;
    
    /**
     * Crea un objeto MastermindView para procesar la parte
     * gráfica del juego de Mastermind
     */
    public MastermindGrafico()
    {
        graficoMastermind = new Canvas("Mastermind", 360, 620);
    }    
//Dibuja los los circulos donde estaran los colores
    public void dibujarCirculo(int pos, int intento, Color color){
        circulo = new Circle(20+(pos*40),580-(40*(intento-1)),30,color, graficoMastermind);
    }
 //Dibuja los los circulos donde estaran las verificaciones(pd: cambiar color para que se vean los aciertos)
    public void dibujarCirculoPequeño(int pos, int intento, Color color){
        circulo = new Circle(257+(pos*17),590-(40*(intento-1)),7,color, graficoMastermind);
    }
    
    public Color determinarColor(String color){
        color = color.toUpperCase();
        switch(color){
            case "RO":
                return Color.RED;
            case "NA":
                return Color.ORANGE;
            case "AZ":
                return Color.BLUE;
            case "AM":
                return Color.YELLOW;
            case "VE":
                return Color.GREEN;
            case "MO":
                return Color.MAGENTA;
            default:
                return null;
        }
    }
 //Dibuja las casillas
    public void dibujarCasillas(int tamaño)
    {
        for(int i=1; i<=15;i++){
            for(int j=0; j<tamaño;j++){
                dibujarCirculo(j,i,Color.BLACK);
                dibujarCirculoPequeño(j,i,Color.BLACK);
            }
        }
    }  
//Limpia pantalla aun no se si funciona
    public void limpiarPantalla(){
        graficoMastermind.erase();
    }
   /**
     * Dibuja la combinación dada en el canvas.
     */
    public void dibujarCombinacion(String combinacion, int intento){

            String[] bolas = combinacion.split(" ");
            for (int j = 0; j < bolas.length; j++) {
                dibujarCirculo(j,intento, determinarColor(bolas[j]));
            }
        
    }
      public void dibujarRetroalimentacion(Verificar verificar, int intento){
        int contador=0;
        for (int i = 0; i < verificar.getAciertos(); i++) {
            circulo = new Circle(257+(contador*17),590-(40*(intento-1)),7,Color.RED, graficoMastermind);
            contador++;
        }
        for (int i = 0; i < verificar.getAproximados(); i++) {
            circulo = new Circle(257+(contador*17),590-(40*(intento-1)),7,Color.GRAY, graficoMastermind);
            contador++;
        }
    }
}