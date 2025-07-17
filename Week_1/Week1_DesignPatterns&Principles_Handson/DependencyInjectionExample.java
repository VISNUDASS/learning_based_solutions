
interface CustomerRepository {
    String findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String customerId) {
        return "Customer[ID=" + customerId + ", Name=John Doe]";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(String customerId) {
        String customer = customerRepository.findCustomerById(customerId);
        System.out.println("Customer Details: " + customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.getCustomerDetails("C101");
    }
}
