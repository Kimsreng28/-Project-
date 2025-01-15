import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote interface
public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    // Constructor
    protected UserServiceImpl() throws RemoteException {
        super();
    }

    // Implementation of the getName method
    @Override
    public String getName(String userId) throws RemoteException {
        if ("1".equals(userId)) {
            return "Kim Kim";
        } else if ("2".equals(userId)) {
            return "Sour Sour";
        } else {
            return "Unknown user";
        }
    }
}
