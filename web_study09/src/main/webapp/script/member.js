function logInCheck(){

	if(document.frm.userId.value.length==0){
		alert("아이디를 써주세요");
		frm.userId.focus();
		return false;
	} 
	
	if(document.frm.pwd.value==""){
		alert("암호를 써주세요");
		frm.pwd.focus();
		return false;
	}
	
	return true;

}