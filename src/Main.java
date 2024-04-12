import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        VideoStore vs = new VideoStore();
        vs.addNewClient("Matias", "wallaby 123", "2235111333");
        vs.addNewClient("Lucia", "wallaby 124", "2235111352");

      //  Rent rent = vs.rental("Elements", "Matias");
       // Rent rent1 = vs.rental("Godzilla", "Matias");
        //Rent rent2 = vs.rental("Mr Bean", "Lucia");
       // System.out.println(rent.toString());

        vs.vigentes(LocalDate.now());
      //  mostrarRent(vs);
        System.out.println("\n=== Rent 1");
        System.out.println(vs.rental("Elements", "Lucia"));

       Film film = vs.SearchFilm("Elements");
        if (film!=null){
            System.out.println("Pelicula encontrada "+ film.getTitle());
        }
        else{
            System.out.println("Pelicula no encontrada" );
        }

        Client client = vs.SearchClient("Lisa");
        if (client !=null){
            System.out.println("Cliente registrado" + client.getName());
        }
        else{
            System.out.println(vs.addNewClient("Lisa", "Matheu 2617", "2235221931") );

                               // vs.addNewClient("Lisa", "Matheu 2617", "2235221931");
        }
    }

    public static void mostrarRent (VideoStore vs){
        for (Rent r : vs.getRents()) {
            if (r != null) System.out.println(r);
        }
    }
}
