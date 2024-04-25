import java.text.MessageFormat;

public class Film implements Comparable<Film> {
    private Integer min;
    private Integer stock;

    private String title;
    private AudienceClassification category;
    private String origin;
    private Genere genero;
    private Integer cont = 0;

    public Film(Integer min, Integer stock, String title, AudienceClassification category, String origin, Genere genero) {
        this.min = min;
        this.stock = stock;
        this.title = title;
        this.category = category;
        this.origin = origin;
        this.genero = genero;

    }

    public Film() {
    }

    public Integer getMin() {
        return min;
    }

    public Integer getStock() {
        return stock;
    }

    public String getTitle() {
        return title;
    }

    public AudienceClassification getCategory() {
        return category;
    }

    public String getOrigin() {
        return origin;
    }

    public Genere getGenero() {
        return genero;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(AudienceClassification category) {
        this.category = category;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setGenero(Genere genero) {
        this.genero = genero;
    }

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }

    @Override
    public int compareTo(Film o) {
        return this.getCont().compareTo(o.getCont());
    }

    @Override
    public String toString() {
        return MessageFormat.format("\nFilm'{'\nmin={0},\nstock={1},\ntitle=''{2}'',\ncategory={3},\norigin=''{4}'',\ngenero= {5}", min, stock, title, category, origin, genero);
    }


}
