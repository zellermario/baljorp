package projlab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
	
	public static int tabs = -1;
	public static void print(String s) { System.out.println("\t".repeat(tabs) + "--> " + s); }
	
	interface UseCase {
		public String getName();
		public void run();
	}

	static class StabilJegtablaraLepes implements UseCase {
		public String getName() { return "Eszkimó a szomszédos stabil jégtáblára lép."; }
		public void run() {
			Eszkimo e = new Eszkimo("eszkimo1");
			Stabil_Jegtabla sj1 = new Stabil_Jegtabla();
			Stabil_Jegtabla sj2 = new Stabil_Jegtabla();
			sj1.setSzomszed(1, sj2);
			sj2.setSzomszed(2, sj1);
			sj1.AddJatekos(e);
			e.lepes(1);
		}
	}

	static class InstabilJegtablaraLepes implements UseCase {
		public String getName() { return "Eszkimó a szomszédos instabil jégtáblára lép."; }
		public void run() {
			Eszkimo e = new Eszkimo("eszkimo1");
			Stabil_Jegtabla sj = new Stabil_Jegtabla();
			Instabil_Jegtabla isj = new Instabil_Jegtabla();
			sj.setSzomszed(1, isj);
			isj.setSzomszed(2, sj);
			sj.AddJatekos(e);
			e.lepes(1);
		}
	}
	
	// Add further Use-Cases here
	
	static class Kilepes implements UseCase {
		public String getName() { return "Kilépés."; }
		public void run() {
			scanner.close();
			System.exit(0);
		}
	}
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		
		List<UseCase> useCases = new ArrayList<UseCase>();
		
		useCases.add(new StabilJegtablaraLepes());
		useCases.add(new InstabilJegtablaraLepes());
		useCases.add(new Kilepes());
		
		while(true) {
			System.out.println("Válasszon use-case-t!\n");
			for (int i = 0; i < useCases.size(); i++) {
				System.out.println((i + 1) + " " + useCases.get(i).getName());
			}
			int selected = scanner.nextInt();
			System.out.println("\n" + useCases.get(selected - 1).getName() + "\n" + "-".repeat(50));
			useCases.get(selected - 1).run();
			System.out.println("-".repeat(50));
		}
		
	}
}
