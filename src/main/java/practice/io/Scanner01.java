package practice.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scanner01 {

	public static void main(String[] args) {

		try {

			// 프로젝트 현재 경로 찾기
			String projectPath = System.getProperty("user.dir");

			// 파일 객체 생성
			File file = new File(projectPath + "\\src\\main\\resources\\check.txt");

			// 스캐너 생성
			Scanner scanner = new Scanner(file);

			// 스캐너의 다음 줄이 없을 때 까지 출력
			while (scanner.hasNextLine()) {
				// 스캐너 한줄 출력
				System.out.println(scanner.nextLine());
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

}
