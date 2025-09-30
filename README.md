# Multithreaded Web Server in Java

A simple, lightweight, and educational multithreaded TCP server built in Java. This project demonstrates how to handle multiple client connections concurrently using a thread pool, providing a foundational understanding of network programming and concurrency in Java.

This project is participating in **Hacktoberfest 2025**! We welcome all contributors.

## Features

* **Concurrent Client Handling:** Utilizes a fixed-size thread pool (`ExecutorService`) to efficiently manage and serve multiple clients at the same time.
* **Socket-Based Communication:** Built on Java's core `java.net` library for robust and low-level network communication.
* **Scalable Architecture:** The use of a thread pool makes the server more scalable than a simple thread-per-client model.
* **Easy to Understand:** The code is written to be clear and straightforward, making it an excellent resource for learning.

## Prerequisites

Before you begin, ensure you have the following installed on your system:
* Java Development Kit (JDK) 11 or higher.

## How to Run

Follow these instructions to get the server and client running on your local machine.

**1. Clone the repository:**
```bash
git clone https://github.com/farazkamali/multithreaded-web-server
```

**2. Navigate to the project directory:**
```bash
cd multithreaded-web-server-in-java
```

**3. Compile the Java source files:**
```bash
javac Server.java Client.java
```

**4. Run the Server:**
Open a terminal window and run the following command to start the server. It will start listening for connections on port `8010`.
```bash
java Server
```
You should see the output: `Server is listening on port 8010`

**5. Run the Client:**
Open one or more **new** terminal windows and run the client command. The client will attempt to connect to the server.
```bash
java Client
```
The client will send a message and print the response it receives from the server. You can run this command multiple times to simulate multiple clients connecting concurrently.

## How to Contribute (Hacktoberfest)

We are excited to welcome contributions during Hacktoberfest! If you're looking for a place to make your first open-source contributions, you've found it.

**Contribution Ideas:**
* Improve error handling and logging.
* Add comments and Javadoc to explain the code better.
* Write unit tests for the server logic.
* Allow the port number to be configured via command-line arguments.
* Implement a more sophisticated protocol (e.g., basic HTTP GET requests).

**Steps to Contribute:**
1.  **Fork** this repository.
2.  Create a new **branch** for your feature (`git checkout -b feature/YourAmazingFeature`).
3.  **Commit** your changes (`git commit -m 'Add some YourAmazingFeature'`).
4.  **Push** to the branch (`git push origin feature/YourAmazingFeature`).
5.  Open a **Pull Request**.

All contributions will be reviewed and merged promptly. Happy hacking!
