import java.util.ArrayList;
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

    //Necesario los getter para poder recibir los datos privados de la clase videojuego
        public String getNombre() {return Nombre;}
        public String getGenero() { return Genero;}
        public int getCodigo() { return Codigo;}
        public String getPlataforma() { return Plataforma;}
}//Videojuego

//Declaracion de la clase catalogo que seria la de base de datos
class Catalogo{
    private ArrayList<Videojuego> videojuegos; // El equivalente a self.videojuegos
    
    public Catalogo(){ //init
        videojuegos = new ArrayList<>();
    }
    
    //Metodo para registrar videojuegos
    void registrar(String Nombre,String Genero,int Codigo,String Plataforma){
        Videojuego videojuego = new Videojuego (Nombre, Genero, Codigo, Plataforma);
        videojuegos.add(videojuego);
        System.out.println("Videojuego: " + Nombre + ", registrado exitosamente!");
    }//Registrar


    //Metodo para la impresion de los datos
    void mostrar(){
        //Ciclo para recorrer la lista de videojuegos, comprueba si hay o no
        if (videojuegos.isEmpty()){
            System.out.println("No hay videojuegos registrados!");
            return;
        }/* if  v es variable temporal para el recorrido*/
        for(Videojuego i : videojuegos){
            System.out.println("Nonbre: " + i.getNombre() + ", Genero: " + i.getGenero() + ", Codigo: " + i.getCodigo() + ", Plataforma: " + i.getPlataforma());
        }/* for */
    }//Mostrar

}//Toda la clase Catalogo

public class practica4a{

    public static void main(String[] args) {
        //Creacion de objetos
        System.out.println("\n-----Catalogo de Videojuegos-----\n");
        Scanner leer = new Scanner(System.in);
        int opcion;
        Catalogo cat = new Catalogo(); //Se declara antes del ciclo do, para que cada pasada pueda crearse uno nuevo vacio

        //Videojuego videojuego = new Videojuego (Nombre , Genero, Codigo, Plataforma);

        do{

            System.out.println("\n-----Menu Principal-----");
            System.out.println("1.- Registrar Videojuego");
            System.out.println("2.- Mostrar Catalogo");
            System.out.println("3.- Buscar Videojuego");
            System.out.println("4.- Vender Videojuego");
            System.out.println("5.- Salir");
            System.out.println("\nQue opcion desea? ");
            opcion = Integer.parseInt(leer.nextLine());
            
            switch (opcion) {
                case 1: //Aqui se registran las variables de los objetos
                    System.out.println("----- Registrar Videojuego -----");

                    System.out.println("Nombre de Videojuego: ");
                    String Nombre = leer.nextLine();

                    System.out.println("Genero: ");
                    String Genero = leer.nextLine();

                    System.out.println("Codigo: ");
                    int Codigo = Integer.parseInt(leer.nextLine()); //Para poder leer los int y el salto de linea ya que el solo nextInt no lee el salto

                    System.out.println("Plataforma: ");
                    String Plataforma = leer.nextLine();
                    //Se pasan las variables al metodo
                    cat.registrar(Nombre, Genero, Codigo, Plataforma);

                    break;
            
                case 2:
                    System.out.println("-----  Mostrar Catalogo -----");
                        cat.mostrar();
                    break;

                case 3:
                    System.out.println("----- Buscar Videojuego -----");
                    

                    break;

                case 4:
                    System.out.println("----- Vender Videojuego -----");

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