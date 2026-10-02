import java.util.ArrayList;
import java.util.Scanner;

class Videojuego{

    private String Nombre;
    private double Precio;
    private Boolean Disponible;
    
    public Videojuego(String Nombre, double Precio){
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Disponible = true;
    }//Public VideoJuego

    public void setDisponible(Boolean Disponible){
        this.Disponible = Disponible;
    }

    //Necesario los getter para poder recibir los datos privados de la clase videojuego
        public String getNombre() {return Nombre;}
        public double getPrecio() { return Precio;}
        public Boolean getDisponible() { return Disponible;}
}//Videojuego

//Declaracion de la clase catalogo que seria la de base de datos
class Catalogo{
    private ArrayList<Videojuego> videojuegos; // El equivalente a self.videojuegos
    
    public Catalogo(){ //init
        videojuegos = new ArrayList<>();
    }
    
    //Metodo para registrar videojuegos
    void registrar(String Nombre,double Precio){
        for(Videojuego i : videojuegos){
            if(i.getNombre().equalsIgnoreCase(Nombre)){
                System.out.println("Ya existe un videojuego con ese nombre");
                return;
            }
        }
        Videojuego videojuego = new Videojuego (Nombre, Precio);
        videojuegos.add(videojuego);
        System.out.println("Videojuego: " + Nombre + ", registrado exitosamente!");
    }//Registrar


    //Metodo para la impresion de los datos
    void mostrar(){
        int disponibles = 0;
        int vendidos = 0;
        //Ciclo para recorrer la lista de videojuegos, comprueba si hay o no
        if (videojuegos.isEmpty()){
            System.out.println("No hay videojuegos registrados!");
            return;
        }/* if  v es variable temporal para el recorrido*/
        for(Videojuego i : videojuegos){
            System.out.println("Nombre: " + i.getNombre() + ", Precio: " + i.getPrecio() + ", Disponibilidad: " + i.getDisponible());
        }/* for */

        for(Videojuego i : videojuegos){
            if(i.getDisponible()){
                disponibles ++;
            }else{
                vendidos ++;
            }
        }
        System.out.println("Videojuegos disponibles: " + disponibles);
        System.out.println("Videojuegos vendidos: " + vendidos);
    }//Mostrar

    void mostrarDisponibles(){
        if(videojuegos.isEmpty()){
            System.out.println("No hay videojuegos registrados");
            return;
        }

        boolean hayDisponibles = false;

        for(Videojuego i: videojuegos){
            if(i.getDisponible()){
                System.out.println("Nombre: " + i.getNombre() + ", Precio: " + i.getPrecio());
                hayDisponibles = true;
          
            }
        }
        if(!hayDisponibles){
            System.out.println("No hay videojuegos disponibles");
        }
    }
    void buscar(Scanner leer){
        System.out.println("Ingrese el nombre del videojuego: ");
        String nombre = leer.nextLine();

        for(Videojuego i: videojuegos){
            if(i.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("----Videojuego Encontrado----");
                System.out.println("Nombre: " + i.getNombre());
                System.out.println("Precio: " + i.getPrecio());
                System.out.println("Dsiponibilidad: " + i.getDisponible());
                return;
            }
        }
        System.out.println("Videojuego no encontrado");
    }

    void vender(Scanner leer){
        System.out.println("Ingrese el nombre del videojuego a vender: ");
        String nombre = leer.nextLine();

        for(Videojuego i: videojuegos){
            if(i.getNombre().equalsIgnoreCase(nombre)){
                if(i.getDisponible()){
                    i.setDisponible(false);
                    System.out.println("El videojuego se vendio de manera exitosa!");
                }else{
                    System.out.println("El videojuego ya no esta disponible");
                }
                return;
            }
        }
        System.out.println("Videojuego no encontrado");
    }

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
            System.out.println("5.- Mostrar disponibles");
            System.out.println("6.- Salir");
            System.out.println("\nQue opcion desea? ");
            opcion = Integer.parseInt(leer.nextLine());
            
            switch (opcion) {
                case 1: //Aqui se registran las variables de los objetos
                    System.out.println("----- Registrar Videojuego -----");

                    System.out.println("Nombre de Videojuego: ");
                    String Nombre = leer.nextLine();

                    System.out.println("Precio: ");
                    double Precio = Double.parseDouble(leer.nextLine()); //Para poder leer los int y el salto de linea ya que el solo nextInt no lee el salto
                    while(Precio <= 0){
                        System.out.println("El precio debe ser mayor que 0");
                        System.out.println("Ingrese nuevamente el precio: ");
                        Precio = Double.parseDouble(leer.nextLine());
                    }

                    //Se pasan las variables al metodo
                    cat.registrar(Nombre, Precio);

                    break;
            
                case 2:
                    System.out.println("-----  Mostrar Catalogo -----");
                        cat.mostrar();
                    break;

                case 3:
                    System.out.println("----- Buscar Videojuego -----");
                    cat.buscar(leer);
                    break;

                case 4:
                    System.out.println("----- Vender Videojuego -----");
                    cat.vender(leer);
                    break;
                
                case 5:
                    System.out.println("----Videojuegos disponibles----");
                    cat.mostrarDisponibles();
                    break;
                case 6:
                    System.out.println("Gracias por visitar nuestro catalogo!");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }while(opcion !=6); //do
        leer.close();
    }
}
