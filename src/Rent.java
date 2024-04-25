import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rent {
    private static int i=1;
    private  int id;
    private Film film;
    private Client client;
    private LocalDateTime loan;
    private LocalDateTime devolution;

    public Rent(Film film, Client client, LocalDateTime loan) {
        this.id = i++;
        this.film = film;
        this.client = client;
        this.loan = loan;
        this.devolution = loan.plusMinutes(30);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getLoan() {
        return loan;
    }

    public LocalDateTime getDevolution() {
        return devolution;
    }

    public static void setI(int i) {
        Rent.i = i;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLoan(LocalDateTime loan) {
        this.loan = loan;
    }

    public void setDevolution(LocalDateTime devolution) {
        this.devolution = devolution;
    }

    @Override
    public String toString() {
        return "\n--------------------------\n" +
               "Rent: " +
                "\nid=" + id +
                /*"film="*/  film +
                /*", client=" +*/ client +
                ",\nloan=" + loan +
                ",\ndevolution=\n" + devolution +
                '}';
    }
}
