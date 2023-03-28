//이메일 중복 체크
function checkEmailExists(email) {
  return fetch(`/api/user/checkEmail?email=${email}`)
    .then(response => {
      if (response.ok) {
        return Promise.resolve();
      } else {
        return Promise.reject("이미 사용중인 이메일 입니다");
      }
    });
}
const emailInput = document.getElementById("email");
const emailError = document.getElementById("emailError");

emailInput.addEventListener("blur", () => {
  checkEmailExists(emailInput.value)
    .then(() => {
      emailError.textContent = "";
    })
    .catch(error => {
      emailError.textContent = error;
    });
});

//닉네임 중복 체크
function checkNameExists(name) {
  return fetch(`/api/user/checkName?name=${name}`)
    .then(response => {
      if (response.ok) {
        return Promise.resolve();
      } else {
        return Promise.reject("이미 사용중인 닉네임 입니다");
      }
    });
}
const nameInput = document.getElementById("name");
const nameError = document.getElementById("nameError");

nameInput.addEventListener("blur", () => {
  checkNameExists(nameInput.value)
    .then(() => {
      nameError.textContent = "";
    })
    .catch(error => {
      nameError.textContent = error;
    });
});
