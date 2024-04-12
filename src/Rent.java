import java.time.LocalDate;

public class Rent {
    private static int i=1;
    private  int id;
    private Film film;
    private Client client;
    private LocalDate loan;
    private LocalDate devolution;

    public Rent(Film film, Client client, LocalDate loan) {
        this.id = i++;
        this.film = film;
        this.client = client;
        this.loan = loan;
        this.devolution = loan.plusWeeks(1);
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

    public LocalDate getLoan() {
        return loan;
    }

    public LocalDate getDevolution() {
        return devolution;
    }

    @Override
    public String toString() {
        return "--------------------------\n" +
               "Rent: " +
                "\nid=" + id +
                /*"film="*/  film +
                /*", client=" +*/ client +
                ",\nloan=" + loan +
                ",\ndevolution=" + devolution +
                '}';
    }
}
