package d01_Shoppy.customer.customersData;

import d01_Shoppy.customer.Customer;
import d01_Shoppy.customer.enums.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomersData {
    private final List<Customer> customersList;
    private int nextId;

    public CustomersData(){
        this.customersList = new ArrayList<>();
        this.nextId = 1000;
        seedCustomersData();
    }

    private void seedCustomersData(){
        customersList.add(new Customer(nextId++, "Benito", "Rodriguez", "br1001@testing.com"));
        customersList.add(new Customer(nextId++, "Carlo", "Magno", "cM1002@testing.com"));
    }

    public Customer getCustomerById(int customerId){
        for(Customer c : customersList){
            if (c.getId() == customerId)
                return c;
        }
        return null;
    }

    public Customer editSubscription(Scanner scanner, Customer oldCustomer, Subscription newSubscription){
        oldCustomer.setSubscription(newSubscription);
        return oldCustomer;
    }

    public Customer editCustomer(Scanner scanner, Customer oldCustomer){
        System.out.println("\n===== EDIT CUSTOMERS PROFILE =====");
        System.out.println("Enter your new name. If you don't want to change it, just press enter.");
        System.out.print("> ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty())
            oldCustomer.setFirstName(name);

        System.out.print("Enter your lastname.  If you don't want to change it, just press enter.");
        System.out.print("> ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty())
            oldCustomer.setLastName(lastName);

        System.out.println("Enter your email. If you don't want to change it, just press enter.");
        System.out.print("> ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty())
            oldCustomer.setEmail(email);

        return oldCustomer;
    }

    public Customer addCustomer(Scanner scanner){
        System.out.println("\n===== NEW CUSTOMER REGISTRATION =====");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your lastname: ");
        String lastname = scanner.nextLine().trim();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();

        Customer newCustomer = new Customer(nextId++, name, lastname, email);
        customersList.add(newCustomer);

        System.out.println("Customer created successfully with the ID " + newCustomer.getId());
        return newCustomer;
    }

    public List<Customer> getAllCustomers(){return customersList;
    }

    public Customer deleteCustomer(Scanner scanner, Customer deletedCustomer){
        deletedCustomer.setSubscription(null);
        return deletedCustomer;
    }
}
