const express = require("express");
const http = require("http");
const path = require("path");
const socketIo = require("socket.io");
const gameRoutes = require("./routes/gameRoutes");

const app = express();
const server = http.createServer(app);
const io = socketIo(server);
const port = 3000;

let currentTurn = null;
const players = [];

// 정적 파일 제공을 위한 미들웨어 설정
app.use("/js", express.static(path.join(__dirname, "js")));

// EJS 템플릿 엔진 설정
app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "views"));

// Public 폴더를 정적 파일 제공을 위해 사용
app.use(express.static(path.join(__dirname, "public")));

// 기본 라우트
app.get("/", (req, res) => {
  res.render("index");
});

// 게임 모드 라우트
app.use("/", gameRoutes);

io.on("connection", (socket) => {
  console.log("A user connected");

  // 클라이언트가 고유한 사용자 ID를 보냄
  socket.on("register", (userId) => {
    if (!players.some((player) => player.id === userId)) {
      players.push({ id: userId, socketId: socket.id });
    }

    if (currentTurn === null && players.length > 0) {
      currentTurn = players[0].id; // 첫 번째 플레이어를 현재 턴으로 설정
    }

    socket.emit("turn", userId === currentTurn);
  });

  socket.on("turn end", (userId) => {
    const currentIndex = players.findIndex((player) => player.id === userId);
    currentTurn = players[(currentIndex + 1) % players.length].id;
    io.emit("turn", currentTurn);
  });

  socket.on("disconnect", () => {
    const index = players.findIndex((player) => player.socketId === socket.id);
    if (index !== -1) {
      players.splice(index, 1);
    }
    if (socket.id === currentTurn && players.length > 0) {
      currentTurn = players[0].id; // 다른 플레이어가 있다면 그에게 턴을 넘김
    } else if (players.length === 0) {
      currentTurn = null;
    }
    io.emit("turn", currentTurn);
  });

  socket.on("chat numbers", (msg) => {
    io.emit("chat message", msg);
  });

  socket.on("chat result", (msg) => {
    io.emit("chat result", msg);
  });
});

server.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
