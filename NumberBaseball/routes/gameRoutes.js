const express = require('express');
const router = express.Router();
const gameController = require('../controllers/gameController');

// 라우팅 설정
router.get('/alone', gameController.guessAnswerAlone);
router.get('/goal', gameController.guessAnswerTwo);
router.get('/each', gameController.guessEach);

module.exports = router;