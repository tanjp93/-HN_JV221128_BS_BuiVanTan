package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;


public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private  String bookName;
    private  String title;
    private  int numberOfPages;
    private   float importPrice;
    private   float exportPrice;
    private   float interest;
    private   Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
        this.interest = exportPrice - importPrice;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập Book Id: ");
        bookId = Integer.parseInt( scanner.nextLine());

        System.out.print("Nhập tên sách: ");
        bookName = scanner.nextLine();

        System.out.print("Nhập tiêu đề: ");
        title = scanner.nextLine();

        System.out.print("Nhập số trang sách: ");
        numberOfPages = Integer.parseInt( scanner.nextLine());


        System.out.print("Nhập giá nhập sách: ");
        importPrice = Float.parseFloat(scanner.nextLine());


        System.out.print("Nhập giá bán sách: ");
        exportPrice = Float.parseFloat(scanner.nextLine());


        System.out.print("Nhập trạng thái sách: ");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());


        interest = exportPrice - importPrice;
    }



    @Override
    public void displayData() {
        System.out.println(
                "Thông tin Sách :\n" +
                        "\tMã Sách :" + bookId +"\n"+
                        "\t, Tên Sách :'" + bookName + "\n" +
                        "\t, title :'" + title + "\n" +
                        "\t, numberOfPages :" + numberOfPages +"\n"+
                        "\t, importPrice :" + importPrice +"\n"+
                        "\t, exportPrice :" + exportPrice +"\n"+
                        "\t, Lợi Nhuận :" + interest +"\n"+
                        "\t, Còn Hàng :" + bookStatus
        );
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + bookStatus +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Float.compare(this.interest, o.getInterest());
    }
}
