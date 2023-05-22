const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
    res.write('<h1>Hello World</h1>');
    res.end('<p>Hello Server</p>');
})
server.listen(8080);

server.on('listening', () => {
    console.log('Server is listening on port 8080');
});
server.on('error', (err) => {
    console.log(err);
});