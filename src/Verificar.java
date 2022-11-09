
public class Verificar {
    int aciertos;
    int aproximados;
   
    //Verificacion inicializada en 0
    public Verificar(){
        aciertos = 0;
        aproximados = 0;
    }
    
    //Crea una verificacion para las jugadas
    public Verificar(int aciertos, int aproximados){
        this.aciertos = aciertos;
        this.aproximados = aproximados;
    }

  //regresa los aciertos
    public int getAciertos() {
        return aciertos;
    }

   //set de los aciertos
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

  //regresa las aproximaciones
    public int getAproximados() {
        return aproximados;
    }

  //set de las aproximacions
    public void setAproximados(int aproximados) {
        this.aproximados = aproximados;
    }
    
}