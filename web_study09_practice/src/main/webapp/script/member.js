function loginCheck(){
	
	if(document.frm.userId.value.length==0){
		alert("아이디를 입력해주세요");
		frm.userId.focus();
		return false;
	}
	
	if(document.frm.pwd.value==""){
		alert("암호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	
	return true;
	
}

function idCheck(){
	
	if(document.frm.userId.value==""){
		alert("아이디를 입력해주세요");
		document.frm.userId.focus();
		return;
	}
	
	let url = "idCheck.do?userId=" + document.frm.userId.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, heigh=200");
					 //새창 열기											//창크기 조절 막음 - IE only 다른 브라우저 x.
}

function idOk(){
	opener.frm.userId.value = document.frm.userId.value;
	opener.frm.reId.value = document.frm.userId.value;
	//opener : 창을 열어준 부모 창(회원 가입 폼).
	self.close();
	
}

function joinCheck(){
	if(document.frm.name.value.length==0){
		alert("이름을 입력해주세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.userId.value.length==0){
		alert("아이디를 입력해주세요");
		frm.userId.focus();
		return false;
	}
	if(document.frm.userId.value.length<4){
		alert("아이디는 4글자 이상이어야 합니다.");
		frm.userId.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("비밀번호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!=document.frm.pwd_check.value){
		alert("비밀번호가 일치하지 않습니다");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.reId.value.length==0){
		alert("중복 체크를 하지 않았습니다");
		frm.userId.focus();
		return false;
	}
	return true;
}