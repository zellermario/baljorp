package projlab;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

/** Szoveges interfesz a jatekhoz.
 *  Egy Jatek objektum manipulaciojat teszi lehetove
 *  szoveges parancsokkal, illetve a jatek aktualis
 *  allapotanak lekerdezeset szoveges formaban.
 *  */
public class TextInterface {
	
	private Map<Pattern, Consumer<String[]>> patterns = new HashMap<Pattern, Consumer<String[]>>();
	private Map<String, Object> entities = new HashMap<String, Object>();
	private Jatek game;
	
	/** A TextInterface osztaly konstruktora.
	 *  @param jatek Az a jatek objektum, amelyhez a szoveges
	 *  interfeszhez csatolando.
	 * */
	public TextInterface(Jatek jatek) {
		this.game = jatek;
		
		// create SJ <name> <snowlayers>
		patterns.put(Pattern.compile("create SJ ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+)"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			entities.put(args[0], new Stabil_Jegtabla(1, game)); // TODO: Mi legyen akkor az ID-kkel?
		});
		
		// create ISJ <name> <snowlayers> <capacity>
		patterns.put(Pattern.compile("create ISJ ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+) ([0-9]+)"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			int capacity = Integer.parseInt(args[2]);
			entities.put(args[0], new Instabil_Jegtabla(2, game)); // TODO: kell teherbírást meg hóréteget tudni megadni itt.
		});

		// create L <name>
		patterns.put(Pattern.compile("create L ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			entities.put(args[0], new Luk(3, game));
		});
		
		// addNeighbor <field1> <dir> <field2>
		patterns.put(Pattern.compile("addNeighbor ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+) ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Mezo field1 = (Mezo)entities.get(args[0]);
			Mezo field2 = (Mezo)entities.get(args[2]);
			int irany = Integer.parseInt(args[1]);
			if (field1 == null | field2 == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			field1.setSzomszed(irany, field2);
		});
		
		// create <szereplo> <name> <field>
		patterns.put(Pattern.compile("create (Eszkimo|Sarkkutato|Jegesmedve) ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z_]+[a-zA-z_0-9]*)"), 
		args -> {
			Mezo mezo = (Mezo)entities.get(args[2]);
			if (mezo == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			Szereplo szereplo = null;
			if (args[0].equals("Eszkimo")) szereplo = new Eszkimo(game); 
			else if (args[0].equals("Sarkkutato")) szereplo = new Sarkkutato(game);
			else if (args[0].equals("Jegesmedve")) szereplo = new Jegesmedve(game);
			entities.put(args[1], szereplo);
			if (args[0].equals("Jegesmedve")) game.addJegesmedve((Jegesmedve)szereplo);
			else game.addSzereplo(szereplo);
			mezo.jatekosFogadas(szereplo);
		});
		
		// create <epitmeny> <name> <field>
		patterns.put(Pattern.compile("create (Iglu|Uresepulet|FelepitettSator) ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*)"), 
		args -> {
			Mezo mezo = (Mezo)entities.get(args[2]);
			if (mezo == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			Epitmeny epitmeny = null;
			if (args[0].equals("Iglu")) epitmeny = new Iglu(mezo);
			else if (args[0].equals("Uresepulet")) epitmeny = new Uresepulet(mezo);
			else if (args[0].equals("FelepitettSator")) epitmeny = new FelepitettSator(mezo);
			entities.put(args[1], epitmeny);
			mezo.epit(epitmeny);
		});
		
		// create <targy> <object_name> player <player_name>
		// create <targy> <object_name> field <field_name>
		patterns.put(Pattern.compile("create (Buvarruha|Kotel|Etel|Lapat|TorekenyAso|Sator|RaketaAlkatresz) ([a-zA-z]+[a-zA-z_0-9]*)"
								      + " (?:(player) ([a-zA-z]+[a-zA-z_0-9]*)|(field) ([a-zA-z]+[a-zA-z_0-9]*))"), 
		args -> {
			Targy targy = null;
			switch (args[0]) {
				case "Buvarruha": targy = new Buvarruha(); break;
				case "Kotel": targy = new Kotel(); break;
				case "Etel": targy = new Etel(2); break; 
				case "Lapat": targy = new Lapat(3); break; // TODO: ID-kkal mi legyen akkor?
				case "TorekenyAso": targy = new TorekenyAso(4); break;
				case "Sator": targy = new Sator(5); break;
				case "RaketaAlkatresz": targy = new Raketaalkatresz(7, game); break;
			}
			entities.put(args[1], targy);
			if (entities.get(args[3]) == null) { System.out.println("Nincs ilyen nevu mezo vagy szereplo."); return; }
			if (args[2].equals("player"))((Szereplo)entities.get(args[3])).AddTargy(targy);
			else if (args[2].equals("field")) ((Mezo)entities.get(args[3])).setTargy(targy);
		});
		
		// useskill <player> <field>
		patterns.put(Pattern.compile("useskill ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			Mezo mezo = (Mezo)entities.get(args[1]);
			if (szereplo == null || mezo == null) { System.out.println("Nincs ilyen nevu mezo vagy szereplo."); return; }
			szereplo.kepessegHasznal(mezo);
		});
		
		// useobject <object> <player> [dir]
		patterns.put(Pattern.compile("useobject ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*) ?([0-9]+)?"), args -> {
			Targy targy = (Targy)entities.get(args[0]);
			Szereplo szereplo = (Szereplo)entities.get(args[1]);
			if (szereplo == null || targy == null) { System.out.println("Nincs ilyen nevu targy vagy szereplo."); return; }
			int irany;
			try {			
				irany = Integer.parseInt(args[2]);
			}
			catch (Exception e) {
				targy.hasznal(szereplo);
				return;
			}
			if (targy.getId() == 0) ((Buvarruha)targy).hasznal(szereplo, irany);
		});
		
		// move <player> <dir>
		patterns.put(Pattern.compile("move ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+)"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			int irany;
			try {			
				irany = Integer.parseInt(args[1]);
			}
			catch (Exception e) {
				System.out.println("Helytelenul megadott irany.");
				return;
			}
			szereplo.lepes(irany);
		});
		
		// digobject <player>
		patterns.put(Pattern.compile("digobject ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.targyKiasas();
		});
		
		// cleansnow <player>
		patterns.put(Pattern.compile("digobject ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.hoTakaritas(1);
		});
		
		// snowstorm <field>
		patterns.put(Pattern.compile("snowstorm ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Mezo mezo = (Mezo)entities.get(args[0]);
			if (mezo == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			mezo.hovihar();
		});
		
		// getStatus
		patterns.put(Pattern.compile("getStatus"), args -> {
			printGameStatus();
		});
		
		// runscript <filename>
		patterns.put(Pattern.compile("runscript ([\\w,\\s-\\.]+)"), args -> {
			File file = new File(args[0]);
			Scanner scanner;
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("Helytelen fajlnev vagy nem nyithato meg."); return;
			}
			while(scanner.hasNextLine()) {
				executeCommand(scanner.nextLine());
			}
			scanner.close();
		});
		
		// help
		patterns.put(Pattern.compile("help"), args -> {
			System.out.print("Hasznalhato parancsok:\n"
					+ "> create SJ <name:string> <snowlayers:int>\n"
					+ "> create ISJ <name:string> <snowlayers:int> <capacity:int>\n"
					+ "> create {Eszkimo|Sarkkutato|Jegesmedve} <name:string> <field:string>\n"
					+ "> create {Iglu|Uresepulet|FelepitettSator} <name:string> <field:string>\n"
					+ "> create {Buvarruha|Kotel|Etel|Lapat|TorekenyAso|Sator|RaketaAlkatresz} {player <name:string>|field <name:string>}\n"
					+ "> useskill <player:string> <field:string>\n"
					+ "> useobject <object:string> <player:string> [dir:int]\n"
					+ "> move <player:string> <dir:int>\n"
					+ "> digobject <player:string>\n"
					+ "> cleansnow <player:string>\n"
					+ "> snowstorm <field:string>\n"
					+ "> runscript <filename:string>\n"
					+ "> getStatus\n");
		});
	}

	/**
	 * Ertelmez egy szovegesen megadott parancsot, es amennyiben
	 * a parancs ervenyes, vegrehajtja a jatekon a megadott parancsot.
	 * @param command A vegrehajtando parancs szovege.
	 */
	public void executeCommand(String command) {
		for (Pattern pattern : patterns.keySet()) {
			Matcher matcher = pattern.matcher(command);
			Consumer<String[]> function = patterns.get(pattern);
			if (matcher.find()) {
				String[] args = new String[matcher.groupCount()];
				for (int i = 0; i < matcher.groupCount(); i++) {
					args[i] = matcher.group(i + 1);
				}
				function.accept(args);
				return;
			}
		}
		System.out.println("Helytelen parancs. Segitseghez a parancs: help");
	}
	
	/**
	 * A jatek aktualis allapotat irja ki a standard kimenetre.
	 */
	public void printGameStatus() {
		System.out.println("The game is running.");
	}
	
}
