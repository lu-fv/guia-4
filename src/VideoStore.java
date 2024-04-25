import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VideoStore {
    public List<Film> movies = new ArrayList<>();
    public List<Client> clients = new ArrayList<>();
    public List<Rent> rents = new ArrayList<>();

    public List<Film> getMovies() {
        return movies;
    }

    public void setMovies(List<Film> movies) {
        this.movies = movies;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

   /*   public VideoStore() {

        Film movie1 = new Film(120, 5, "Cinderella", AudienceClassification.G, "USA", Genere.ADVENTURE);
        Film movie2 = new Film(125, 2, "The thing", AudienceClassification.R, "USA", Genere.HORROR);
        Film movie3 = new Film(130, 3, " King Kong ", AudienceClassification.PG, "USA", Genere.ACCION);
        Film movie4 = new Film(128, 4, "Godzilla", AudienceClassification.G, "JAP", Genere.ACCION);
        Film movie5 = new Film(132, 1, "Hitler", AudienceClassification.NC_17, "GER", Genere.DOCUMENTAL);
        Film movie6 = new Film(160, 3, "The Avenger", AudienceClassification.PG_13, "USA", Genere.ADVENTURE);
        Film movie7 = new Film(132, 1, "Mr Bean", AudienceClassification.G, "ENG", Genere.COMEDY);
        Film movie8 = new Film(150, 2, "Titanic", AudienceClassification.R, "ENG", Genere.DRAMA);
        Film movie9 = new Film(135, 2, "The Secret in Their Eyes", AudienceClassification.PG_13, "ARG", Genere.DRAMA);
        Film movie10 = new Film(99, 2, "Elements", AudienceClassification.G, "USA", Genere.COMEDY);

        this.movies[0] = movie1;
        this.movies[1] = movie2;
        this.movies[2] = movie3;
        this.movies[3] = movie4;
        this.movies[4] = movie5;
        this.movies[5] = movie6;
        this.movies[6] = movie7;
        this.movies[7] = movie8;
        this.movies[8] = movie9;
        this.movies[9] = movie10;


    }*/

    public String addNewClient(String name, String address, String tel) {
        Client newClient = new Client(name, address, tel);

        clients.add(newClient);


        return newClient.toString();
    }


    public Client SearchClient(String name) {
        for (Client c : clients) {
            if (c != null && c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public Film SearchFilm(String title) {
        for (Film f : movies) {
            if (f != null && f.getTitle().equals(title)) {
                return f;
            }
        }
        return null;
    }

    public Rent SearchRent(int id) {
        for (Rent r : rents) {
            if (r != null && r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Rent rental(String title, String name, LocalDateTime date) {
        Client client = this.SearchClient(name);
        Film f = this.SearchFilm(title);
        if (client != null && f != null) {
            if (f.getStock() > 0) {
                f.setStock(f.getStock() - 1);
                Rent rent = new Rent(f, client, date);
                f.setCont(f.getCont() + 1);
                this.rents.add(rent);
                return rent;
            }

        }
        return null;
    }

    public void vigentes(LocalDateTime now) {

        for (Rent r : rents) {

            if (now.isBefore(r.getDevolution())) {
                System.out.println(r.toString());
            }

        }
    }

    public void devoluciones(LocalDateTime now) {

        for (Rent r : rents) {

            if (now.isAfter(r.getDevolution())) {
                System.out.println(r.toString());
            }

        }
    }

    public void deleteRent(int id) {
        Rent r = SearchRent((id));
        rents.remove(r);

    }

    public void returns(int id) {
        Rent r = SearchRent((id));

        LocalDateTime now = LocalDateTime.now();
        if (r != null) {
            if (r.getDevolution().equals(now) || r.getDevolution().isBefore(now)) {
                System.out.println(r);
                String film = r.getFilm().getTitle();
                Film f = SearchFilm(film);
                f.setStock(f.getStock() + 1);
                deleteRent(id);
            }
        }
    }


    public Film PopularTitle(List<Film> movies) {
        Film popular = null;
        Integer mostP = -1;
        for (Film f : movies) {

            if ((f != null) && f.getCont() > mostP) {
                mostP = f.getCont();
                popular = f;

            }
        }
        return popular;
    }

    public String getLast3ByClient(String name) {
        String list = "";
        if (SearchClient(name) != null) {
            int i = rents.size() - 1;
            int j = 0;
            while (i >= 0 && j < 3) {
                if (rents.get(i).getClient().getName().equals(name)) {
                    j++;
                    list += rents.get(i).toString();
                }
                i--;
            }
        }
        return list;
    }

    public void orderMovies() {    /// https://www.arquitecturajava.com/java-comparator-interface-y-lambdas/

        Comparator<Film> comparatorA = (f1, f2) -> f1.getGenero().compareTo(f2.getGenero());
        Comparator<Film> comparatorB = comparatorA.thenComparing((f1, f2) -> f1.getOrigin().compareTo(f2.getOrigin()));
        Comparator<Film> comparatorC = comparatorB.thenComparing((f1, f2) -> f1.getTitle().compareTo(f2.getTitle()));
        movies.sort(comparatorC);

        movies.forEach(System.out::println);

    }

    @Override
    public String toString() {
        return "VideoStore{" +
                "movies=" + movies +
                ", clients=" + clients +
                ", rents=" + rents +
                '}';
    }
}
