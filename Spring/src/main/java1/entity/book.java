package entity;

/**
 * Created by leon on 2018/1/29.
 */
public class book {
    private int bookId;
    private String bookName;
    private String bookAuther;
    private int bookprice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }

    public int getbookPrice() {
        return bookprice;
    }

    public void setbookPrice(int price) {
        this.bookprice = price;
    }
}
