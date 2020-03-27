package projlab;

import java.util.Scanner;

public class Main {
	private int tab; //tab-ok szama.
	
	public static void stabiljegtablara_lepes() {}
	public static void instabiljegtablara_lepes() {}
	public static void instabiljegtabla_atfordul() {}
	public static void lukba_lepes() {}
	public static void lukban_meghal() {}
	public static void lukbol_megprobal_kilepni() {}
	public static void etelt_hasznal() {}
	public static void lapatot_hasznal() {}
	public static void kotelet_hasznal() {}
	public static void buvarruhat_hasznal() {}
	public static void raketalaaktreszt_kias() {}
	public static void eszkimo_kepesseg() {}
	public static void sarkkutato_kepesseg_stabil() {}
	public static void sarkkutato_kepesseg_instabil() {}
	public static void sarkkutato_kepesseg_luk() {}
	public static void ho_takarit() {}
	public static void hovihar_uresepuletben() {}
	public static void hovihar_igluban() {}
	public static void gyozelem() {}
	
	
	public static void main(String args[]) {
		String tesztek[] = {"Eszkimó a szomszédos stabil jégtáblára lép.",
				"Eszkimó a szomszédos instabil jégtáblára lép.",
				"Eszkimó a szomszédos instabil jégtáblára lép és jégtábla átfordul.",
				"Eszkimó a szomszédos lukba lép.",
				"Eszkimó lukban van és meghal.",
				"Eszkimó megpróbál lukból kilépni.",
				"Eszkimó kiás egy ételt és használja.",
				"Eszkimó a lapátot használja.",
				"Eszkimó a kötelet használja.",
				"Eszkimó a búvárruhát használja.",
				"Eszkimó kiás egy rákétaalkatrészt.",
				"Eszkimó képességet használ.",
				"Sarkkutató képességet használ egy stabil jégtáblán.",
				"Sarkkutató képességet használ egy instabil jégtáblán.",
				"Sarkkutató képességet használ egy lukon.",
				"Eszkimó egy réteg havat eltakarít.",
				"Egy eszkimót elkap a hóvihar üres épületben.",
				"Egy eszkimót elkap a hóvihar igluban.",
				"Eszkimó kiássa az utolsó rakétaalkatrészt és nyernek.",
				"Kilépés."};
		
		boolean exit = false;
		Scanner input = new Scanner(System.in); //Szám beolvasásához használom.
		while(!exit) {
			System.out.println("Válasszon egy tesztet:\n");
			for(int i = 1; i < 21; i++)
				System.out.println(i + " " + tesztek[i - 1]);
			int teszt = input.nextInt();
			
			if(teszt != 20)					//Mert itt nincs teszt csak kilépünk
				System.out.println("A választott teszt: " + tesztek[teszt]);
			
			switch(teszt) {
			  	case 1:
			  		stabiljegtablara_lepes();
			  		break;
			  	case 2:
			  		instabiljegtablara_lepes();
			  		break;
			  	case 3:
			  		instabiljegtabla_atfordul();
			  		break;
			  	case 4:
			  		lukba_lepes();
			  		break;
			  	case 5:
			  		lukban_meghal();
			  		break;
			  	case 6:
			  		lukbol_megprobal_kilepni();
			  		break;
			  	case 7:
			  		etelt_hasznal();
			  		break;
			  	case 8:
			  		lapatot_hasznal();
			  		break;
			  	case 9:
				    kotelet_hasznal();
			  		break;
			  	case 10:
			  		buvarruhat_hasznal();
			  		break;
			  	case 11:
				    raketalaaktreszt_kias();
			  		break;
			  	case 12:
			  		eszkimo_kepesseg();
			  		break;
			  	case 13:
			  		sarkkutato_kepesseg_stabil();
			  		break;
			  	case 14:
				    sarkkutato_kepesseg_instabil();
			  		break;
			  	case 15:
			  		sarkkutato_kepesseg_luk();
			  		break;
			  	case 16:
			  		ho_takarit();
			  		break;
			  	case 17:
			  		hovihar_uresepuletben();
			  		break;
			  	case 18:
			  		hovihar_igluban();
			  		break;
			  	case 19:
			  		gyozelem();
			  		break;
			  	case 20:
			  		exit = true;;
			  		break;
			}
		}
		input.close();
	}
	
}
