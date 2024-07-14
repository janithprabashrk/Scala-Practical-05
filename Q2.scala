import scala.collection.mutable
import scala.io.StdIn.readLine

object LibraryManagementSystem {
  case class Book(
    title: String, 
    author: String, 
    isbn: String)

  val library: mutable.Set[Book] = mutable.Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "1234567891"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567892")
  )

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println("\nLibrary Management System")
      println("1. Display all books")
      println("2. Add a new book")
      println("3. Remove a book by ISBN")
      println("4. Check if a book is in the library by ISBN")
      println("5. Search for a book by title")
      println("6. Display all books by a specific author")
      println("7. Exit")
      val choice = readLine("Choose an option : ").toInt

      choice match {
        case 1 => displayBooks()
        case 2 => addBook()
        case 3 => removeBook()
        case 4 => checkBook()
        case 5 => searchByTitle()
        case 6 => displayByAuthor()
        case 7 => continue = false
        case _ => println("Invalid option, please try again.")
      }
    }
  }

  def displayBooks(): Unit = {
    println("\nLibrary Collection:")
    library.foreach(book => println("Title: " + book.title + "Author : " + book.author + "ISBN : " + book.isbn))
  }

  def addBook(): Unit = {
    val title = readLine("Enter the title of the book: ")
    val author = readLine("Enter the author of the book: ")
    val isbn = readLine("Enter the ISBN of the book: ")
    val newBook = Book(title, author, isbn)
    if (library.add(newBook)) {
      println("Book added successfully.")
    } else {
      println("Book already exists in the library.")
    }
  }

  def removeBook(): Unit = {
    val isbn = readLine("Enter the ISBN of the book to remove: ")
    library.find(_.isbn == isbn) match {
      case Some(book) => 
        library.remove(book)
        println("Book removed successfully.")
      case None => println("Book not found.")
    }
  }

  def checkBook(): Unit = {
    val isbn = readLine("Enter the ISBN of the book to check: ")
    if (library.exists(_.isbn == isbn)) {
      println("The book is in the library.")
    } else {
      println("The book is not in the library.")
    }
  }

  def searchByTitle(): Unit = {
    val title = readLine("Enter the title of the book to search: ")
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) => println("Found: Title: " + book.title +  "Author : " + book.author + "ISBN : " + book.isbn)
      case None => println("Book not found.")
    }
  }

  def displayByAuthor(): Unit = {
    val author = readLine("Enter the author: ")
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println("\nBooks by " + author + " : ")
      booksByAuthor.foreach(book => println("Title : " + book.title  + "ISBN : " + book.isbn))
    } else {
      println("No books found by " + author )
    }
  }
}
