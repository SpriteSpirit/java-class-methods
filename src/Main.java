public class Main {
    public static void main(String[] args) {
        separator();
        Book infoBook = new Book();
        infoBook.addAuthor("Joanne", "Rowling");
        infoBook.addAuthor("John", "Tolkien");
        infoBook.setPublicationDate(new int[]{1997, 1954});
        infoBook.setNameBook(new String[]{"Harry Potter and the Philosopher's Stone", "The Lord of the Rings"});
        Book.printAllBooks();
        separator();
    }

    public static void separator() {
        System.out.println("=================================================================");
    }

}