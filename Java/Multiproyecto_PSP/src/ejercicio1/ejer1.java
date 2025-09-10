package ejercicio1;

import java.io.IOException;

public class ejer1 {

	public static void main(String[] args) {
	
		try {
			Process rn;
			rn = Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
