package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        System.out.println("Enter the server port number: ");
        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен!");

            while (true) {
                  new Handler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((name, con) -> {
            try {
                con.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не отправлено");
            }
        });

//        try {
//            for(Connection con: connectionMap.values()) {
//                con.send(message);
//            }
//        } catch (Exception e) {
//            ConsoleHelper.writeMessage("Сообщение не отправлено");
//        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String userName;

            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());
            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данных с удаленным адресом");
            }

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name;
            Message message;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                name = message.getData();

                if(message.getType() != MessageType.USER_NAME) continue;

                if(name.equals("")
                        || connectionMap.containsKey(name)) continue;

                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for(String usrName: connectionMap.keySet()) {
                if(userName.equals(usrName)) continue;
                connection.send(new Message(MessageType.USER_ADDED, usrName));
            }
        }

        // String.format("%s: %s",userName, message.getData())

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;

            while (true) {
                message = connection.receive();
                if(message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else ConsoleHelper.writeMessage("Error");
            }
        }
    }
}
