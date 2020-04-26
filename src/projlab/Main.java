package projlab;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		System.out.print("$ ");
		Jatek jatek = new Jatek();
		TextInterface jatekIF = new TextInterface(jatek);
		Scanner console = new Scanner(System.in);
		while (console.hasNextLine()) {
			jatekIF.executeCommand(console.nextLine());
			System.out.print("$ ");
		}
		console.close();
	}
	
}
