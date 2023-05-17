const express = require('express');

const app = express();

const PORT = 4000;

const boardsRouter = require('./routers/boards.router');

app.use(express.json());
app.use((req, res, next) => {
    const start = new Date();
    console.log(`start: ${req.method} ${req.url}`);
    next();
    const end = new Date() - start;
    console.log(`${req.method} ${req.baseUrl} ${end}`)
});

app.use('/boards', boardsRouter);

app.listen(PORT, () => {
    console.log(`server start at ${PORT}`);
});