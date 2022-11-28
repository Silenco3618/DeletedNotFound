import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {
    @Test
    public void remove() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone4 = new Smartphone(4, "M1", 15000, "Samsung");
        Smartphone smartphone5 = new Smartphone(5, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        manager.removeById(2);

        Product[] expected = {book1, book3, smartphone4, smartphone5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone4 = new Smartphone(4, "M1", 15000, "Samsung");
        Smartphone smartphone5 = new Smartphone(5, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone4);
        manager.add(smartphone5);


        Assertions.assertThrows(NotFoundException.class,
                () -> manager.removeById(10));
    }
}
