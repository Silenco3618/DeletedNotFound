import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    @Test
    public void addProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Властелин колец");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("A52");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchZeroProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1,"Властелин колец 1", 600, "Толкин");
        Book book2 = new Book(2,"Властелин колец 2", 550, "Толкин");
        Book book3 = new Book(3,"Властелин колец 3", 630, "Толкин");
        Smartphone smartphone1 = new Smartphone(1, "M1", 15000, "Samsung");
        Smartphone smartphone2 = new Smartphone(2, "A52", 23000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("A53");

        Assertions.assertArrayEquals(expected, actual);
    }
}