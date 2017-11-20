// 3번
package chapter8;

class InvaliWithdraw extends RuntimeException{ 
	   private static final long serialversionUID = 1L; 
	   public InvaliWithdraw(String msg) { 
	      super(msg); 
	   }
	}
	class BankAccount { 
	   int balance = 0; 
	   int lowAmount; 
	   public BankAccount(int money) { 
	      lowAmount = money; 
	   }
	   public void deposit(int money) { 		// 입금 메소드
	      balance += money; 
	      System.out.printf("정상 입금처리 : 입금금액 = %d, 잔금 = %d\n", money, balance);
	   }
	   public void withdraw(int money) throws InvaliWithdraw {		// 출금 메소드 ( throws를 사용하여 예외를 상위 메소드로 전달)
	      if( money < 0 ) { 
	         throw new InvaliWithdraw("요청 금액이 음수입니다."); 
	      } 
	      if( (balance - money) < lowAmount ) { 		
	         throw new InvaliWithdraw("초과출금 요구 예외"); 			// 잔금이 0 인데 200000을 출금하려고 하여 예외 처리
	      } 	
	      balance -= money; 
	      System.out.printf("정상 출금처리 : 출금금액 = %d, 잔금 = %6d\n", money, balance);
	   }
	} 

	public class Ex03 {
	   public static void main(String[] args) { 
		   BankAccount ba = new BankAccount(-100000); 
	      try { 
	         ba.deposit(100000); 
	         ba.withdraw(100000);
	         ba.withdraw(200000);		
	         }  catch(InvaliWithdraw e) { 
	         e.printStackTrace();
	      }
	   }
	}

