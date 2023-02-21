package Day15.Ex7_p524;

import java.util.ArrayList;

public class 포장클래스 {

	public static void main(String[] args) {
		
		// 1. 특정 API[컬렉션]는 객체만 지원
		//ArrayList< int > list = new ArrayList<>();		[ x ]
		ArrayList< Integer > list = new ArrayList<>();
		
		// 2. 다양한 메소드를 제공
		//int a = 10;		System.out.println( a. );		[  x ]
		Integer b = 10;	System.out.println( b.toString() );
		
		// p. 526
		// 박싱
		Integer obj = 100;	// 기본자료형 --> 객체화
		System.out.println( obj.intValue() );
		
		// 언박싱
		int value = obj;	// 객체 ----> 기본자료형 
		System.out.println( value );
		
		// 연산시 박싱 객체는 언박싱으로 변환후 연산처리
		int result = obj + 100;	System.out.println( result );
		
	}
}


/*
 	boolean		Boolean
 	char		Char
 	byte		Byte
 	short		Short
 	int 		Integer
 	long 		Long
 	float		Float
 	double		Double
 	변수---> 왜 굳이 객체화 해야 되는지 
 		1. 특정 API[컬렉션]는 객체만 지원
 		2. 자료형에 대한 메소드 제공 
 */
