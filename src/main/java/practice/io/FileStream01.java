package practice.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileStream01 {

	public static final String filePath = "C:\\DEV\\";

	public static void main(String[] args) throws IOException {

		try {
			
			// 프로퍼티 객체 생성
			Properties properties = new Properties();
			
			// 프로젝트 경로 찾기
			String projectPath = System.getProperty("user.dir");
			// 파일 읽기
			properties.load(new FileInputStream(projectPath + "\\src\\main\\resources\\server.ini"));

			// 프로퍼티 값 읽기
			System.out.println(properties.getProperty("url"));
			System.out.println(properties.getProperty("id"));
			System.out.println(properties.getProperty("password"));

			// 프로퍼티 값 저장
			properties.setProperty("key", "value");

			// 프로퍼티 리스트 출력
			properties.list(System.out);

			// 파일 쓰기
			properties.store(new FileOutputStream(filePath + "server.ini"),null);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
