package d01_Shoppy.customer;

import d01_Shoppy.customer.enums.Subscription;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Subscription subscription;

    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subscription = Subscription.NORMAL;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstName(){return firstName;}

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public String getEmail() {return email;}

    public void setEmail(String email){this.email = email;}

    public Subscription getSubscription(){return subscription;}

    public void setSubscription(Subscription subscription){this.subscription = subscription;}
}
