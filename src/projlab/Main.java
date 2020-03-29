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
	public static Scanner scanner = new Scanner(System.in);

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
			Jatek jatek = new Jatek(); names.put(jatek, "jatek");
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "JelenlegiJégtábla");
			Instabil_Jegtabla isj = new Instabil_Jegtabla(); names.put(isj, "CélJégtábla");
			e.setJatek(jatek);
			sj.setSzomszed(1, isj);
			isj.setSzomszed(2, sj);
			sj.AddJatekos(e);
			e.lepes(1);
			names.clear();
		}
	}
	
	static class EszkimoLukbanMeghal implements UseCase{
		public String getName() {
			return "Eszkimó lukban van és meghal";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Jatek jatek = new Jatek(); names.put(jatek, "jatek");
			
			//kapcsolatok beállítása
			l.AddJatekos(e);
			e.setJatek(jatek);
			
			//Szekvencia indítása
			e.kor();
			names.clear();
		}
	}
	
	static class EszkimoLukbaLep implements UseCase{
		public String getName() {
			return "Eszkimó a szomszédos lukba lép";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok beállítása
			sj.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia indítása
			e.lepes(2);
			names.clear();
		}
		
	}
	
	static class EszkimoLukbolLepne implements UseCase{
		public String getName() {
			return "Eszkimó megpróbál lukból kilépni";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok beállítása
			l.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia indítása
			e.lepes(1);
			names.clear();
		}
	}
	
	static class EszkimoEtel implements UseCase{
		public String getName() {
			return "Eszkimó kiás egy ételt és azt el is fogyasztja";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			Etel etel = new Etel(); names.put(etel, "Étel");
			
			//kapcsolatok beállítása
			sj.AddJatekos(e);
			sj.setTargy(etel);
		
			//Szekvencia indítása
			e.targyKiasas();
			names.clear();
		}
	}
	
	static class EszkimoLapatotHasznal implements UseCase{
		public String getName() {
			return "Eszkimó a lapátot használja";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			Lapat l = new Lapat(); names.put(l, "Lapat");
			//kapcsolatok beállítása
			sj.AddJatekos(e);
			sj.setTargy(l);
			
			//Szekvencia indátása
			l.hasznal(e); 
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

	static class UtolsoRaketaalkatreszKiasas implements UseCase {
		public String getName() { return "Eszkimó kiássa az utolsó rakétaalkatrészt és nyernek."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Raketaalkatresz ra = new Raketaalkatresz(); names.put(ra, "UtolsóRakétaAlkatrész");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "TárgyatTartalmazóJégtábla");
			sj.setTargy(ra);
			Jatek jatek = new Jatek(); names.put(jatek, "Játék");
			ra.setJatek(jatek);
			sj.AddJatekos(e);
			sj.targyAtad(e);
			names.clear();
		}
	}
		
	static class HoviharIgluban implements UseCase {
		public String getName() { return "Eszkimót elkapja a hóvihar egy igluban"; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "IglusJégtábla");
			Jatek jatek = new Jatek(); names.put(jatek, "Játék");
			sj.AddJatekos(e);
			sj.igluEpit();
			sj.hovihar();
			names.clear();
		}
	}
	
	static class EszkimoKotel implements UseCase{
		public String getName() {
			return "Eszkimó a kötelet használja";
		}
		public void run() {
			//szereplő osztályok inicializálása
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "sj");
			Kotel k = new Kotel(); names.put(k, "k");
			Luk l= new Luk(); names.put(l, "Luk");
			Sarkkutato sz = new Sarkkutato(); names.put(sz, "sz");
			//kapcsolatok beállítása
			sj.AddJatekos(e);
			l.AddJatekos(sz);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia indítása
			k.hasznal(e);
    }
  }
      
	static class HoviharUresepuletben implements UseCase {
		public String getName() { return "Eszkimót elkapja a hóvihar egy üres épületben"; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "IglusJégtábla");
			Jatek jatek = new Jatek(); names.put(jatek, "Játék");
			sj.AddJatekos(e);
			sj.hovihar();
			names.clear();
		}
	}
				
	static class EszkimoHavatLapatol implements UseCase {
		public String getName() { return "Eszkimó havat takarít."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkimó");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "StabilJégtábla");
			sj.setHoreteg(5);
			e.setMezo(sj);
			e.hoTakaritas(1);
			names.clear();
		}
	}
				
	static class SarkkutatoLukon implements UseCase {
		public String getName() { return "Sarkkutató a képességét használja egy lukon."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutató");
			Luk l = new Luk(); names.put(l, "Luk");

			s.kepessegHasznal(l);
			names.clear();
		}
	}
	
	static class SarkkutatoInstabilJegtablan implements UseCase {
		public String getName() { return "Sarkkutató a képességét használja egy instabil jégtáblán."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutató");
			Instabil_Jegtabla isj = new Instabil_Jegtabla(); names.put(isj, "Instabil Jégtábla");
	
			s.kepessegHasznal(isj);
			names.clear();
		}
	}
				
	static class SarkkutatoStabilJegtablan implements UseCase {
		public String getName() { return "Sarkkutató a képességét használja egy stabil jégtáblán."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutató");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil Jégtábla");
			s.kepessegHasznal(sj);
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

	public static void main(String args[]) {

		List<UseCase> useCases = new ArrayList<UseCase>();

		useCases.add(new StabilJegtablaraLepes());
		useCases.add(new InstabilJegtablaraLepes());
		useCases.add(new BuvarruhaHasznalat());
		useCases.add(new RaketaKiasas());
		useCases.add(new EszkimoKepesseg());
		useCases.add(new SarkkutatoStabilJegtablan());
		useCases.add(new SarkkutatoInstabilJegtablan());
		useCases.add(new SarkkutatoLukon());
		useCases.add(new EszkimoLukbanMeghal());
		useCases.add(new EszkimoLukbaLep());
		useCases.add(new EszkimoLukbolLepne());
		useCases.add(new EszkimoHavatLapatol());
		useCases.add(new EszkimoKotel());
		useCases.add(new EszkimoLapatotHasznal());
		useCases.add(new HoviharUresepuletben());
		useCases.add(new HoviharIgluban());
		useCases.add(new UtolsoRaketaalkatreszKiasas());
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
