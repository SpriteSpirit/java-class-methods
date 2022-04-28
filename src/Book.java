import java.util.Arrays;
import java.util.Objects;

public class Book {

    private static String[] nameBooks;
    private static int[] publicationDates;
    private static Author[] authors;
    private static int size;

    public Book() {
        nameBooks = new String[10];
        publicationDates = new int[10];
        authors = new Author[10];
    }

    public void addAuthor(String name, String surname) {
        if (size >= authors.length) {
            System.out.println("Authors is full. Adding a new author is restricted.");
        }
        Author newAuthor = new Author(name, surname);
        authors[size++] = newAuthor;
    }

    public void removeAuthor(String nameId) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getNameAuthor().equals(nameId)) {
                authors[i] = null;
                if (i != authors.length - 1) {
                    System.arraycopy(authors, i + 1, authors, i, size - i);
                    // Этот метод сдвигает массив влево на одну ячейку, затирая ячейку под номером i путем смещения всех элементов справа на одну ячейку влево
                }
                size--;
                System.out.println("Name " + nameId + " is removed.");
                return;
            }
        }
        System.out.println("Author " + nameId + " is not found.");
    }

    public void findAuthors(String nameId) {
        for (int i = 0; i < size; i++) {
            Author author = authors[i];
            if (author.getNameAuthor().equals(nameId)) {
                System.out.println(author.getNameAuthor() + " " + author.getSurnameAuthor());
                return;
            }
        }
        System.out.println("Author " + nameId + " is not found.");
    }

    public static void printAllAuthors() {
        for (int i = 0; i < size; i++) {
            Author author = authors[i];
            System.out.println(author.getNameAuthor() + " " + author.getSurnameAuthor());
        }
    }

    public int getCurrentSize() {
        return size;
    }

    public String[] getNameBook() {
        return nameBooks;
    }
    public void setNameBook(String[] nameBook) {
        nameBooks = nameBook;
    }

    public int[] getPublicationDate() {
        return publicationDates;
    }

    public void setPublicationDate(int[] publicationDate) {
        publicationDates = publicationDate;
    }

    public static void printAllBooks() {
        for (int i = 0; i < size; i++) {
            Author author = authors[i];
            int publicationDate = publicationDates[i];
            String nameBook = nameBooks[i];

            System.out.println(author.getNameAuthor() + " " + author.getSurnameAuthor() + ". " + publicationDate + ". "  + nameBook + ". ");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameBook='" + Arrays.toString(nameBooks) + '\'' +
                ", publicationDate=" + Arrays.toString(publicationDates) +
                ", author='" + Arrays.toString(authors) + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) {
            return false;
        }
        return getPublicationDate() == book.getPublicationDate() && Arrays.equals(getNameBook(), book.getNameBook()) && getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(getNameBook()), Arrays.hashCode(getPublicationDate()), getAuthor());
    }

    Object getAuthor() {
        return authors;
    }

}