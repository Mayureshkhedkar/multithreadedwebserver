# Multi-Threaded Java Web Server

A refactored version of my previous Java web server project, upgraded to support **multi-threaded concurrent request handling**.

## 🚀 Overview
While my initial implementation was a single-threaded server, this version introduces **Java Threads** to handle multiple client connections simultaneously. By spawning a new thread for every accepted socket connection, the server no longer blocks, allowing for significantly higher throughput and concurrent request processing.

## 🛠 Features
- **Concurrent Request Handling**: Uses Java `Thread` to process multiple client sockets in parallel.
- **Improved Architecture**: The server main loop now focuses exclusively on listening for and accepting new connections.
- **Scalability Testing**: Included `client.java` script that simulates **100 simultaneous client requests** to verify multi-threaded performance.
- **Timeout Management**: Includes `soTimeout` functionality to manage server lifecycle and resource allocation.

## 📁 Project Structure
- `server.java`: Implements the multi-threaded server using `ServerSocket` and thread-per-connection logic.
- `client.java`: A simulation client that uses a loop to spawn 100 threads, each attempting to connect to the server concurrently.

## 📋 How It Works
1. The **Server** starts and binds to port `8010`.
2. The **Server** enters a `while(true)` loop to accept incoming connections.
3. For every connection accepted, the server spawns a new **Thread** using a `Consumer` to handle the I/O operations.
4. The **Client** uses a `for` loop to trigger 100 connection attempts simultaneously.
5. The **Server** processes all 100 requests in parallel, effectively preventing the blocking bottleneck of the previous version.



## 📈 Learning Path: Next Steps
- [ ] Refactor thread management to use a **Thread Pool (`ExecutorService`)** for better resource efficiency.
- [ ] Implement a more robust HTTP response protocol.
- [ ] Add basic error handling for thread interruptions and socket closures.

## 🤝 Credits & Inspiration
This project is part of my ongoing learning journey in Java backend development, moving from fundamental networking concepts to concurrent, scalable system design.

---
*Built with ❤️ in Java*
