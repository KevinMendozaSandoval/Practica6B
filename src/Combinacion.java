import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Combinacion{

    private ArrayList<Bola> combinacion;

    /**
     * Crea una combinación por defecto (Vacía)
     */
    public Combinacion(){
        combinacion = new ArrayList();
    }
    
    /**
     * Crea una combinación del tamaño dado (Vacía)
     */
    public Combinacion(int tamaño) {
        combinacion = new ArrayList(tamaño);
    }

    /**
     * Regresa la combinación guardada
     */
    public ArrayList<Bola> getCombinacion() {
        return combinacion;
    }

    /**
     * Regresa la combinación en forma de String
     */
    public String getStrCombinacion() {
        String cadena="";
        for(Bola bola : combinacion){
            cadena=cadena + bola.toString()+" ";
        }
        return cadena;
    }
    
    /**
     * Agrega una bola a la combinacion
     * @param bola Bola a agregar
     */
    public void agregarBola(Bola bola) {
        combinacion.add(bola);
    }

    
     //Regresa una bola en una posicion específica
     
    public Bola getBola(int posicion) {
        Bola bola;
        bola = combinacion.get(posicion);
        return bola;
    }

   
     // Llena la combinación de bolas basado en la cadena dada
   
    public void llenarCombinacion(String combinacion){
        this.combinacion = new ArrayList();
        String[] bolas = combinacion.split(" ");
            for (int j = 0; j < bolas.length; j++) {
                agregarBola(new Bola(bolas[j]));
            }
    }
    
    
     //Verifica que la cadena de colores sea una combinacion válida
 
    public boolean verificarCombinacionValida(String combinacion){
        ArrayList<String> arrayCombinacion = new ArrayList();
        String[] bolas = combinacion.split(" ");
        for (int i = 0; i < bolas.length; i++) {
            arrayCombinacion.add(bolas[i]);
        }
        for (int j = 0; j < bolas.length; j++) {
            if(!(Collections.frequency(arrayCombinacion, bolas[j]) > 1)){
                Bola bola = new Bola(bolas[j]);
                if(!bola.verificarColorDeBola()){
                    return false;
                }
            } else return false;
            
        }
        return true;
    }
    
 
     //Verifica que las coincidencias de aciertos y aproximado
    public int[] verificarCombinacionAciertos(Combinacion otraCombinacion){
        int[] resultado = new int[2];
        resultado[0] = 0;
        resultado[1] = 0;
        ArrayList<Bola> combinacionAComparar = otraCombinacion.getCombinacion();
        for (int i = 0; i < combinacionAComparar.size(); i++) {
            if(combinacion.get(i).compararColor(combinacionAComparar.get(i))){
                resultado[0]++;
            }
            else {
                for (int j = 0; j < combinacionAComparar.size(); j++) {
                    if(combinacion.get(i).compararColor(combinacionAComparar.get(j))){
                        resultado[1]++;
                        break;
                    }    
                }
            }
        }
        return resultado;
    }
    
    @Override
    public String toString() {
        return "combinacion=" + combinacion;
    }
    
}
