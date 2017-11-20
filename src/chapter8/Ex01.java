// 1번
package chapter8;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		int x = 0, y = 0, z = 0;
		Scanner input = new Scanner(System.in);		// 표준 입력 받기
		try {		// 예외 처리
		System.out.println("정수 두 개 입력: ");
		x = input.nextInt();
		y = input.nextInt();		
		z = x * y;		
		System.out.printf("%d * %d = %d\n", x, y, z);
		} catch(Exception e) {
			System.out.println("예외 발생: " + e);		// 입력이 잘못되었을 경우 예외 발생
		} finally {
			System.out.println("프로그램이 정상적으로 종료됩니다.");		// 무조건 실행
		}
	}

}