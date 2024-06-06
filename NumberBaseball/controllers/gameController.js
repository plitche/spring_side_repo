// 각 게임 모드에 대한 컨트롤러 함수 정의
exports.guessAnswerAlone = (req, res) => {
    res.render('guessAnswerAlone');
};

exports.guessAnswerTwo = (req, res) => {
    res.render('guessAnswerTwo');
};

exports.guessEach = (req, res) => {
    res.render('guessEach');
};