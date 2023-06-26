package io.thirdreality.learning.java.socketping;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;

public class PingServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket server = new ServerSocket(3461);

        boolean exit = false;

        while(!exit)
        {
            Socket client = server.accept();

            if(client == null)
                continue;

            InputStream iS = client.getInputStream();
            Scanner s = new Scanner(iS);

            if(s.hasNextLine())
            {
                String clientMsg = s.nextLine();

                if(clientMsg.equals("/exit"))
                {
                    exit = true;
                }
                else
                {
                    OutputStream response = client.getOutputStream();
                    PrintWriter responseWriter = new PrintWriter(response);

                    // Send back message. Client will calculate the time differe>
                    responseWriter.println(clientMsg);
                    responseWriter.flush();
                }
            }
        }

        System.out.println("Server offline");
    }
}
