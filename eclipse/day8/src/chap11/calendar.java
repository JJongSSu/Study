package chap11;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class calendar {

	public static void main(String[] args) {
		
		Calendar rightNow = Calendar.getInstance();
		System.out.println(rightNow.get(Calendar.YEAR));
		
		Week today = null;
		
		// Week의 배열 확인
		for(Week w : Week.values())
			System.out.println(w);
		
		int dow = rightNow.get(Calendar.DAY_OF_WEEK);	// 일요일 1 ~ 토요일 7
		System.out.println(dow);
		switch(dow) {
		case 1: today = Week.SUNDAY; break;
		case 2: today = Week.MONDAY; break;
		case 3: today = Week.TUESDAY; break;
		case 4: today = Week.WEDNESDAY; break;
		case 5: today = Week.THURSDAY; break;
		case 6: today = Week.FRIDAY; break;
		case 7: today = Week.SATURDAY; break;
		}
		System.out.println("오늘은 " + today);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 hh:mm:ss");
		System.out.println(sdf.format(date));
	
	}

}
