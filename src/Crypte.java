public class Crypte {
	private String message;
	private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	private final String [] morse = {"•-","-•••","-•-•","-••", "•", "••-•","--•", "••••", "••",
			"•---","-•-","•-••","--", "-•","---", "•--•","--•-","•-•","•••","-","••-","•••-",
			"•--","-••-","-•--","--••", " "};
	private final String chiffres = "0123456789";
	private final String [] chiffresMorse= {"-----","•----", "••---","•••--","••••-","•••••",
											"-••••","--•••","---••","----•"}; // Source wikipedia
			/*  
			 *  Source wikipedia 
			 * 
			 * A = "•-"
			 * B = "-•••"
			 * C = "-•-•"
			 * D = "-••"
			 * E = "•"
			 * F = "••-•"
			 * G = "--•"
			 * H = "••••"
			 * I = "••"
			 * J = "•---"
			 * K = "-•-"
			 * L = "•-••"
			 * M = "--"
			 * N = "-•"
			 * O = "---"
			 * P = "•--•"
			 * Q = "--•-"
			 * R = "•-•"
			 * S = "•••"
			 * T = "-"
			 * U = "••-"
			 * V = "•••-"
			 * W = "•--"
			 * X = "-••-"
			 * Y = "-•--"
			 * Z = "--••"
			 * ' ' --> space character
			 */
	
	
	/* Constructor */
	
	public Crypte(String message) {
		this.message = message;
	}
	
	public Crypte() {
		message = "BONJOUR";
	}
	
	
	/* Accessors */
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String str) {
		message = str;
	}
	
	/* Exception handling */
	
	@SuppressWarnings("serial")
	private class MyException extends Exception {
		public MyException(String str) {
			super(str);
		}
			
	}
	
	/* Throws an exception if the character is not uppercase */
	private void validate(char c) throws MyException {
		if(!Character.isUpperCase(c)) {
			throw new MyException("Lowercase letter!");
		}
	}
	
	/* Throws an exception if the character is not a digit */
	private void validateInt(char c) throws MyException {
		if(!Character.isDigit(c))
			throw new MyException("Not a number!");
	}
	
	
	/* Retrieves the position of the character */
	private int alphaToInt(char c) {
		try {
			validate(c);
			
		}catch ( MyException e) {
			System.out.println("Lowercase letter not allowed!");
		}
		for(int i =0; i<alphabet.length(); i++){
			if(alphabet.charAt(i) == c)
                return i;
		}
		return -1;
	}
	
	
	/* Converts a letter to Morse code */
	private String alphaToMorse(char c) {
		try {
			validate(c);
			
		}catch ( MyException e) {
			System.out.println("Lowercase letter not allowed!");
		}
		String res = "";
		int len = alphabet.length();
		for(int i = 0; i< len; i++) {
			if(this.alphabet.charAt(i) == c) {
				int pos = alphaToInt(c);
				res = this.morse[pos];
			}
				
		}
		return res;
	}
		
	
	/* Converts text to Morse code */
	public String toMorse() {
		int len = message.length();
		String res = "";
		for(int i = 0; i< len; i++) {
			int pos = alphaToInt(message.charAt(i));
			if (pos == -1)
				return "";
			res += alphaToMorse(this.message.charAt(i));
		}
		return res;
	}
	
	
	/* Converts to Morse code with '|' as separator */
	public String toMorseWithSep() {
		int len = message.length();
		String res = "";
		for(int i = 0; i< len; i++) {
			int pos = alphaToInt(message.charAt(i));
			if (pos == -1)
				return "";
			if(message.charAt(i) != ' ')
				res += alphaToMorse(message.charAt(i)) + "|";
		}
		return res;
	}
	
	
	/* Converts a number to Morse code */
	
	/* Retrieves the position of the character */
	private int intPos(char c) {
		try {
			validateInt(c);
		}catch ( MyException e) {
			System.out.println("Not a number!");
		}
		
		for(int i = 0; i< chiffres.length(); i++) {
			if( c == chiffres.charAt(i))
				return i;
		}
		return -1;
	}
	
	private String intToMorse(char c) {
		try {
			validateInt(c);
		}catch ( MyException e) {
			System.out.println("Not a number!");
		}
		String res = "";
		for(int i = 0; i< chiffres.length(); i++) {
			if(chiffres.charAt(i) == c) {
				int pos = intPos(chiffres.charAt(i));
				if(pos == -1)
					return "";
				res += chiffresMorse[i];
			}
				
		}
		return res;
	}
	
	public String toMorseInt() {
		int len = message.length();
		String res = "";
		for(int i = 0; i< len; i++) {
			int pos = intPos(message.charAt(i));
			if(pos == -1)
				return "";
			res += intToMorse(message.charAt(i));
		}
		
		return res;
	}
	
}
