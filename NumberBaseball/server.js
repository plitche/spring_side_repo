const express = require('express');
const path = require('path');
const gameRoutes = require('./routes/gameRoutes');
const app = express();
const port = 3000;

// 정적 파일 제공을 위한 미들웨어 설정
app.use('/js', express.static(path.join(__dirname, 'js')));

// EJS 템플릿 엔진 설정
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Public 폴더를 정적 파일 제공을 위해 사용
app.use(express.static(path.join(__dirname, 'public')));

// 기본 라우트
app.get('/', (req, res) => {
    res.render('index');
});

// 게임 모드 라우트
app.use('/', gameRoutes);

app.listen(port, () => {
    console.log(`Server is running at http://localhost:${port}`);
});