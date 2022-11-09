
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args) {
        int tamaño = 6;
        int oportunidades = 15;
        Scanner lectura = new Scanner(System.in);
        MastermindGrafico tablero = new MastermindGrafico();
        Logica logica = new Logica(tamaño);
        //se dibuja el tablero
        tablero.dibujarCasillas(tamaño);

        //Genera una combinación aleatoria para ser adivinada
        logica.generarCombinacionAleatoria(tamaño);

        //Muestra la combinación que se debe adivinar para saber cual es 
        System.out.println("Combinacion Secreta:");
        System.out.println(logica.getSecreto());

        //Se inicia el juego
        int intentos = 1;
        String combinacion;
        System.out.println("Colores posibles:");
        System.out.println("RO(ROJO)\nNA(NARANJA)\nAZ(AZUL)\nAM(AMARILLO)\nVE(VERDE)\nMO(MORADO)");
        do {
            //Se obtiene la combinación de bolas del jugador
            boolean añadido = false;
            do {
                System.out.println("Inserta una combinacion de " + tamaño + " colores.");
                combinacion = lectura.nextLine();

                //Se verifica que sea un color aceptable y si es el
                //caso se añade
                if (logica.crearCombinacionDeJugador(combinacion)) {
                    if (!logica.hayCombinacionRepetida()) {
                        tablero.dibujarCombinacion(combinacion, intentos);
                        añadido = true;
                    }
                } else {
                    System.out.println("Combinacion no valida");
                }
            } while (!añadido);

            //Se muestran los aciertos que se han conseguido si no se
            //Ha ganado
            Verificar verificar = logica.generarRetroalimentacion();
            tablero.dibujarRetroalimentacion(verificar, intentos);

            //Se verifica si la combinación es la correcta
            if (verificar.getAciertos() == tamaño) {
                System.out.println("Ganaste");
                //Se termina la partida
                break;
            } 
            else {
                System.out.println("Incorrecto");
                System.out.println("");
            }

            intentos++;
        } while (intentos <= oportunidades);

        if (intentos >= oportunidades) {
            System.out.println("Haz perdido");
        }
        System.out.println("Fin el juego.");
        System.out.println("Presiona ENTER para continuar");
        lectura.nextLine();
        System.exit(0);
    }

}