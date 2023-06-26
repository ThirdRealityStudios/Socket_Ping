package io.thirdreality.learning.java.socketping;

import java.net.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;

public class Ping
{
    public static void main(String[] args) throws Exception
    {
        Socket client = new Socket("localhost", 3461);

        OutputStream requestStream = client.getOutputStream();
        PrintWriter requestWriter = new PrintWriter(requestStream);

        String message = (args.length == 1) ? args[0] : "";

        requestWriter.print(message);

        final long nsStart = System.nanoTime();
        final long secondsTimeout = 3L * 1000 * 1000 * 1000;
        long timeDiff = -1L;

        // Send request..
        requestWriter.flush();

        InputStream responseStream = client.getInputStream();
        // No need to convert or read from the responseStream
        // as I only want to know if there was response and
        // how long it took (in nanoseconds).

        timeDiff = System.nanoTime() - nsStart;

        if(timeDiff > secondsTimeout)
        {
            System.out.println("Connection timed out..");
        }
        else
        {
            System.out.println("Ping: " + timeDiff % 1000 + "ms");
        }
    }

}
