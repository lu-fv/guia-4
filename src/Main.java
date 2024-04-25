import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Film> movies = getFilms();

        VideoStore vs = new VideoStore();
        vs.setMovies(movies);

        vs.addNewClient("Matias", "wallaby 123", "2235111333");
        vs.addNewClient("Lucia", "wallaby 124", "2235111352");


        System.out.println("\n=== Rent 1");
        System.out.println(vs.rental("Elements", "Lucia", LocalDateTime.parse("2024-04-20T17:00:00"))); //
        System.out.println("--------------------------\n");

        System.out.println("\n=== Rent 2");
        System.out.println(vs.rental("The Avenger", "Matias", LocalDateTime.parse("2024-04-24T22:00:00")));
        System.out.println("--------------------------\n");

        System.out.println("\n=== Rent 3");
        System.out.println(vs.rental("The Avenger", "Lucia", LocalDateTime.parse("2024-04-24T19:30:00"))); //
        System.out.println("--------------------------\n");

        System.out.println("\n=== Rent 4");
        System.out.println(vs.rental("Cinderella", "Lucia", LocalDateTime.parse("2024-04-24T20:00:00"))); //
        System.out.println("--------------------------\n");

        System.out.println("\n=== Rent 5");
        System.out.println(vs.rental("Mr Bean", "Lucia", LocalDateTime.parse("2024-04-24T19:40:00")));
        System.out.println("--------------------------\n");

        System.out.println("----- VIGENTES\t -----");
        vs.vigentes(LocalDateTime.now());

        System.out.println("----- DEVOLUCIONES -----");
        vs.devoluciones(LocalDateTime.now());

        System.out.println("---BUSQUEDA DE MOVIE---");
        Film film = vs.SearchFilm("Ted");
        if (film != null) {
            System.out.println("\n Pelicula encontrada: \n" + film.getTitle());
        } else {
            System.out.println("Pelicula no encontrada");
        }

        System.out.println("---BUSQUEDA CLIENTES SINO AGREGA---");
        Client client = vs.SearchClient("Lisa");
        if (client != null) {
            System.out.println("Cliente registrado" + client.getName());
        } else {
            vs.addNewClient("Lisa", "Matheu 2617", "2235221931");

        }
        mostrarClient((vs));

        //modificarFechaAlquiler(vs);

        System.out.println("devolucion:");

        vs.returns(3);

        // mostrarRent(vs);
        System.out.println("\n mas popular:\n" + vs.PopularTitle(movies));
        //vs.PopularTitle();

        //  vs.getMovies();
        System.out.println("ordenado");
        vs.orderMovies();

        System.out.println("ultimas 3:\n" + vs.getLast3ByClient("Lucia"));


    }

    private static List<Film> getFilms() {
        List<Film> movies = new ArrayList<Film>();

        Film movie1 = new Film(120, 3, "Cinderella", AudienceClassification.G, "USA", Genere.ADVENTURE);
        Film movie2 = new Film(125, 3, "The thing", AudienceClassification.R, "USA", Genere.HORROR);
        Film movie3 = new Film(130, 3, " King Kong ", AudienceClassification.PG, "USA", Genere.ACCION);
        Film movie4 = new Film(128, 3, "Godzilla", AudienceClassification.G, "JAP", Genere.ACCION);
        Film movie5 = new Film(132, 3, "Hitler", AudienceClassification.NC_17, "GER", Genere.DOCUMENTAL);
        Film movie6 = new Film(160, 3, "The Avenger", AudienceClassification.PG_13, "USA", Genere.ADVENTURE);
        Film movie7 = new Film(132, 3, "Mr Bean", AudienceClassification.G, "ENG", Genere.COMEDY);
        Film movie8 = new Film(150, 3, "Titanic", AudienceClassification.R, "ENG", Genere.DRAMA);
        Film movie9 = new Film(135, 3, "The Secret in Their Eyes", AudienceClassification.PG_13, "ARG", Genere.DRAMA);
        Film movie10 = new Film(99, 3, "Elements", AudienceClassification.G, "USA", Genere.COMEDY);


        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);
        movies.add(movie10);
        return movies;
    }

    public static void mostrarRent(VideoStore vs) {
        vs.getRents().forEach(System.out::println);
    }

    public static void mostrarClient(VideoStore vs) {
        vs.getClients().forEach(System.out::println);
    }

    public static void modificarFechaAlquiler(VideoStore vs) {
        List<Rent> rents = vs.getRents();
        rents.forEach(rent -> {
            rent.setDevolution(LocalDateTime.now().minusDays(1));
        });

        vs.setRents(rents);
    }
}

