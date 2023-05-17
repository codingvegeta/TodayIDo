const express = require('express')
const boardController = require('../controllers/boards.controller');
const boardsRouter = express.Router();


boardsRouter.get('/', boardController.getBoards)
boardsRouter.get('/:id', boardController.getBoard)
boardsRouter.post('/', boardController.addBoards)
boardsRouter.put('/', boardController.modifyBoard)
boardsRouter.delete('/:id', boardController.deleteBoard)

module.exports = boardsRouter;