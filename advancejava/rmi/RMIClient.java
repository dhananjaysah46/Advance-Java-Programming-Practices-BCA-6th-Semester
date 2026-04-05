package com.advancejava.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) {
        try {
            // Get registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup remote object
            HelloInterface stub =
                    (HelloInterface) registry.lookup("HelloService");

            // Call remote method
            System.out.println(stub.sayHello());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
