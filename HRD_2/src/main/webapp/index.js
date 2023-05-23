function add(){
	let sno = document.querySelector('.sno'); if( sno.value == ""){ alert('학생번호가 입력되지 않습니다.'); sno.focus(); return false; }
	let ekor = document.querySelector('.ekor');if( ekor.value == ""){ alert('국어점수가 입력되지 않습니다.'); ekor.focus(); return false; }
	let emath = document.querySelector('.emath');if( emath.value == ""){ alert('수학점수가 입력되지 않습니다.'); emath.focus(); return false; }
	let eeng = document.querySelector('.eeng');if( eeng.value == ""){ alert('영어점수가 입력되지 않습니다.'); eeng.focus(); return false; }
	let ehist = document.querySelector('.ehist');if( ehist.value == ""){ alert('역사점수 입력되지 않습니다.'); ehist.focus(); return false; }
	document.addForm.submit(); // 폼전송
	alert('회원 등록이 되었습니다.')
}