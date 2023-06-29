// 회원가입
// 동의 모두선택 / 해제
const agreeChkAll = document.querySelector('input[name=check_all]');
agreeChkAll.addEventListener('change', (e) => {
let agreeChk = document.querySelectorAll('input[name=agree]');
for(let i = 0; i < agreeChk.length; i++){
    agreeChk[i].checked = e.target.checked;
}
});