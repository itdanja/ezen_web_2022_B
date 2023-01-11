/*
  과제3
  주제 : 방문록 게시판 구현
 
    조건1) 방문록 내용을 여러개 담는 배열 선언 : let  contentArray=[]
    조건2) 내용작성 <input> 입력받기
    조건3) 등록버튼 <button> 클릭시 입력된 데이터가 배열에 저장하는 addContent() 함수 실행
    조건4) 현재 배열에 저장된 모든 방문록을 <table>에 출력 
 
 	<tr>
 		<th> 번호 </th> <th> 방문록 </th>
 	</th>
 
 
 */

 let contentArray = [ ]

 let 테이블행 = '<tr> <th> 번호 </th> <th> 방문록 </th> </tr>'
  
 function addContent()
 {   
 
	 let content = document.querySelector('.content').value ;
	 
	 contentArray.push(content);
	 
	 console.log(contentArray)
	 
	 
	 for(let 번호=contentArray.indexOf(content)+1 ; 번호 <= contentArray.length ; 번호++)
  	{ 테이블행 += '<tr> <th>'+ 번호 +' </th> <th>'+ content +' </th> </tr>'}
 
 	document.querySelector('.list').innerHTML = 테이블행;
	
  }
 