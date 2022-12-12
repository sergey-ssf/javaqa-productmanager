import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void ask4ProductsTest() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
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

    @Test
    public void removeProductWithId3Test() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
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

    @Test
    public void findProductByTextTest() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Smartphone phone1 = new Smartphone(1, "Galaxy 1", 450, "Samsung");
        Smartphone phone2 = new Smartphone(2, "Galaxy 2", 500, "Samsung");
        Smartphone phone3 = new Smartphone(3, "iPhone 3", 1550, "Apple");

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = { phone1, phone2 };
        Product[] actual = repository.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);
    }

}
