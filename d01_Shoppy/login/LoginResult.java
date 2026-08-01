package d01_Shoppy.login;

import d01_Shoppy.customer.Customer;

public record LoginResult(boolean success, Customer customer) {
}
