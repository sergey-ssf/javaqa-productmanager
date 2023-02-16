public class ProductManager {

    Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    // 1. Добавление продукта
    public void add(Product product) {
        repository.add(product);
    }

    // 2. Удаление продукта по его id

    public void remove(Product product) {
        repository.removeById(product.id);
    }

    // 3. Получение всех продуктов
    public Product[] giveAll() {
        return repository.giveAll();
    }

    // 4. Поиск продуктов по текстовой строке
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : giveAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
