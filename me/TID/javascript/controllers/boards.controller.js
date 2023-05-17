const model = require('../models/boards')

function getBoards(req, res) {
    res.json(model)
}

function getBoard(req, res) {
    const findBoard = model[req.params.id]
    console.log(findBoard);
    return res.json(findBoard);
}

function addBoards(req, res) {
    if (!req.body.name || !req.body.post) {
        return res.status(400).json({error: 'Missing username or posts'});
    }

    const newBoard = {
        id: model.length,
        name: req.body.name,
        post: req.body.post
    }
    model.push(newBoard);

    res.json(newBoard);
}

function modifyBoard(req, res) {
    if (!req.body.id || !req.body.post) {
        return res.status(400).json({error: 'Missing userId or post'})
    }

    return model[req.body.id].post = req.body.post;
}

function deleteBoard(req, res) {
    if (!req.params.id) {
        return res.status(400).json({error: 'Missing id'})
    }

    model.splice(req.params.id, 1);
}

module.exports = {
    getBoard,
    getBoards,
    addBoards,
    modifyBoard,
    deleteBoard
}