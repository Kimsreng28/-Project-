import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserClient {
    public static void main(String[] args) {
        try {
            // Locate the RMI registry on localhost
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the UserService
            UserService userService = (UserService) registry.lookup("UserService");

            // Call the getName method and print the results
            String name1 = userService.getName("1");
            System.out.println("Name for user 1: " + name1);

            String name2 = userService.getName("2");
            System.out.println("Name for user 2: " + name2);

            String name3 = userService.getName("3");
            System.out.println("Name for user 3: " + name3);
        } catch (Exception e) {
            System.err.println("UserClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
