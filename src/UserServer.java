import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the service implementation
            UserService userService = new UserServiceImpl();

            // Bind the service to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099); // Default RMI port
            registry.bind("UserService", userService);

            System.out.println("UserServer is ready.");
        } catch (Exception e) {
            System.err.println("UserServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
