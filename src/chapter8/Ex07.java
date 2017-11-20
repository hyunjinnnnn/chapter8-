// 7번
package chapter8;

import java.util.Date;
class PrintTime implements Runnable{
Date now = new Date();
   public int num;
   public String name;
   public int priority;
   
   public PrintTime(int num) {
      this.num=num;
   }
         
   public void run() {
      for(int i=1; i<=num; i++) {
         System.out.printf("순위 : %d  ", Thread.currentThread().getPriority());	// setPriority의 값 가져오기 
         System.out.print(now);			// java.util에서 제공하는 Date 클래스를 사용. 현재 시간 받아오기.
         System.out.println("  " + Thread.currentThread().getName());		// setName의 값 가져오기
      }
   }
}
public class Ex07 {
	public static void main(String[] args) {
		PrintTime p1 = new PrintTime(3);
		Thread th1 = new Thread(p1, "안녕하세요!");
		th1.setPriority(Thread.MAX_PRIORITY-1);
		th1.start();
   
		PrintTime p2 = new PrintTime(6);
		Thread th2 = new Thread(p2, "반갑습니다");
		th2.setPriority(Thread.NORM_PRIORITY-1);
		th2.start();
	}
}