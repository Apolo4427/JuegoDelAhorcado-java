import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //Declaracion de escaner
        Scanner scanner = new Scanner(System.in);

        //Variables
        String palabra_secreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabra_adivinada = false;

        char[] letrasAdivinadas = new char[palabra_secreta.length()];
        char letra_ingresada;

        //Asignacion del array 
        for (int i=0; i<palabra_secreta.length();i++){
            letrasAdivinadas[i] = '_';
        }


        while (!palabra_adivinada && intentos<intentosMaximos) {

            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + "  (12 letras)");
            
            System.out.println("ingresa una letra que creas que esta en la palabra secreta: ");
            letra_ingresada = Character.toLowerCase(scanner.next().charAt(0));//charAt(0) obtiene la letra segun la posicion que se ingrese en el argumento, de un string 
            //Character.toLowerCase() convierte en minusculas lo que se encuentre entre los parentesis
            boolean letra_adivinada = false;
            //Validamos si la letra ingresada se encuentra en la palabra secreta
            for (int i=0; i < palabra_secreta.length(); i++){
                if (letra_ingresada == palabra_secreta.charAt(i)){
                    letrasAdivinadas[i] = letra_ingresada;
                    letra_adivinada = true;
                    //Validamos si la palabra ha sido adivinada en su totalidad
                    for(int j=0; j < palabra_secreta.length(); j++){
                        if (letrasAdivinadas[j]==palabra_secreta.charAt(j)){
                            palabra_adivinada = true;
                        }else {
                            palabra_adivinada = false;
                            break;
                        }
                    }
                }
            }
            //En caso de no haber adinivinado una letra de la palabra secreta
            if (!letra_adivinada){
                intentos++;
                System.out.println("Esa letra no se encuentra en la plabra secreta.");
                System.out.println("llevas "+intentos+" intentos perdidos te quedan "+(intentosMaximos-intentos)+ " intentos.");
            }
        }
        scanner.close();
        if(palabra_adivinada){
            System.out.println("Felicidades¡¡ has adivinado la palabra, era: "+palabra_secreta);
        }else{
            System.out.println("Lo sentimos has perdido :_c");
        }
    }
}
