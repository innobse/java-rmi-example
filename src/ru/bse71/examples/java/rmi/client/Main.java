package ru.bse71.examples.java.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ru.bse71.examples.java.rmi.common.TimeConverterRemote;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry("127.0.0.1");

        final TimeConverterRemote timeConverterRemote = (TimeConverterRemote) registry.lookup("time");
        System.out.println(timeConverterRemote.convertToSeconds(5, 6));
    }
}
