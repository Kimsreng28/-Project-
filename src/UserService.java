import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote Interface
public interface UserService extends Remote {
    // Method to get the name of a user based on userId
    String getName(String userId) throws RemoteException;
}
