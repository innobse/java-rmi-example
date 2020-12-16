package ru.bse71.examples.java.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import ru.bse71.examples.java.rmi.common.TimeConverter;
import ru.bse71.examples.java.rmi.common.TimeConverterRemote;
import sun.rmi.registry.RegistryImpl;

public class Main {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        grantedAccess();

        TimeConverter timeConverter = new TimeConverter();
        TimeConverterRemote stub = (TimeConverterRemote) UnicastRemoteObject.exportObject(timeConverter, 0);

//        Registry registry = new RegistryImpl(1099);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("time", stub);

        System.out.println("Successfully bound time object");
    }

    private static void grantedAccess() {
        System.setProperty("java.security.policy","file:./.java-policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(
                new SecurityManager()
            );
        }
    }
}
