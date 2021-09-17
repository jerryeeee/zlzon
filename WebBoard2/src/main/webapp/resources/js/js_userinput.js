$(function(){
	// 사용자의 자료 입력여부를 검사하는 함수
	$('#confirm').click(function(){
    	if( $.trim($("#userId").val()) == '' ){
            alert("아이디를 입력해 주세요.");
            $("#userId").focus();
            return;
        }
    	
    	if($.trim($('#userPass').val())==''){
    		alert("비번입력해주세요.");
    		$('#userPass').focus();
    		return;
    	}
    	
    	if($.trim($('#userPass').val()) != $.trim($('#userPass2').val())){
    		alert("비밀번호가 일치하지 않습니다..");
    		$('#userPass2').focus();
    		return;
    	}
    	
    	
    	if($.trim($('#userName').val())==''){
    		alert("이름입력해주세요.");
    		$('#userName').foucs();
    		return;
    	}
       
        // 자료를 전송합니다.
        document.userinput.submit();
	});
	
	//아이디 중복체크
	$('#userId').keyup(function(){
        $.ajax({
        	type : 'post',
        	url : 'idCheck.do',
        	data : {userId : $('#userId').val()},
        	async : true, // 비동기통신 ( submit이 안되게끔 방해)
        	contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
        	success : function(resultData) {
//				alert("resultData"+resultData);
        		$('#idCheckResult').html(resultData);
			}
        })
       
	})
})
	
	
	
	
	
	
	
	
	