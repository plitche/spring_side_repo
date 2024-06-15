 // 랜덤 숫자 생성 함수 불러오기
const generateRandomNumber = require('../js/generateRandomNumber');

// 각 게임 모드에 대한 컨트롤러 함수 정의
exports.guessAnswerAlone = (req, res) => {
    const randomNumber = generateRandomNumber();
    res.render('guessAnswerAlone', { randomNumber });
};

exports.guessAnswerTwo = (req, res) => {
    const randomNumber = generateRandomNumber();
    res.render('guessAnswerTwo', { randomNumber });
};

exports.guessEach = (req, res) => {
    const randomNumber = generateRandomNumber();
    res.render('guessEach', { randomNumber });
};