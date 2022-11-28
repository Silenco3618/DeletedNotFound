public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) { // добавление покупки
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] removeById(int id) { //удаление покупки
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToId = 0;
        for (Product product : products) {
            if (product.getId()!= id){
                tmp[copyToId] = product;
                copyToId++;
            }
        }
        products = tmp;
        return tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public Product[] findAll() {
        return products;
    }
}