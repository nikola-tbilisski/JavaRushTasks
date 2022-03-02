package com.javarush.task.task32.task3208;


import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/

public class Solution {
    private static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static final Thread CLIENT_THREAD = new Thread(() -> {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static final Thread SERVER_THREAD = new Thread(() -> {
            try {
                registry = LocateRegistry.createRegistry(2099);
                Cat catService = new Cat("Tom");
                Dog dogService = new Dog("Atom");

                Remote catStub = UnicastRemoteObject.exportObject(catService, 0);
                Remote dogStub = UnicastRemoteObject.exportObject(dogService, 0);

                registry.bind(Cat.class.getSimpleName(), catStub);
                registry.bind(Dog.class.getSimpleName(), dogStub);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace(System.err);
            }
            //напишите тут ваш код

    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
