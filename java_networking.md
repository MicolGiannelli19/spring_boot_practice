# Java Networking 

Theory behind Java networking before doing project 

- TCP (Transmission Control Protocol)
- UDP (User Datagram Protocol)
- Ports 


## Understanding ports 

**Motivation**: Generally speaking each computer has a single physical connection to a netwok, all data intended for that computer arrives through that connection so **ports** are used so that the data goes to the specific application it is intended to
The computer is identified by its **32-bit IP address**, which IP uses to deliver data to the right computer on the network.
**Ports** are identified by a **16-bit number**, which TCP and UDP use to deliver the data to the right application.
In connection-based communication such as TCP, a server application **binds a socket to a specific port number**

java.net, Java programs can use TCP or UDP to communicate over the Internet.

The URL, URLConnection, Socket, and ServerSocket classes all use TCP to communicate over the network.

## What is Java Network

[//]: # (TODO this could sound better)
Java networking is a powerful feature that allows Java applications to communicate over a network.
