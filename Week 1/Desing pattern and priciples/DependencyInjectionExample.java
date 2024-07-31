public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.findCustomerById("123");
    }
}

interface CustomerRepository {
    void findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public void findCustomerById(String customerId) {
        System.out.println("Finding customer with ID: " + customerId);
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void findCustomerById(String customerId) {
        repository.findCustomerById(customerId);
    }
}
