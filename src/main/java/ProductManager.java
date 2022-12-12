public class ProductManager {

    Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void remove(Product product) {
        repository.removeById(product.id);
    }

    public Product[] givAll() {
        return repository.giveAll();
    }
}
