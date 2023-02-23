package Day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex1_p529 {
	
	public static void main(String[] args) {
		
		// 1. Math 클래스 : 수학 계산에 사용할 수 있는 메소드 제공 
			// 1. ceil( 값 ) : 올림 [ 소수 첫째자리 ]
			// 2. floor( 값 ) : 버림[ 소수 첫째자리 ]
			// 3. round( 값 ) : 반올림[ 소수 첫째자리 ] / String.format("%.소수자리수f" , 값 );
			// 3. max( 값1 , 값2 ) : 최대값 
			// 4. min( 값1 , 값2 ) : 최소값 
		double v1 = Math.ceil(5.3); 	System.out.println("v1 : " + v1 );	
		double v2 = Math.floor( 5.3 ); 	System.out.println("v2 : " + v2 );
		long v3 = Math.max( 3 , 7 );	System.out.println("v3 : "+ v3);
		long v4= Math.min( 3 , 7 );		System.out.println("v4 : " + v4);
		double v5 = Math.round( 5.357 );	System.out.println("v5 : " + v5);
		
		// 소수 셋째자리 에서 반올림해서 두 자리까지 표시 
		double value = 12.3456;
		double temp1 = value * 100;		// 1234.56;
		long temp2 = Math.round(temp1);	//	1235;
		double v6 = temp2/100.0;		// 12.35;
		System.out.println( "v6 : " + v6 );
		// 소수 네번째자리 에서 반올림해서 세 자리까지 표시 
		System.out.println("반올림 : " + (  (Math.round(12.3456 * 1000) ) )/1000.0 );
		// 문자열 반올림 
		System.out.println( String.format("%.2f", 3.14159 ) );
		
		
		// p.531
			// 클래스 : 서로 다른 자료형/타입 한곳[객체] 에 저장 
			// 배열/리스트 : 동일한 자료형/타입 의 데이터를 여러개 저장하기 위한 리스트/배열[객체] 에 저장  
		// int형 변수를 6개 저장할수 있는 배열 [ 고정길이 , 메소드제공x ] 
		int[] selectNumber = new int[6];	
				// vs
		// int형 변수를 6개 저장할수 있는 리스트 [ 가변길이 , 메소드제공o , 기본길이=10 ] 
		ArrayList< Integer > selectNumber2 = new ArrayList<>(); 
			// 포장 클래스 : 기본자료형-->클래스 [ *특정 API클래스중 기본자료형 사용불가 ]
		
		Random random = new Random();	// 난수 관련 메소드 제공하는 클래스 
		System.out.print(" 선택번호 : ");
		for( int i = 0 ; i<6; i++ ) {
			selectNumber[i] = random.nextInt(45)+1;	// 1~45 사이의 정수 난수 
			System.out.print( selectNumber[i] +" ");
		}
		System.out.println( );
		
		// 
		int[] winningNumber = new int[6];
		random = new Random();
		System.out.print(" 당첨번호 : ");
		for( int i = 0 ; i<6 ; i++) {
			winningNumber[i] = random.nextInt(45)+1;
			System.out.print( winningNumber[i]+ " ");
		}
		System.out.println();
		
		// 배열에 정렬 
			// 1. Arrays.sort( 배열 ) : 해당 배열내 데이터를 오른차순 정렬 
			// 2. Arrays.toString( 배열 ) : 해당 배열내 데이터를 출력 
			// 3. Arrays.equals( 배열1 , 배열2 ) : 두 배열이 모두 일치하면 true / false
		Arrays.sort( selectNumber ); 
			System.out.println( Arrays.toString(selectNumber) );
		Arrays.sort( winningNumber );
			System.out.println( Arrays.toString(winningNumber) );
		boolean result =  Arrays.equals( selectNumber , winningNumber );
		if( result ) { System.out.println("1등");}
		else { System.out.println("1등 당첨X");}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
