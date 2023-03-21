
/* AJAX 이용한 데이터포털의 데이터 가져오기 */
/*
$.ajax({
	url : "신청한공공데이터 Request URL" ,
	method : "get" , 
	success : (r)=>{ console.log(r); } 
})
*/

// 공공데이터 : 시도별 미세먼지 실시간 현황
getapi2();
function getapi2(){
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D&returnType=json&numOfRows=200&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : (r)=>{
			console.log( r );
			console.log( r.response.body.items );
		}
	})
}

// 공공데이터 : 전기차충전소 현황 
getapi1();
function getapi1() {
	$.ajax({
		url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D" ,
		method : "get" , 
		success : (r)=>{ 
			console.log(r);
			document.querySelector('.totalcount').innerHTML = `전기차충전소 개수 : ${r.totalCount}`;
			let html = `<tr>
							<th> 시군명 </th><th> 소재지도로명주소 </th>
							<th> 소재지우편번호 </th><th> 소재지지번주소 </th>
							<th> 운영기관명 </th><th> 충전기타입명 </th>
							<th> 충전소명 </th><th> 경도 </th>
							<th> 위도 </th>
						</tr>`
			r.data.forEach( (o) => { 
				/* 객체내 필드 호출하는 방법 : 1. 객체명.필드명	  2. 객체명['필드명'] */
				html += `<tr>
							<td> ${o.시군명 } </td><td> ${o.소재지도로명주소 } </td>
							<td> ${o.소재지우편번호 } </td><td> ${o.소재지지번주소 } </td>
							<td> ${o.운영기관명 } </td><td> ${o.충전기타입명 } </td>
							<td> ${o.충전소명 } </td><td> ${o['경도(WGS84)'] } </td>
							<td> ${o['위도(WGS84)'] } </td>
						</tr>`
			});
			document.querySelector('.table').innerHTML = html;
			
		} 
	})
}


