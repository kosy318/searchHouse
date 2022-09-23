// window.onload(()=> {
//   let auth = window.localStorage.getItem("auth");
//   if (auth != undefined) {
//     let login = document.getElementById("login-menu");
//     let logout = document.getElementById("logout-menu");
//     login.style.display="none";
//     logout.style.display="";
//   }
// })

// document.getElementById("btn-login").addEventListener('click', ()=>{
function mvlogin() {
  // 로그인
  let login = document.getElementById("login-menu");
  let logout = document.getElementById("logout-menu");
  let id = document.getElementById("floatingID").value;
  let pw = document.getElementById("floatingPassword").value;
  let alert = document.getElementById("alert-div");
  let users = JSON.parse(window.localStorage.getItem("users"));
  let idFlag = false;
  let pwFlag = false;
  // for (let user in users) {
  //   console.log(user);
  if (users != null) {
    for (let index = 0; index < users.length; index++) {
      const user = users[index];
      if (id == user.id) {
        idFlag = true;
      }
      if (pw == user.password) {
        pwFlag = true;
      }
    }
  }
  if (!idFlag) {
    alert.style.display = "";
    alert.innerText = "존재하지 않는 유저입니다.";
    return;
  } else if (!pwFlag) {
    alert.style.display = "";
    alert.innerText = "비밀번호가 유효하지 않습니다.";
    return;
  }

  login.style.display = "none";
  logout.style.display = "";
  let info = {
    id: id,
    password: pw,
  };
  window.localStorage.setItem("auth", JSON.stringify(info));
  window.location.href = "./index.html";
}

// logout
function logout() {
  let login = document.getElementById("login-menu");
  let logout = document.getElementById("logout-menu");
  window.localStorage.removeItem("auth");

  login.style.display = "";
  logout.style.display = "none";
  window.alert("로그아웃했습니다.");
  window.location.href = "index.html";
}
// go to Mypage Site
function mvMyPage() {
  let auth = window.localStorage.getItem("auth");
  if (auth != undefined) {
    window.location.href = "mypage.html";
  } else {
    window.location.href = "login.html";
  }
}

// go to sign up page
function mvSignUp() {
  window.location.href = "./signup.html";
}
function goUserInfo() {
  window.location.href = "./userInfo.html";
}
function signup() {
  let alert = document.getElementById("alert-div");

  let users = window.localStorage.getItem("users");
  users = JSON.parse(users);

  if (users == undefined) {
    users = [];
  } else {
  }
  // 회원가입
  let id = document.getElementById("floatingID");
  let pw = document.getElementById("floatingPassword");
  let username = document.getElementById("floatingUsername").value;
  let address = document.getElementById("floatingAddress").value;
  let phone = document.getElementById("floatingPhone").value;
  if (id.value.length < 6 || id.value.length > 12) {
    alert.style.display = "";
    alert.innerText = "ID를 6글자 이상 12글자이상으로 해주세요.";
    id.focus();
    return;
  } else if (pw.value.length < 6) {
    alert.style.display = "";
    alert.innerText = "Password를 6글자 이상으로 해주세요.";
    pw.focus();
    return;
  }

  id = id.value;
  let user = {
    id: id,
    password: pw.value,
    username: username,
    address: address,
    phone: phone,
  };
  users.push(user);
  window.localStorage.setItem("users", JSON.stringify(users));
  window.alert("회원가입을 축하합니다.");
  window.location.href = "./index.html";
}

// modify
function modify() {
  window.alert("회원 정보 수정했습니다.");
}
function search() {
  let searchInfo = document.getElementById("searchInfo").value;
  let users = JSON.parse(window.localStorage.getItem("users"));
  let info = [];
  for (let index = 0; index < users.length; index++) {
    const user = users[index];
    if (user.username == searchInfo || user.id == searchInfo) {
      info.push(user);
    }
  }
  makeUserList(info);
}

function makeUserList(data) {
  document.querySelector("#userTable").setAttribute("style", "display: ;");
  let tbody = document.querySelector("#userList");
  userTableInit();
  data.forEach((user) => {
    let tr = document.createElement("tr");
    let id = user.id;
    var td = document.createElement("td");
    td.appendChild(document.createTextNode(id));
    tr.appendChild(td);
    let username = user.username;
    td = document.createElement("td");
    td.appendChild(document.createTextNode(username));
    tr.appendChild(td);
    let address = user.address;
    td = document.createElement("td");
    td.appendChild(document.createTextNode(address));
    tr.appendChild(td);
    let phone = user.phone;
    td = document.createElement("td");
    td.appendChild(document.createTextNode(phone));
    tr.appendChild(td);
    tbody.appendChild(tr);
  });
}
function userTableInit() {
  let tbody = document.querySelector("#userList");
  let len = tbody.rows.length;
  for (let i = len - 1; i >= 0; i--) {
    tbody.deleteRow(i);
  }
}
