package homework_1;

public class Main {
  public static void main(String[] args) {
      Library library = new Library();

      Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
      Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, true);
      Book book3 = new Book("Pride and Prejudice", "Jane Austen");
      library.addBook(book1);
      library.addBook(book2);
      library.addBook(book3);
      System.out.println("Available books:");
      library.printAvailableBooks();

      System.out.println("Available books:");
      library.printAvailableBooks();

      book1.borrowBook();

      System.out.println("Available books after borrowing one:");
      library.printAvailableBooks();
  }
}

class Book{
  String title;
  String author;
  int year;
  boolean isAvailable = true;

  public Book(String title, String author, int year, boolean isAvailable) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.isAvailable = isAvailable;
  }

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isAvailable = true;
  }

  public void borrowBook() {
    if (isAvailable) {
      isAvailable = false;
    }
  }

  public void returnBook() {
    if (!isAvailable) {
      isAvailable = true;
    }
  }

  public void displayInfo() {
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Year: " + year);
    System.out.println("Is available: " + isAvailable);
  }
}

  class Library{
  public static Book[] books = new Book[10];

  public static void addBook(Book book) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        books[i] = book;
        break;
      }
    }
  }
  public void printAvailableBooks() {
    for (int i = 0; i < books.length; i++) {
      if (books[i] != null && books[i].isAvailable) {
        books[i].displayInfo();
      }
    }
  }

  public void findBooksByAuthor(String author) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] != null && books[i].author.equals(author)) {
        books[i].displayInfo();
      }
    }
  }
}
