function check(){
	if(document.frm.id.value == ""){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();	//커서를 id에 위치시킴.
		return false;
	} else if(document.frm.age.value == ""){
		alert("나이를 입력해주세요.");	
		document.frm.age.focus();
		return false;
	} else if(isNaN(document.frm.age.value)){	//isNaN : 숫자인지 아닌지 판단. 그 외 isFinite(문자인지), isInteger(정수인지) 등이 있음
		alert("숫자를 입력해주세요.");	
		document.frm.age.focus();
		return false;
	} else {
		return true;
	}
	
}