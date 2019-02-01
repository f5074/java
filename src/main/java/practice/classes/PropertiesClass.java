package practice.classes;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesClass {
	public static String url;
	public static String id;
	public static String password;
	
	public PropertiesClass() {
		
		// 1. Github에 올릴 경우 자신의 계정정보가 노출되지 않도록 항상 주의
		// 2. 아이디와 비밀번호 파일을 따로 만들어서 관리하기 위해 사용
		try {

			// 프로퍼티 객체 생성
			Properties properties = new Properties();

			// 파일 읽기
			properties.load(new FileInputStream("C:\\DEV\\server.ini"));

			// 프로퍼티 값 읽기
			url = properties.getProperty("url");
			id = properties.getProperty("id");
			password = properties.getProperty("password");

		} catch (Exception exception) {

			System.err.println(exception);
			// 파일이 없을 경우나 예외 발생 시 url, id, password 기본 값
			url = "jdbc:mysql://127.0.0.1:3306/university?characterEncoding=UTF-8&serverTimezone=UTC";
			id = "root";
			password = "1234";
		}
	}

}
