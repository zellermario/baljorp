package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static int tabs = -1;
	public static void print(String s) { System.out.println("\t".repeat(tabs) + s); }
	public static void log(Object obj, String method) { System.out.println("\t".repeat(tabs) + "--> " + names.get(obj) + "." + method); }
	public static Map<Object, String> names = new HashMap<Object, String>();
	public static String nameOf(Object o) { return names.get(o); }
	
	interface UseCase {
		public String getName();
		public void run();
	}

	static class StabilJegtablaraLepes implements UseCase {
		public String getName() { return "Eszkimó a szomszédos stabil jégtáblára lép."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj1 = new Stabil_Jegtabla(); names.put(sj1, "JelenlegiJégtábla");
			Stabil_Jegtabla sj2 = new Stabil_Jegtabla(); names.put(sj2, "CélJégtábla");
			sj1.setSzomszed(1, sj2);
			sj2.setSzomszed(2, sj1);
			sj1.AddJatekos(e);
			e.lepes(1);
			names.clear();
		}
	}

	static class InstabilJegtablaraLepes implements UseCase {
		public String getName() { return "Eszkimó a szomszédos instabil jégtáblára lép."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "JelenlegiJégtábla");
			Instabil_Jegtabla isj = new Instabil_Jegtabla(); names.put(isj, "CélJégtábla");
			sj.setSzomszed(1, isj);
			isj.setSzomszed(2, sj);
			sj.AddJatekos(e);
			e.lepes(1);
		}
	}
	
	static class EszkimoLukbanMeghal implements UseCase{
		public String getName() {
			return "Eszkimó lukban van és meghal";
		}
		public void run() {
			//szereplõ osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Jatek jatek = new Jatek(); names.put(jatek, "jatek");
			
			//kapcsolatok beállítása
			l.AddJatekos(e);
			e.setJatek(jatek);
			
			//Szekvencia indítása
			e.kor();
		}
		
	}
	
	static class EszkimoLukbaLep implements UseCase{
		public String getName() {
			return "Eszkimó a szomszédos lukba lép";
		}
		public void run() {
			//szereplõ osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok beállítása
			sj.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia indítása
			e.lepes(2);
		}
		
	}
	
	static class EszkimoLukbolLepne implements UseCase{
		public String getName() {
			return "Eszkimó megpróbál lukból kilépni";
		}
		public void run() {
			//szereplõ osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok beállítása
			l.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia indítása
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
		
		//Use-case-ek hozzáadása
		/*1*/useCases.add(new StabilJegtablaraLepes());
		/*2*/ useCases.add(new InstabilJegtablaraLepes());
		/*4*/useCases.add(new EszkimoLukbanMeghal());
		/*5*/useCases.add(new EszkimoLukbaLep());
		/*6*/useCases.add(new EszkimoLukbolLepne());
		
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
