package Day17;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex2_p532 {
	public static void main(String[] args) {
		
		// 1. Date , SimpleDateFormat
			// 1. Date :   Date 객체명 = new Date();
		Date now = new Date();	// 현재 시스템[컴퓨터] 날짜/시간 
		System.out.println( now ); 
			// 2. SimpleDateFormat 객체명 = new SimpleDateFormat( 패턴 );
			// 객체명.format( 날짜객체 ) : 해당날짜객체 가 패턴 형식으로 변환
			/*
			  패턴 
			  		y : 연도		M : 월	d : 일
			  		H : 시		m : 분	s : 초 
			 */
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy MM dd HH:mm:ss");
		System.out.println(   sdf.format(now) );
		
		// 2. Calender 클래스 
		Calendar cal  = Calendar.getInstance();
		System.out.println( cal );
		
		System.out.println( "현재 년도 : " + cal.get( Calendar.YEAR ) );
		System.out.println( "현재 년도 : " + cal.get( 1 ) );
		System.out.println( "현재 월 : " +  ( cal.get( Calendar.MONTH  ) +1 ) ); // 1월:0 2월:1 3월:2 ~~ 12월:11
		System.out.println( "현재 일/년 : " +  cal.get( Calendar.DAY_OF_YEAR  )   ); 
		System.out.println( "현재 일/월 : " +  cal.get( Calendar.DAY_OF_MONTH  )   ); 
		System.out.println( "현재 일/주 : " +  cal.get( Calendar.DAY_OF_WEEK  )   ); 
		// 주 : 일:1	~ 토:7
		int week = cal.get( Calendar.DAY_OF_WEEK  );
		if( week == Calendar.MONDAY ) { System.out.println("월");}
		if( week == 3 ) { System.out.println("화");}
		if( week == Calendar.WEDNESDAY ) { System.out.println("수");}
		if( week == Calendar.THURSDAY ) { System.out.println("목");}
		if( week == 6 ) { System.out.println("금");}
		if( week == Calendar.SATURDAY ) { System.out.println("토");}
		if( week == 1 ) { System.out.println("일");}
		// 오전 : 0 	오후 : 1
		System.out.println( "현재 오전/오후 : " + cal.get( Calendar.AM_PM ));
		int ampm = cal.get(Calendar.AM_PM);
		if( ampm == 0 ) System.out.println(" 오전 ");
		else { System.out.println(" 오후 ");}
		
		System.out.println( " 현재 시 : "+ cal.get( Calendar.HOUR ));
		System.out.println( " 현재 분 : "+ cal.get( Calendar.MINUTE ));
		System.out.println( " 현재 초 : "+ cal.get( Calendar.SECOND ) );
		
		// 3. 각국의 표준시 코드ID 얻기 
		for( String timeId : TimeZone.getAvailableIDs() ) {
			System.out.println( timeId ); 
		}
		
		// 4. LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
			System.out.println( dateTime );
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd a HH:mm:ss");
			System.out.println( dtf.format( dateTime ));
		
		System.out.println( "1년 후 : " + dateTime.plusYears(1) );
		System.out.println( "2개월 전 : " + dateTime.minusMonths(2) );
		System.out.println( "7일후 : " + dateTime.plusDays(7) );
		
		// 5.
		LocalDateTime 시작일 = LocalDateTime.of( 2021, 1, 1 , 0 , 0 , 0);
		LocalDateTime 종료일 = LocalDateTime.of( 2021, 12,31, 0 , 0 , 0);
		System.out.println( "종료일 이 시작일 이후: " +  시작일.isBefore(종료일) );
		System.out.println( "종료일 이 시작일 이전: " +  시작일.isAfter(종료일) );
		System.out.println( "종료일 과 시작이 같은: " +  시작일.isEqual(종료일) );
		
		System.out.println( "연도 차 : " + ( 시작일.until( 종료일, ChronoUnit.YEARS )) );
		System.out.println( "월 차 : " + ( 시작일.until( 종료일, ChronoUnit.MONTHS )) );
		System.out.println( "일수 차 : " + ( 시작일.until( 종료일, ChronoUnit.DAYS )) );
		System.out.println( "시 차 : " + ( 시작일.until( 종료일, ChronoUnit.HOURS )) );
		System.out.println( "분 차 : " + ( 시작일.until( 종료일, ChronoUnit.MINUTES )) );
		System.out.println( "초 차 : " + ( 시작일.until( 종료일, ChronoUnit.SECONDS )) );
		
		
		
	}
}























