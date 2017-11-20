// 6번

package chapter8;

class PrimeNumber03 extends Thread implements Runnable{
	public int a;
	
	public PrimeNumber03(int a, String name) {		// 생성자 구현 (스레드의 이름을 정해주는 setName 사용)
		this.a = a;
		setName(name);
	}
	
	public void run() {		// 소수를 만드는 메소드
		int count = 0;
		int check = 0;
		System.out.println(getName() + ":");		// getName을 이용해 스레드 이름 가져오기
		for(int i= 2; i <= a; i++) {
			for(int j = 1; j <=i;j++) {
				if (i % j == 0)			
					check++;				// i와 j를 나눴을 때 값이 0 이면 check를 1 증가
			}
			if(check==2){			// check가 2라는 것은 1과 자기자신만이 0으로 나누어 졌다는 것이므로 소수 
					System.out.print(i+ " ");		// 소수를 나타냄
					count++;
			}
			check=0;		// check를 다시 0 으로 초기화 시켜줌
		}
		System.out.println();
	}
	
}
public class Ex06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new PrimeNumber03(20,"소수 만드는 스레드")).start();
	
	}
}