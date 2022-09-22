package practice.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCompare {
	public static void main(String[] args) throws ParseException {
		System.out.println("test");
		v1();
	}

	public static void v1(){
		String standardDate = (String) "20220901";
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -90);
		standardDate = dateformat.format(cal.getTime());
		System.out.println(standardDate);
	}

	public static void v2() throws ParseException{

		//오늘날짜 yyyy-MM-dd로 생성
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		//yyyy-MM-dd 포맷 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//비교할 date와 today를데이터 포맷으로 변경
		Date date = new Date(dateFormat.parse("2022-09-02").getTime());
		Date today = new Date(dateFormat.parse(todayfm).getTime());
		//compareTo메서드를 통한 날짜비교
		int compare = date.compareTo(today);
		//조건문
		if(compare > 0) {
			System.out.println("date가 today보다 큽니다.(date > today)");
		}else if(compare < 0) {
			System.out.println("today가 date보다 큽니다.(date < today)");
		}else {
			System.out.println("today와 date가 같습니다.(date = today)");
		}
	}

	public static void test3() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String ciMtchDt = "20220920";
		Date tempReqDate = new Date(dateFormat.parse("20220920").getTime());
		Date tempCompareDate = new Date(dateFormat.parse(ciMtchDt).getTime());
		int compare = tempReqDate.compareTo(tempCompareDate);
		if(compare > -1){
			System.out.println("등록");
		}
	}
}
