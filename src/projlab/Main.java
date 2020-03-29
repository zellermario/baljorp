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
		public String getName() { return "Eszkimó a szomszédos stabil jégtáblára lép"; }
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
			names.clear();
		}
	}
	
	static class BuvarruhaHasznalat implements UseCase {
		public String getName() { return "Eszkimó a búvárruhát használja."; }
		public void run() {
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkimó");
			Buvarruha br = new Buvarruha(); names.put(br, "Búvárruha");
			Luk luk = new Luk(); names.put(luk, "JelenlegiLuk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "CélJégtábla");
			luk.setSzomszed(1, sj);
			sj.setSzomszed(2, luk);
			esz.addTargy(br);
			luk.AddJatekos(esz);
			br.hasznal(esz, 1);
			names.clear();
		}
	}
	
	static class RaketaKiasas implements UseCase {
		public String getName() { return "Eszkimó kiás egy rakétalkatrészt."; }
		public void run() {
			Jatek j = new Jatek(); names.put(j, "Játék");
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkimó");
			Raketaalkatresz ra = new Raketaalkatresz(); names.put(ra, "Rakétalkatrész");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Jégtábla");
			ra.setJatek(j);
			sj.setTargy(ra);
			sj.AddJatekos(esz);
			esz.targyKiasas();
			names.clear();
		}
	}
	
	static class EszkimoKepesseg implements UseCase {
		public String getName() { return "Eszkimó képességet használ."; }
		public void run() {
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Jégtábla");
			sj.AddJatekos(esz);
			esz.kepessegHasznal(sj);
			names.clear();
		}
	}

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
		useCases.add(new BuvarruhaHasznalat());
		useCases.add(new RaketaKiasas());
		useCases.add(new EszkimoKepesseg());
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
