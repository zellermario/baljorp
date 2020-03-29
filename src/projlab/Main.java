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
		public String getName() { return "Eszkim� a szomsz�dos stabil j�gt�bl�ra l�p"; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Stabil_Jegtabla sj1 = new Stabil_Jegtabla(); names.put(sj1, "JelenlegiJ�gt�bla");
			Stabil_Jegtabla sj2 = new Stabil_Jegtabla(); names.put(sj2, "C�lJ�gt�bla");
			sj1.setSzomszed(1, sj2);
			sj2.setSzomszed(2, sj1);
			sj1.AddJatekos(e);
			e.lepes(1);
			names.clear();
		}
	}

	static class InstabilJegtablaraLepes implements UseCase {
		public String getName() { return "Eszkim� a szomsz�dos instabil j�gt�bl�ra l�p."; }
		public void run() {
			Jatek jatek = new Jatek(); names.put(jatek, "jatek");
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "JelenlegiJ�gt�bla");
			Instabil_Jegtabla isj = new Instabil_Jegtabla(); names.put(isj, "C�lJ�gt�bla");
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
			return "Eszkim� lukban van �s meghal";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Luk l= new Luk(); names.put(l, "Luk");
			Jatek jatek = new Jatek(); names.put(jatek, "jatek");
			
			//kapcsolatok be�ll�t�sa
			l.AddJatekos(e);
			e.setJatek(jatek);
			
			//Szekvencia ind�t�sa
			e.kor();
			names.clear();
		}
	}
	
	static class EszkimoLukbaLep implements UseCase{
		public String getName() {
			return "Eszkim� a szomsz�dos lukba l�p";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok be�ll�t�sa
			sj.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia ind�t�sa
			e.lepes(2);
			names.clear();
		}
		
	}
	
	static class EszkimoLukbolLepne implements UseCase{
		public String getName() {
			return "Eszkim� megpr�b�l lukb�l kil�pni";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Luk l= new Luk(); names.put(l, "Luk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			
			//kapcsolatok be�ll�t�sa
			l.AddJatekos(e);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia ind�t�sa
			e.lepes(1);
			names.clear();
		}
	}
	
	static class EszkimoEtel implements UseCase{
		public String getName() {
			return "Eszkim� ki�s egy �telt �s azt el is fogyasztja";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			Etel etel = new Etel(); names.put(etel, "Étel");
			
			//kapcsolatok be�ll�t�sa
			sj.AddJatekos(e);
			sj.setTargy(etel);
		
			//Szekvencia ind�t�sa
			e.targyKiasas();
			names.clear();
		}
	}
	
	static class EszkimoLapatotHasznal implements UseCase{
		public String getName() {
			return "Eszkim� a lap�tot haszn�lja";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil_Jegtabla");
			Lapat l = new Lapat(); names.put(l, "Lapat");
			//kapcsolatok be�ll�t�sa
			sj.AddJatekos(e);
			sj.setTargy(l);
			
			//Szekvencia ind�t�sa
			l.hasznal(e); 
		}
	}
      
	static class BuvarruhaHasznalat implements UseCase {
		public String getName() { return "Eszkim� a búv�rruh�t haszn�lja."; }
		public void run() {
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkim�");
			Buvarruha br = new Buvarruha(); names.put(br, "Búv�rruha");
			Luk luk = new Luk(); names.put(luk, "JelenlegiLuk");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "C�lJ�gt�bla");
			luk.setSzomszed(1, sj);
			sj.setSzomszed(2, luk);
			esz.addTargy(br);
			luk.AddJatekos(esz);
			br.hasznal(esz, 1);
			names.clear();
		}
	}
	
	static class RaketaKiasas implements UseCase {
		public String getName() { return "Eszkim� ki�s egy rak�talkatr�szt."; }
		public void run() {
			Jatek j = new Jatek(); names.put(j, "J�t�k");
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkim�");
			Raketaalkatresz ra = new Raketaalkatresz(); names.put(ra, "Rak�talkatr�sz");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "J�gt�bla");
			ra.setJatek(j);
			sj.setTargy(ra);
			sj.AddJatekos(esz);
			esz.targyKiasas();
			names.clear();
		}
	}
	
	static class EszkimoKepesseg implements UseCase {
		public String getName() { return "Eszkim� k�pess�get haszn�l."; }
		public void run() {
			Eszkimo esz = new Eszkimo(); names.put(esz, "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "J�gt�bla");
			sj.AddJatekos(esz);
			esz.kepessegHasznal(sj);
			names.clear();
		}
	}

	static class UtolsoRaketaalkatreszKiasas implements UseCase {
		public String getName() { return "Eszkim� ki�ssa az utols� rak�taalkatr�szt �s nyernek."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Raketaalkatresz ra = new Raketaalkatresz(); names.put(ra, "Utols�Rak�taAlkatr�sz");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "T�rgyatTartalmaz�J�gt�bla");
			sj.setTargy(ra);
			Jatek jatek = new Jatek(); names.put(jatek, "J�t�k");
			ra.setJatek(jatek);
			sj.AddJatekos(e);
			sj.targyAtad(e);
			names.clear();
		}
	}
		
	static class HoviharIgluban implements UseCase {
		public String getName() { return "Eszkim�t elkapja a h�vihar egy igluban"; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "IglusJ�gt�bla");
			Jatek jatek = new Jatek(); names.put(jatek, "J�t�k");
			sj.AddJatekos(e);
			sj.igluEpit();
			sj.hovihar();
			names.clear();
		}
	}
	
	static class EszkimoKotel implements UseCase{
		public String getName() {
			return "Eszkim� a k�telet haszn�lja";
		}
		public void run() {
			//szereplő oszt�lyok inicializ�l�sa
			Eszkimo e = new Eszkimo(); names.put(e,  "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "sj");
			Kotel k = new Kotel(); names.put(k, "k");
			Luk l= new Luk(); names.put(l, "Luk");
			Sarkkutato sz = new Sarkkutato(); names.put(sz, "sz");
			//kapcsolatok be�ll�t�sa
			sj.AddJatekos(e);
			l.AddJatekos(sz);
			l.setSzomszed(1, sj);
			sj.setSzomszed(2, l);
			
			//Szekvencia ind�t�sa
			k.hasznal(e);
    }
  }
      
	static class HoviharUresepuletben implements UseCase {
		public String getName() { return "Eszkim�t elkapja a h�vihar egy �res �p�letben"; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "IglusJ�gt�bla");
			Jatek jatek = new Jatek(); names.put(jatek, "J�t�k");
			sj.AddJatekos(e);
			sj.hovihar();
			names.clear();
		}
	}
				
	static class EszkimoHavatLapatol implements UseCase {
		public String getName() { return "Eszkim� havat takar�t."; }
		public void run() {
			Eszkimo e = new Eszkimo(); names.put(e, "Eszkim�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "StabilJ�gt�bla");
			sj.setHoreteg(5);
			e.setMezo(sj);
			e.hoTakaritas(1);
			names.clear();
		}
	}
				
	static class SarkkutatoLukon implements UseCase {
		public String getName() { return "Sarkkutat� a k�pess�g�t haszn�lja egy lukon."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutat�");
			Luk l = new Luk(); names.put(l, "Luk");

			s.kepessegHasznal(l);
			names.clear();
		}
	}
	
	static class SarkkutatoInstabilJegtablan implements UseCase {
		public String getName() { return "Sarkkutat� a k�pess�g�t haszn�lja egy instabil j�gt�bl�n."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutat�");
			Instabil_Jegtabla isj = new Instabil_Jegtabla(); names.put(isj, "Instabil J�gt�bla");
	
			s.kepessegHasznal(isj);
			names.clear();
		}
	}
				
	static class SarkkutatoStabilJegtablan implements UseCase {
		public String getName() { return "Sarkkutat� a k�pess�g�t haszn�lja egy stabil j�gt�bl�n."; }
		public void run() {
			Sarkkutato s = new Sarkkutato(); names.put(s, "Sarkkutat�");
			Stabil_Jegtabla sj = new Stabil_Jegtabla(); names.put(sj, "Stabil J�gt�bla");
			s.kepessegHasznal(sj);
			names.clear();
		}
	}

	static class Kilepes implements UseCase {
		public String getName() { return "Kil�p�s."; }
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
			System.out.println("V�lasszon use-case-t!\n");
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
