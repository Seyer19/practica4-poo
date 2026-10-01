
import java.util.Scanner;

class Videojuego{

    private String Nombre;
    private String Genero;
    private int Codigo;
    private String Plataforma;
    
    public Videojuego(String Nombre, String Genero, int Codigo, String Plataforma){
        this.Nombre = Nombre;
        this.Genero = Genero;
        this.Codigo = Codigo;
        this.Plataforma = Plataforma;
    }//Public VideoJuego
}//Videojuego

    //Metodo Constructor que recibe los dato
class Catalogo(String Nombre, String Genero, int Codigo, String Plataforma){
    new Catalogo(Videojuego());
    
        
    //Imprime los datos
    void mostrar(String Nombre,String Genero,int Codigo,String Plataforma){
        
    }//Mostrar
    static void registrar(String Nombre,String Genero,int Codigo,String Plataforma){
        Videojuego videojuego = new Videojuego (Nombre, Genero, Codigo, Plataforma);
    }//Registrar
}

public class practica4a{

    public static void main(String[] args) {
        //Creacion de objetos
        System.out.println("\n-----Catalogo de Videojuegos-----\n");
        Scanner leer = new Scanner(System.in);
        int opcion, Codigo;
        String Nombre, Genero, Plataforma;

        //Videojuego videojuego = new Videojuego (Nombre , Genero, Codigo, Plataforma);

        do{

            System.out.println("-----Menu Principal-----");
            System.out.println("1.- Registrar Videojuego");
            System.out.println("2.- Editar Videojuego");
            System.out.println("3.- Imprimir Catalogo");
            System.out.println("4.- Borrar Videojuego");
            System.out.println("5.- Salir");
            System.out.println("\nQue opcion desea? ");
            opcion = Integer.parseInt(leer.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.println("----- Registrar Videojuego -----");

                    System.out.println("Nombre de Videojuego: ");
                    Nombre = leer.nextLine();

                    System.out.println("Genero: ");
                    Genero = leer.nextLine();

                    System.out.println("Codigo: ");
                    Codigo = leer.nextInt();

                    System.out.println("Plataforma: ");
                    Plataforma = leer.nextLine();

                    Catalogo.registrar(Nombre, Genero, Codigo, Plataforma);

                    break;
            
                case 2:
                    System.out.println("----- Editar Videojuego -----");

                    break;

                case 3:
                    System.out.println("----- Imprimir Catalogo -----");
                    Catalogo.mostrar(Nombre, Genero, Codigo, Plataforma);
                    break;

                case 4:
                    System.out.println("----- Menu de borrar Videojuego -----");

                    break;

                case 5:
                    System.out.println("Gracias por visitar nuestro catalogo!");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }while(opcion !=5); //do
        leer.close();
    }
}