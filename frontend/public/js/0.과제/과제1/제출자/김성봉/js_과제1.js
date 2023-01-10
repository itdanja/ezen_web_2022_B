
// 과제 1
let studentArray = [ '20230110', '20230109', '20230108' ]
console.log(studentArray)

function id_check() {
	let input_student_id = document.querySelector('#student_id')
	let id_value = input_student_id.value;
		console.log('체크 : ' + id_value )
	let id_index = studentArray.indexOf( id_value )
		console.log( '인덱스 체크 : ' + id_index )
		
	if ( id_value.length == 0 ) {
		document.querySelector('.login_result').innerHTML = '학번을 입력해주세요'
	}
	else if ( id_value.length != 8 ) {
		document.querySelector('.login_result').innerHTML = '학번은 8자리로 입력해주세요'
	 }
	else if ( id_index == -1 ) {
		document.querySelector('.login_result').innerHTML = '로그인 실패'
	}
	else {
		document.querySelector('.login_result').innerHTML = '로그인 성공'
	}
	document.getElementById('student_id').value = ''
}


// 과제 2
function id_reg() {
	let std_id_reg = document.querySelector('#student_id_reg')
	let reg_value = std_id_reg.value
	let reg_index = studentArray.indexOf ( reg_value ) 
	
	if ( reg_value == 0 ) {
		document.querySelector('.reg_box').innerHTML = '학번을 입력해주세요'
	}
	else if ( reg_value.length != 8) {
		document.querySelector('.reg_box').innerHTML = '학번은 8자리로 입력해주세요'
	}
	else if ( reg_index != -1 ) {
		document.querySelector('.reg_box').innerHTML = '이미 등록된 학번입니다.' 
	}
	else if (reg_index == -1 ) {
		studentArray.push(reg_value); 
		document.querySelector('.reg_box').innerHTML = '[ ' + reg_value + ' ] 학번을 등록하였습니다.'
	}
	
	document.getElementById('student_id_reg').value = null;
	console.log(studentArray)	
}

function id_del() {
	let std_id_del = document.querySelector('#student_id_reg')
	let del_value = std_id_del.value
	let del_index = studentArray.indexOf ( del_value )
	
	if ( del_value == 0 ) {
		document.querySelector('.reg_box').innerHTML = '학번을 입력해주세요'
	}
	else if ( del_value.length != 8) {
		document.querySelector('.reg_box').innerHTML = '학번은 8자리로 입력해주세요'
	}
	else if ( del_index == -1 ) {
		document.querySelector('.reg_box').innerHTML = '존재하지 않는 학번입니다.'
	}
	else { 
		studentArray.splice( del_index, 1 );
		document.querySelector('.reg_box').innerHTML = '[ ' + del_value + ' ] 학번을 삭제하였습니다.' 
	}
	document.getElementById('student_id_reg').value = null;
	console.log(studentArray)
}











