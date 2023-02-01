package Day01;

public class Ex4_자료형변환 { // class s
	public static void main(String[] args) { // main e 
		
		// 1.[ p.54 ] 자동 타입 변환
		byte b1 = 10;		int i1 = b1;	// byte --> int 가능 
		char c1 = '가';		i1 = c1;		// char --> int 가능 
		int i2 = 50;		long l1 = i2;	// int --> long 가능 
		long l2 = 100;		float f1 = l2;	// long --> float 가능 
		float f2 = 100.5f;	double d1 = f2;	// float --> double 가능 
		
		// 2. [ p.58 ] 강제 타입 변환 
		int i3 = 10;		byte b2 = (byte)i3;		// int --> byte 불가능 [ 강제는가능 ]
		long l3 = 300;		int i4 = (int)l3;		// long --> int 불가능 [ 강제는가능 ]
		int i5 = 65;		char c2 = (char)i4;		// int --> char 불가능 [ 강제는가능 ]
		double d2 = 3.14;	int i6 = (int)d2;		// double --> int 불가능 [ 강제는 가능 ]
		
		// 3. 연산시 타입 자동 변환 [p.58 ~ p.64]
		
		// 4. 문자열 타입 변환 [ p.65 ]
		String str1 = "10";					// 10 : int vs "10" : String 다르다
		byte 바이트1 = Byte.parseByte(str1);		// String --> byte
		short 쇼트1 = Short.parseShort(str1);		// String --> short
		int 인트1 = Integer.parseInt(str1);		// String --> int 
		long 롱1 = Long.parseLong(str1);			// String --> long
		float 플롯1 = Float.parseFloat(str1);		// String --> float 
		double 더블1 = Double.parseDouble(str1);	// String --> double
		
			// "10" : 문자열타입의 숫자10 -->  10 : 정수형타입의 숫자10
			// "ABC" : 문자열타입의 문자ABC ---> X 불가능 
		String str2 ="안녕";	//
		int 인트2 = Integer.parseInt(str2);		System.out.println( 인트2 ); // 불가능 
		
		// int 인트3 = (Integer)str1; // 불가능 
		
		
	} // main end 
} // class end 

/*
 
 	자료형/타입 변환 
 		- 허용 범위 순서 
 		 byte[1] > short, char[2] > int[4] > long[8] > float[4] > double[8]
 		 
 		1. 자동 타입 변환 [ 캐스팅 ]
 			- 작은 타입 --> 큰 타입 자동 
 			
 			큰 허용범위 타입 = 작은 허용범위 타입 
 			
 		2. 강제 타입 변환 [ 캐스팅 ]
 			- 손실이 있더라도 강제로 변환
 			(새로운타입)변환할데이터
 			
 			작은 허용범위 타입 = 큰 허용범위 타입 [ X ]
 			작은 허용범위 타입 = (작은 허용범위 타입)큰 허용범위 타입 [ O ]
		
		3. 연산시 자동 타입 변환 
			- 피연산자중 큰 타입를 결과 반환
			1. 정수 
				1. * int 보다 작은 byte,short 연산시 무조건 int 결과
					byte + byte -> int 
					short + int -> int 
 				2. long 연산시 
 					int + long -> long 
			2. 실수
			 	float + float 	-> float
				float + double 	-> double 
		
		4. !문자열 타입변환
  
 */












