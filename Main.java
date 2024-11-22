
// Interface DataSource
interface DataSource {
    void execute();
}

// Concrete command classes
class Update implements DataSource {
    @Override
    public void execute() {
        // Implementation for update operation
    }
}

class View implements DataSource {
    @Override
    public void execute() {
        // Implementation for view operation
    }
}

class Delete implements DataSource {
    @Override
    public void execute() {
        // Implementation for delete operation
    }
}

// Abstract base class Account
abstract class Account {
    protected int id;
    protected String name;
    protected DataSource myData;
    
    public void performOperation(DataSource myData) {
        this.myData = myData;
        myData.execute();
    }
}

// Concrete Admin class
class Admin extends Account {
    private String authPassword;
    
    public Admin(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.authPassword = password;
    }
}

// Concrete User class
class User extends Account {
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class Main {
    public static void main(String[] args) {
        // instances of commands
        DataSource updateOperation = new Update();
        DataSource viewOperation = new View();
        DataSource deleteOperation = new Delete();
        
        // an admin and a regular user
        Admin admin = new Admin(1, "John Admin", "securePass123");
        User user = new User(2, "Jane User");
        
        System.out.println("Demonstrating Admin operations:");
        System.out.println("Admin: " + admin.name);
        // Admin performing all operations
        admin.performOperation(viewOperation);
        admin.performOperation(updateOperation);
        admin.performOperation(deleteOperation);
        
        System.out.println("\nDemonstrating User operations:");
        System.out.println("User: " + user.name);
        // User performing operations
        user.performOperation(viewOperation);
        user.performOperation(updateOperation);
        
        // Demonstrate polymorphism with Account reference
        System.out.println("\nDemonstrating polymorphism:");
        Account account = admin;  // Using Account reference to hold Admin
        account.performOperation(viewOperation);
        System.out.println("account name: "+ account.name);
        
        account = user;  // Using Account reference to hold User
        account.performOperation(viewOperation);
        System.out.println("account name: "+ account.name);
    }
}
