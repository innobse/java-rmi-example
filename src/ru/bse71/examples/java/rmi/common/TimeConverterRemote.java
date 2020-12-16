package ru.bse71.examples.java.rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeConverterRemote extends Remote {

  Integer convertToSeconds(Integer hours, Integer minutes) throws RemoteException;
}
