package 과제.과제4;

import 과제.과제4.view.Front;

/*
 	MVC : 디자인패턴 [ 관점별 파일 구분 ] 
 		M : model 		데이터				DB
 		V : view 		화면				HTML , CSS , JS
 		C : controller	제어[로직/기능처리]	JAVA
 */

public class Start {
	public static void main(String[] args) {
		Front front = new Front();
		front.index();
	}
}







