// Import the 'http' module, which provides functionality for creating HTTP servers
const http = require('http');

// Define the hostname and port for the server to listen on
const hostname = '127.0.0.1';
const port = 3000;

// Create an HTTP server
const server = http.createServer((req, res) => {
    // Set the response HTTP header with a status code of 200 (OK) and content type of text/plain
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');

    // Write a response message to the client
    res.end('Hello World!\n');
});

// Start the server and make it listen for incoming requests
server.listen(port, hostname, () => {
    // Once the server is started, log a message to the console indicating that the server is running
    console.log(`Server running at http://${hostname}:${port}/`);
});
