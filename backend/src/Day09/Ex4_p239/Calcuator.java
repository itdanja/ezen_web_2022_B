package Day09.Ex4_p239;

/*
 	오버라이딩 : 이미 존재하는 메소드를 재정의[리모델링]
 	vs
 	오버로딩 : 이름은 같되 매개변수의 타입,개수,순서가 다르게 여러개 선언 
 		생성자,메소드 사용
 
 */
public class Calcuator {
	// 1. 정사각형 넓이 구하는 함수 
	double areaRectangle( double width ) {
		return width * width;
	}
	// 2. 직사각형의 넓이 구하는 함수
	double areaRectangle( double width , double height ) {
		return width * height ;
	}
}
