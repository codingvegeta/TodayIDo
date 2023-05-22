const http = require('http');

http.createServer((req, res) => {
    console.log(req.url, req.headers.coockie);
    res.writeHead(200, { 'Set-Cookie':'mycookie=test' });
    res.end('hello Cookie');
})
.listen(8083, ()=>{
    console.log('8083 server start');
});