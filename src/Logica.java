import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Logica {
    Combinacion jugador;
    HashSet<String> intentosDeCombinacion;
    Combinacion secreto;
    Verificar verificar;
    
   
    public Logica(int tamaño){
        intentosDeCombinacion = new HashSet();
        jugador = new Combinacion(tamaño);
        secreto = new Combinacion(tamaño);
    }
    
    /**
     * Getter para el parametro secreto.
     */
    public Combinacion getSecreto(){
        return secreto;
    }
    
    /**
     * Genera una combinación aleatoria 
     */
    public void generarCombinacionAleatoria(int tamano) {
        String[] vectorColores = {"RO","NA","AZ","AM","VE","MO"};
        ArrayList<String> arrayColores = new ArrayList();
        Random rng = new Random();
        for (int i = 0; i < vectorColores.length; i++) {
            arrayColores.add(vectorColores[i]);
        }
        for (int i = 0; i < tamano; i++) {
            if(i==tamano-1) secreto.agregarBola(new Bola(arrayColores.remove(rng.nextInt(6-i))));
            else secreto.agregarBola(new Bola(arrayColores.remove(rng.nextInt(6-i))));
        }
    }
    
    //Getter para el parametro de retroalimentacion
   
     
    public Verificar getRetroalimentacion(){
        return verificar;
    }
    
    
     // Crea una combinación de jugador
     
    public boolean crearCombinacionDeJugador(String combinacion){
        jugador = new Combinacion();
        if (jugador.verificarCombinacionValida(combinacion)) {
            jugador.llenarCombinacion(combinacion);
            return true;
        } else {
            System.out.println("Inserta de nuevo");
            return false;
        }
    }
    
//  intentos de combinacion el intento del jugador actual
     
    public boolean hayCombinacionRepetida(){
        if(intentosDeCombinacion.add(jugador.getStrCombinacion())){
            return false;
        } else System.out.println("Ya se ha usado esa combinación");
        return true;
    }
    
    /**
     * Genera una retroalimentacion basada en la 
     * combinacion del jugador actual en cuanto a la
     * combinacion secreta*/
    public Verificar generarRetroalimentacion(){
        //int aciertos = jugador.verificarAciertos(secreto);
        //int aproximados = jugador.verificarAproximados(secreto);
        int[] aciertosYAproximados = jugador.verificarCombinacionAciertos(secreto);
        verificar = new Verificar(aciertosYAproximados[0],aciertosYAproximados[1]);
        return verificar;
    }
}