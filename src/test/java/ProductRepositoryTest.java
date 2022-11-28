import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void addProduct() {
        ProductRepository repository = new ProductRepository();
        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void remoteByIdProduct() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.removeById(3);
        Assertions.assertArrayEquals(expected, actual);
    }
}