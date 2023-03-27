package ra.run;

import ra.bussinessImp.Book;
import ra.bussinessImp.SortByProfit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        LinkedList<Book> listBook = new LinkedList<>();


        int inputChoice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("****************BOOK MANAGEMENT -MENU***************");
            System.out.println("1. Nhập số sách và nhập thông tin sách ");
            System.out.println("2. Hiển thị thông tin các sách ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần ");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            inputChoice = Integer.parseInt(sc.nextLine());
            switch (inputChoice) {
                case 1:
                    System.out.println("Nhập số sách cần nhập : ");
                    int inputNumber = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < inputNumber; i++) {
                        Book newBook = new Book();
                        newBook.inputData();
                        listBook.add(newBook);
                    }
                    break;
                case 2:
                    for (Book book : listBook) {
                        System.out.println(book);
                    }
                    break;
                case 3:
                    Collections.sort(listBook, new SortByProfit() {
                        @Override
                        public int compare(Book o1, Book o2) {
                            return o1.getInterest() < o2.getInterest() ? 1
                                    : o1.getInterest() > o2.getInterest() ? -1
                                    : 0;
                        }
                    });
                    break;
                case 4:
                    System.out.println("Nhap Ma sach can xoa");
                    int idDel = Integer.parseInt(sc.nextLine());
                    Book selectBook = findBook(idDel, listBook);
                    if (selectBook != null) {
                        listBook.remove(selectBook);
                        System.out.println("Xoá thành công!");
                        return;
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                    break;
                case 5:

                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }

        } while (inputChoice != 7);
    }

    public static Book findBook(int id, LinkedList<Book> listBook) {
        boolean isExist = false;
        for (Book book : listBook) {
            if (book.getBookId() == id) {
                isExist = true;
                return book;
            }
        }
        return null;
    }
}
