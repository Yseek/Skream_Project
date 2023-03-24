//상단 메뉴바 드롭다운
function drop_down_monitor_menu() {
  let click = document.querySelector(".row");
  if (click.style.display === "none") {
    click.style.display = "block";

  } else {
    click.style.display = "none";

  }
}

function drop_down_mobile_menu_right() {
  let click = document.querySelector(".sidebar_right");
  const overlay = document.querySelector('.overlay');
  click.style.marginLeft = "80%";
  if (click.style.display == "none") {
    click.style.display = "block";
    overlay.style.display = "block";

  } else {
    click.style.display = "none";
    overlay.style.display = "none";

  }
}
//사이드바 외부영역 클릭 시 사이드 바 닫음
document.querySelector('.overlay').addEventListener('click', function () {
  document.querySelector('.overlay').style.display = "none";
  document.querySelector(".sidebar").style.display = "none";
  document.querySelector(".sidebar_right").style.display = "none";
});

//메뉴바의 소메뉴 숨기기+보이기
document.querySelector('.features').addEventListener('click', function () {
  let click = document.querySelector(".sub1");
  if (click.style.display === "none") {
    click.style.display = "block";
  } else {
    click.style.display = "none";
  }
});
document.querySelector('.Dashboard').addEventListener('click', function () {
  let click = document.querySelector(".sub2");
  if (click.style.display === "none") {
    click.style.display = "block";
  } else {
    click.style.display = "none";
  }
});
document.querySelector('.Information').addEventListener('click', function () {
  let click = document.querySelector(".sub3");
  if (click.style.display === "none") {
    click.style.display = "block";
  } else {
    click.style.display = "none";
  }
});
document.querySelector('.Guide').addEventListener('click', function () {
  let click = document.querySelector(".sub4");
  if (click.style.display === "none") {
    click.style.display = "block";
  } else {
    click.style.display = "none";
  }
});
window.onload = function () {
  var current = 0; 
  var max = 0;    
  var maximage = 3;   
  var imagewidth = 300; 
  function init() {
    container = document.querySelector('.slide ul');
    max = container.childElementCount;
  }
  document.querySelector('.prev').addEventListener('click', function () {
    if (current <= 0) { return; }
    current -= 1;
    var tunnel = document.querySelector('.slide ul');
    var compute = window.getComputedStyle(tunnel);
    var left = parseInt(compute.marginLeft, 10);
    left += 300;
    tunnel.style.marginLeft = left + "px";
  });
  document.querySelector('.next').addEventListener('click', function () {
    if (current >= max / maximage) { return; } 
    current += 1;
    const tunnel = document.querySelector('.slide ul');
    var compute = window.getComputedStyle(tunnel);
    var right = parseInt(compute.marginLeft, 10);
    right -= 300;
    console.log(right);
    tunnel.style.marginLeft = right + "px";
  });

  init();
}

//header의 알람,채팅,내가쓴글 모달창 보이기
const alarm = document.querySelector(".alarm_list");
const chat = document.querySelector(".chat_list");
const post = document.querySelector(".post_list");
function show_alarm() {
  if (alarm.style.display == "none") {
    alarm.style.display = "block";
    chat.style.display = "none";
    post.style.display = "none";
  }
  else alarm.style.display = "none";
}
function show_chat() {
  if (chat.style.display == "none") {
    alarm.style.display = "none";
    chat.style.display = "block";
    post.style.display = "none";
  }
  else chat.style.display = "none";
}
function show_post() {
  if (post.style.display == "none") {
    alarm.style.display = "none";
    chat.style.display = "none";
    post.style.display = "block";
  }
  else post.style.display = "none";
}
