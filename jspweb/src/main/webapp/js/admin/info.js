
// --------------------- chart.js 차트 ----------------//

	// new Chart( 'dom객체' , { 차트옵션} );
	// { type : '차트이름' , data : { 차트에 표시할 데이터 } , options : { 차트옵션 } }
		// labels : 가로축
  const ctx = document.getElementById('myChart');
  
  new Chart(ctx, {
    type: 'bar', // bar : 막대차트 , line : 선차트 등등
    data: {
      labels: ['2023-03-27', '2023-03-28', '2023-03-29', '2023-03-30', '2023-03-31' ], // 가로축 
      datasets: [
		  {
        	label: '포인트 충전 내역',	// 데이터 항목명 
        	data: [ 100000 , 1532874 , 123874 , 955324 ,  743125], // 해당 항목의 데이터
       	 	borderWidth: 1 
     	 },
     	 {
        	label: '포인트 충전 취소 내역',	// 데이터 항목명 
        	data: [ 711153 , 756663 , 75772 , 41233.4 ,  453532], // 해당 항목의 데이터
       	 	borderWidth: 1
     	 } 
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });



// js -> admin -> info.js

console.log( 'js열림')

getMemberList();
function getMemberList(){
	$.ajax({
		url: "/jspweb/member",
		method : "get",
		//data : "" ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일주소 </th>
							<th width="10%"> 비고 </th>
						</tr>`
			r.forEach( (o,i) =>{
				// 2. 테이블 내용물 추가 구성 
												// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> <img src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td> </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.mListTable').innerHTML = html;
			
		}
	})
}







