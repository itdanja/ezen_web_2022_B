package Day06;

public class Ex1_참조타입 { // class s
	public static void main(String[] args) { // main s
		
		// 1. p.148
		int[] arr1;	// int형 배열 선언 [ 스택영역에 변수 만들기 ] 
		int[] arr2; // int형 배열 선언 [ 스택영역에 변수 만들기 ] 
		int[] arr3;	// int형 배열 선언 [ 스택영역에 변수 만들기 ] 
		
		arr1 = new int[] { 1,2,3 }; // [ 힙 영역에 '1','2','3' 메모리 3개 ]
		arr2 = new int[] { 1,2,3 };	// [ 배열은 첫번째 메모리('1')주소를 스택영역에 대입 ]
		arr3 = arr2;				// arr2가 가지고 있던 메모리주소를 arr3 대입
		
		System.out.println( arr1 == arr2 );	//  ==  스택영역의 주소 비교 
		System.out.println( arr2 == arr3 );	//
		
		// 2. p.151
		int[] inArray = null;	// int형 배열 선언 [ 스택영역 변수 만들기 ]
		inArray[0] = 10;	// 오류 발생 : 힙영역이 없기때문에 저장 불가능 
		
		String str = null;
		System.out.println( str.length() ); // 오류 발생 : 힙영역이 없기때문에 길이 불가능
		
		
	} // main e 
} // class e 
/*
 		스택영역					힙영역 
 		arr1	<---주소대입--- 	new int[] { 1,2,3 }
 		arr2	<---주소대입---	new int[] { 1,2,3 }
 		arr3
 
 	* new : 힙영역에 메모리를 생성하는 연산자
 	
 	*	스택영역								힙영역 [ 별도의 제거 없음 ]
 		유재석 : 안산시 상록구 65번지				안산OO아파트 : 안산시 상록구 65번지
  				이사							수원OO아파트 : 수원시 구 100번지
  		유재석 : 수원시 구 100번지					
  				해외 이사
  		유재석 : null
 */



















