const regex1 = /^\d{4}$/;

// 랜덤 숫자 만들기
function makeRandomNum() {
  const digits = [];

  while (digits.length < 4) {
    const randomDigit = Math.floor(Math.random() * 10);
    if (!digits.includes(randomDigit)) {
      digits.push(randomDigit);
    }
  }

  return digits.join("");
}

// 숫자 정규식 체크
function isNumber(number) {
  return regex1.test(number);
}

// 중복 숫자 여부 체크
function hasDuplicates(number) {
  let numArray = number.split("");
  let numSet = new Set(numArray);
  return numSet.size !== numArray.length;
}

// 숫자 예시 제어
function exampleNumbersControl() {
  $(".num").on("click", function () {
    if ($(this).hasClass("hide")) {
      $(this).removeClass("hide");
    } else {
      $(this).addClass("hide");
    }
  });
}

function testCommit() {
  return "test Commit contents with other device and other account";
}
