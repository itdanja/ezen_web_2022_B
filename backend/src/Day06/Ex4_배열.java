package Day06;

import java.lang.reflect.Array;

public class Ex4_배열 { // class s 
	public static void main(String[] args) { // main s 
		// 1. p.168
			// String 변수 여러개를 저장할수 있는 String 배열 선언 
			// String 4개 데이터를 하나의 배열 저장 
			// 1. 선언
		String[] season = { "Spring" , "Summer" , "Fall" , "Winter" }; 
			// 2. 호출
		System.out.println(" 배열 호출 : " + season );
		System.out.println(" 배열내 첫번째 : " + season[0] );
		System.out.println(" 배열내 두번째 : " + season[1] );
		System.out.println(" 배열내 세번째 : " + season[2] );
		System.out.println(" 배열내 네번째 : " + season[3] );
		// System.out.println(" 배열내 다섯번째 : " + season[4] ); // 오류발생 : 인덱스 없음 
			// 3. 인덱스내 데이터 변경 
		season[1] = "여름";
		System.out.println(" 배열내 두번째 : " + season[1] );
			// 4. 반복문과 배열 관계
		for( int i = 0 ; i<season.length ; i++ ) {
			System.out.println( i + " : " + season[i] );
		}
			// 1. 선언 
		int[] scores = { 83 , 90 , 87 };
		int sum = 0;
		for( int i = 0 ; i<scores.length ; i++ ) {
			sum += scores[i];
		}
		System.out.println(" 총합 : " + sum );
		System.out.println(" 평균 : " + ( sum/scores.length ) );
		
		// 2. p.173
			// 1. int형 변수 3개를 저장할수 있는 배열 선언
			// 배열 선언시 길이가 고정
		int[] arr1 = new int[3];
			// 2. 확인
		for( int i = 0 ; i<arr1.length ; i++ ) {
			System.out.println( arr1[i] );
		}
			// 3. 해당 인덱스에 데이터 넣기 
		arr1[0] = 10;	arr1[1] = 20;	arr1[2] = 30; 
			// 4. 확인
		for( int i = 0 ; i<arr1.length ; i++ ) {
			System.out.println( arr1[i] );
		}
		
		double[] arr2 = new double[3]; // 0.0 , 0.0 , 0.0
		for( double value : arr2 ) { System.out.println( value ); }
		
		arr2[0] = 0.1 ; arr2[1] = 0.2; arr2[2] = 0.3;
		for( double value : arr2 ) { System.out.println( value ); }
		
		String[] arr3 = new String[3];	// null  null  null
		for( String value : arr3 ) { System.out.println( value );}
		
		arr3[0] = "1월"; arr3[1] = "2월"; arr3[2] ="3월";
		for( String value : arr3 ) { System.out.println( value );}
		
		
		
	} // main e 
} // class e 
/*
 
 	p.165
 		- 
 			변수 : 데이터 1개 		스택영역
 			배열 : 데이터 여러개 	힙영역
 		- 
 			JS		vs			JAVA
 			다른타입				같은타입
 			가변길이				고정길이
 			
		- 선언 차이 
			JS					JAVA
			let 배열명 = [ ]		int[] 배열명 = { }
			
		- 배열과 반복문 활용 
			----JS---
			for( let 변수 in 배열명 ) { }
			for( let 변수 of 배열명 ) { }
			배열명.forEach( (v) -> { })
			배열명.map( ( v ) -> { return 반환값; }
			
			----JAVA----
			for( 자료형 변수 : 배열명 ) { }
			
		- 1. 선언
			1. 자료형타입[ ] 배열명 = { 허용범위내데이터1 , 허용범위내데이터2 ,  허용범위내데이터3  }  
 			2. 자료형타입[ ] 배열명 = new 자료형타입[길이];
 		
 				초기값 
 					- int[] scores = new int[3]
 					자료형 : 	int int int 
 					데이터 : 	0	0	0
 					인덱스 : 	0	1	2	
 					- String[] names = new String[3];
 					자료형 : String	String 	String
 					데이터 : null 	null 	null
 					인덱스 : 0 		1		2
 					
 		- 2. 호출 , 인덱스 
 			배열명		: 첫번째 값의 주소값 
 			배열명[인덱스]	: 해당 인덱스의 위치한 데이터
		- 3. 데이터 변경 
			배열명[인덱스] = 새로운 데이터 
		- 4. 배열의 길이
			배열명.length		:	4
			인덱스			: 0~3
 
  
 */

