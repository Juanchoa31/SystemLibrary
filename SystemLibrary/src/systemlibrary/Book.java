package systemlibrary;

public class Book {

    private String title, autor;
    private int yearPublication;
    private String available;
    

    public Book() {
    }

    public Book(String title, String autor, int yearPublication) {
        this.title = title;
        this.autor = autor;
        this.yearPublication = yearPublication;
        this.available = "Disponible";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Libro: " + "Título = " + title + ", Autor = " + autor + ", Año de publicación = " + yearPublication + ", Estado = " + available;
    }
}
