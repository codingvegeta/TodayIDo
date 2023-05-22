const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length;

if (cluster.isMaster) {
    console.log(`마스터 프로세스 아이디: ${process.pid}`);

    for(let i = 0; i < numCPUs; i++) {
        cluster.fork();
    }

    cluster.on('exit', (worker, code, signal) => {
            console.log(`worker ${worker.process.pid} died`);
            console.log(`code: ${code}, signal: ${signal}`);
            cluster.fork();
        });
    }else {

        http.createServer((req, res) => {
                    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                    res.write('<h1>Hello World</h1>');
                    res.end('Hello World\n');
                    setTimeout(() => {
                        process.exit(1);
                        }, 1000);
                    }).listen(8086);
                console.log(`${process.pid} 번 워커 실행`);
            }