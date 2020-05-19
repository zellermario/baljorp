package projlab;

import java.util.Scanner;

public class Main {
	static TextInterface jatekIF;
	public static void main(String args[]) {
		Jatek jatek = new Jatek();
		
		jatekIF = new TextInterface(jatek);
	}
	
}
