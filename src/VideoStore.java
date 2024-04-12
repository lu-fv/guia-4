import java.time.LocalDate;
import java.util.Arrays;

public class VideoStore {
    public Film[] movies = new Film[30];
    public Client[] clients = new Client[10];
    public Rent[] rents = new Rent[30];

    public Film[] getMovies() {
        return movies;
    }

    public Client[] getClients() {
        return clients;
    }

    public Rent[] getRents() {
        return rents;
    }

    public void setMovies(Film[] movies) {
        this.movies = movies;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public void setRents(Rent[] rents) {
        this.rents = rents;
    }


    public VideoStore() {

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


    }

    public String addNewClient(String name, String address, String tel) {
        Client newClient = new Client(name, address, tel);

        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = newClient;
                break;
            }
        }

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
            if  (f != null && f.getTitle().equals(title)) {
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

    public Rent rental(String title, String name) {
        Client client = this.SearchClient(name);
        Film f = this.SearchFilm(title);
        if (client != null && f != null) {
            if (f.getStock() > 0) {
                f.setStock(f.getStock() - 1);
                Rent rent = new Rent(f, client, LocalDate.now());
                for (int i = 0; i < rents.length; i++) {
                    if (rents[i]== null) {
                        rents[i] = rent;
                        break;
                    }
                }
                return rent;
            }

        }
        return null;
    }
    public void vigentes (LocalDate dateNow){

        for (Rent r : rents) {
            if (r!=null) {
                LocalDate dateRent = r.getLoan().plusWeeks(1);
                if (dateRent.compareTo(dateNow) > 0) {
                    System.out.println(r.toString());
                }
            }
        }
    }
    public VideoStore deleteRent (int id){
        for (int i=0;i< rents.length; i++){
            if (rents[i]!=null && rents[i].getId()==id){
                rents[i]= null ;
            }
        }
        return null;
    }

    public void returns (int rentId) {
        Rent r = SearchRent((rentId));
               if (r != null) {
                String film = r.getFilm().getTitle();
                Film f = SearchFilm(film);
                f.setStock(f.getStock() + 1);
                deleteRent(rentId);
                }
            }


    @Override
    public String toString() {
        return "VideoStore{" +
                "movies=" + Arrays.toString(movies) +
                ", clients=" + Arrays.toString(clients) +
                ", rents=" + Arrays.toString(rents) +
                '}';
    }
}
