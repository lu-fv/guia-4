public class Film {
    private Integer min;
    private Integer stock;
    private String title;
    private AudienceClassification category;
    private  String origin;
    private Genere genero;

    public Film(Integer min, Integer stock, String title, AudienceClassification category, String origin, Genere genero) {
        this.min = min;
        this.stock = stock;
        this.title = title;
        this.category = category;
        this.origin = origin;
        this.genero = genero;
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

    @Override
    public String toString() {
        return "Film{" +
                "min=" + min +
                ", stock=" + stock +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", origin='" + origin + '\'' +
                ", genero=" + genero +
                '}';
    }
}
