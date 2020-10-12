package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean exit = false;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!exit) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    String request;
                    request = in.readLine();

                    if (!request.isEmpty()) {
                        System.out.println(request);

                        String str;
                        while (!(str = in.readLine()).isEmpty()) {
                            System.out.println(str);
                        }

                        String[] cmd    = request.split("\\s");
                        String[] tokens = cmd[1].split("=");

                        if (tokens[1].equals("Buy")) {
                            exit = true;
                        }

                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    }
                }
            }
        }
    }
}
