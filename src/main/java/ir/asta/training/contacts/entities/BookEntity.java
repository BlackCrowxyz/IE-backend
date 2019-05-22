package ir.asta.training.contacts.entities;

public class BookEntity {
    String bookname;
    String author;
    String comment;

    public BookEntity(){

    }

    public BookEntity(String bookname, String author, String comment) {
        this.bookname = bookname;
        this.author = author;
        this.comment = comment;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
