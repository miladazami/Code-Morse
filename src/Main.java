import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Crypte cr = new Crypte();
		System.out.println("HELLO, " + cr.toMorse());

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to encrypt a number or a text? N/T");
		String str = sc.nextLine();
		
		if(str.equals("N") || str.equals("n") ){
			Scanner number = new Scanner(System.in);
			System.out.println("Enter your number, please!");
			String strNbr = number.nextLine();
			Crypte crp = new Crypte(strNbr);
			String res = crp.toMorseInt();
			if(res != "")
				System.out.println("Here is your number in Morse code: " + res);
			number.close();
			
		}else {
			if(str.equals("T") || str.equals("t") ){
				Scanner msg = new Scanner(System.in);
				System.out.println("Enter your text in uppercase, please!");
				String strNbr = msg.nextLine();
				Crypte crp = new Crypte(strNbr);
				String res = crp.toMorse();
				if(res != "")
					System.out.println("Here is your text in Morse code: " + res);
				msg.close();
			}
			else {
				System.out.println("I did not recognize your response, goodbye!");
			}
		}
		sc.close();
	}  

}
