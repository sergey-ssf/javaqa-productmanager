import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    // 1.1 Проверяем, что можем добавлять книги и получать их обратно
    @Test
    public void ask4BooksTest() {
        Book book1 = new Book(1, "Dragon 1", 450, "Conan");
        Book book2 = new Book(2, "Dragon 2", 500, "Conan");
        Book book3 = new Book(3, "Dragon 3", 400, "Conan");
        Book book4 = new Book(4, "Dragon 4", 650, "Conan");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = repository.giveAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // 1.2 Проверяем, что можем добавлять смартфоны и получать их обратно

    @Test
    public void ask3PhonesTest() {
        Smartphone phone1 = new Smartphone(1, "Galaxy 1", 450, "Samsung");
        Smartphone phone2 = new Smartphone(2, "Galaxy 2", 500, "Samsung");
        Smartphone phone3 = new Smartphone(3, "iPhone 3", 1550, "Apple");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = repository.giveAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    // 2.1 Проверяем, что можем удалить книги по id.

    @Test
    public void removeBookByIdTest() {
        Book book1 = new Book(1, "Dragon 1", 450, "Conan");
        Book book2 = new Book(2, "Dragon 2", 500, "Conan");
        Book book3 = new Book(3, "Dragon 3", 400, "Conan");
        Book book4 = new Book(4, "Dragon 4", 650, "Conan");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        int id = 3;
        repository.removeById(id);

        Product[] expected = {book1, book2, book4};
        Product[] actual = repository.giveAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // 2.2 Проверяем, что можем удалить смартфоны по id.

    @Test
    public void removeSmartphoneTest() {
        Smartphone phone1 = new Smartphone(5, "Galaxy 1", 450, "Samsung");
        Smartphone phone2 = new Smartphone(6, "Galaxy 2", 500, "Samsung");
        Smartphone phone3 = new Smartphone(7, "iPhone 3", 1550, "Apple");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        int id = 7;
        repository.removeById(id);


        Product[] expected = {phone1, phone2};
        Product[] actual = repository.giveAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    // 3.1 Проверяем, что можем найти книгу по названию
    @Test
    public void findProductBookByTextTest() {
        Book book1 = new Book(1, "Dragon 1", 450, "Conan");
        Book book2 = new Book(2, "Dragon 2", 500, "Conan");
        Book book3 = new Book(3, "Last Day 1", 400, "Conan");
        Book book4 = new Book(4, "Dragon 3", 650, "Conan");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book2, book4};
        Product[] actual = manager.searchBy("Dragon");

        Assertions.assertArrayEquals(expected, actual);
    }


    // 3.2 Проверяем, что можем найти книгу по названию.
    @Test
    public void findProductPhoneByTextTest() {
        Smartphone phone1 = new Smartphone(1, "Galaxy 1", 450, "Samsung");
        Smartphone phone2 = new Smartphone(2, "Galaxy 2", 500, "Samsung");
        Smartphone phone3 = new Smartphone(3, "iPhone 3", 1550, "Apple");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone1, phone2};
        Product[] actual = manager.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);
    }

}
