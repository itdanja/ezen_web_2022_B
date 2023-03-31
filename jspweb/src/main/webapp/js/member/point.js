let pay = 0; // 결제 금액 

function setpay( p ){
	pay = p ;
	alert('결제금액 선택' + p );
}

/* 포트원 가맹점[관리자회원] 식별번호 */
var IMP = window.IMP;   // 생략 가능
IMP.init("imp35631338"); // 예: imp00000000 

function requestPay() {
	if( pay == 0 ){ 
		alert('충전할 금액을 선택해주세요.');
		return;
	}
    IMP.request_pay({
      pg: "kakaopay", // 각 pg별 이름존재
      pay_method: "card",	// pg별 결제방식
      merchant_uid: "ORD20180131-0000011",   // 주문번호 // 결제DB에서 사용할 PK
      name: "이젠 포인트 결제",	// 상품명
      amount: pay,                         // 숫자 타입 // 결제금액
      buyer_email: "gildong@gmail.com",		// 관리자 정보
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) { // 결제성공
        console.log(rsp )
      } else { // 결제취소/실패 
        // 결제 성공 했다는 가정 
       	let info = {
			mpcomment : '포인트 충전' , 
			mpamount : pay ,
			mno : memberInfo.mno
		}
        $.ajax({
			url : "/jspweb/point" ,
			data : info , 
			method:"post",
			success:(r)=>{
				console.log(r);
				if(r=="true"){ alert('포인트충전완료'); } 
			}
		})
      }
    });
}
  
  
  
  
  
  
  
  
  
  
  