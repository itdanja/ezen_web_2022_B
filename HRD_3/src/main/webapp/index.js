/*
	form 함수 
	1. form객체명.input명.value		: 해당 input의 value 데이터 가져오기
	2. form객체명.input명.focus();		: 커서를 해당 input으로 이동하기 
	3. form객체명.submit();			: 폼전송 
	4. form객체명.reset();			: 폼 입력된 값 모두 지우기 [초기화]
*/
function vote(){ console.log("vote()")	
	// 1. 폼 가져와서 변수[객체] 담기
	let f = document.voteForm;
	// 3.유효성검사
	if( f.v_jumin.value == ""){alert('주민번호가 입력되지 않았습니다.');f.v_jumin.focus(); return false;}
	if( f.v_name.value == ""){alert('성명이 입력되지 않았습니다.');f.v_name.focus(); return false;}
	if( f.m_no.value == ""){alert('투표번호가 선택되지 않았습니다.');f.m_no.focus(); return false;}
	if( f.v_time.value == ""){alert('투표시간이 입력되지 않았습니다.');f.v_time.focus(); return false;}
	if( f.v_area.value == ""){alert('투표장소가 입력되지 않았습니다.');f.v_area.focus(); return false;}
	if( f.v_confirm.value == ""){alert('유권자 확인이 선택되지 않았습니다.');f.v_confirm.focus(); return false;}
	// 3. 폼전송
	f.submit();
	alert('투표하기 정보가 정상적으로 등록 되었습니다.');
}
function voteReset(){ console.log("voteReset()")	
	alert('정보를 지우고 처음부터 다시 입력합니다.');
	let f = document.voteForm;
	f.reset();
	f.v_jumin.focus();
}












