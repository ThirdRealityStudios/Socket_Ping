# Ping server with client, using Sockets

There is an example client (Ping.java, using java.net.Socket)
as well as server (PingServer.java, using SocketServer) in order to
send a request and calculate the time difference (in ms).

# How does calculating the ping time work?

The actual calculation occurs in the file Ping.java (client / Socket)
and it simply remembers the initial time directly before sending the request
and the time after receiving the corresponding response.
Hence,
the ping time is being calculated by the difference of both values.