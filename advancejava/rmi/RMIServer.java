package com.advancejava.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            // Create remote object
            HelloInterface obj = new HelloImplementation();

            // Create RMI Registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind object to registry
            registry.rebind("HelloService", obj);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
