package projlab;

import java.io.FileNotFoundException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

/** Szoveges interfesz a jatekhoz.
 *  Egy Jatek objektum manipulaciojat teszi lehetove
 *  szoveges parancsokkal, illetve a jatek aktualis
 *  allapotanak lekerdezeset szoveges formaban.
 *  */
public class TextInterface {
	
	private Map<Pattern, Consumer<String[]>> patterns = new HashMap<Pattern, Consumer<String[]>>();
	private Map<String, Object> entities = new TreeMap<String, Object>();
	private List<Epitmeny> buildings = new ArrayList<Epitmeny>();
	private List<Szereplo> actors = new ArrayList<Szereplo>();
	private List<Mezo> fields = new ArrayList<Mezo>();
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
			Mezo mezo = new Stabil_Jegtabla(game, snowlayers);
			entities.put(args[0], mezo);
			fields.add(mezo);
		});
		
		// create ISJ <name> <snowlayers> <capacity>
		patterns.put(Pattern.compile("create ISJ ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+) ([0-9]+)"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			int capacity = Integer.parseInt(args[2]);
			Mezo mezo = new Instabil_Jegtabla(game, snowlayers, capacity);
			entities.put(args[0], mezo);
			fields.add(mezo);
		});

		// create L <name>
		patterns.put(Pattern.compile("create L ([a-zA-z]+[a-zA-z_0-9]*)"), args -> {
			Mezo mezo = new Luk(game);
			entities.put(args[0], mezo);
			fields.add(mezo);
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
			if (args[0].equals("Eszkimo")) szereplo = new Eszkimo(game, mezo); 
			else if (args[0].equals("Sarkkutato")) szereplo = new Sarkkutato(game, mezo);
			else if (args[0].equals("Jegesmedve")) szereplo = new Jegesmedve(game, mezo);
			entities.put(args[1], szereplo);
			if (args[0].equals("Jegesmedve")) game.addJegesmedve((Jegesmedve)szereplo);
			else game.addSzereplo(szereplo);
			actors.add(szereplo);
		});
		
		// create <epitmeny> <name> <field>
		patterns.put(Pattern.compile("create (Iglu|FelepitettSator) ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*)"), 
		args -> {
			Mezo mezo = (Mezo)entities.get(args[2]);
			if (mezo == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			Epitmeny epitmeny = null;
			if (args[0].equals("Iglu")) epitmeny = new Iglu(mezo);
			else if (args[0].equals("FelepitettSator")) epitmeny = new FelepitettSator(mezo);
			entities.put(args[1], epitmeny);
			buildings.add(epitmeny);
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
				case "Etel": targy = new Etel(); break; 
				case "Lapat": targy = new Lapat(); break;
				case "TorekenyAso": targy = new TorekenyAso(); break;
				case "Sator": targy = new Sator(); break;
				case "RaketaAlkatresz": targy = new Raketaalkatresz(game); break;
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
		
		// pass <player>
		patterns.put(Pattern.compile("pass"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.passz();
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
			File file = new File(System.getProperty("user.dir") + "\\tests\\" + args[0] + ".txt");
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
			System.out.print("Az objektumok nevei kis- es nagybetuket es a _ karaktert tartalmazhatjak. Az elso karakter nem lehet szam.\n"
					+ "Hasznalhato parancsok:\n"
					+ "> create SJ <name:string> <snowlayers:int>\n"
					+ "> create ISJ <name:string> <snowlayers:int> <capacity:int>\n"
					+ "> create L <name:string>\n"
					+ "> addNeighbor <field1:string> <dir:int> <field2:string>\n"
					+ "> create {Eszkimo|Sarkkutato|Jegesmedve} <name:string> <field:string>\n"
					+ "> create {Iglu|FelepitettSator} <name:string> <field:string>\n"
					+ "> create {Buvarruha|Kotel|Etel|Lapat|TorekenyAso|Sator|RaketaAlkatresz} {player <name:string>|field <name:string>}\n"
					+ "> useskill <player:string> <field:string>\n"
					+ "> useobject <object:string> <player:string> [dir:int]\n"
					+ "> move <player:string> <dir:int>\n"
					+ "> digobject <player:string>\n"
					+ "> cleansnow <player:string>\n"
					+ "> pass <player:string>\n"
					+ "> snowstorm <field:string>\n"
					+ "> runscript <filename:string>\n"
					+ "> getStatus\n"
					+ "> help\n");
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
		System.out.println("Fields:");
		for (Entry<String, Object> entry : entities.entrySet()) {
			Object maybeMezo = entry.getValue();
			if (fields.contains(maybeMezo)) {
				Mezo mezo = (Mezo)maybeMezo;
				String nev = entry.getKey();
				int horeteg = mezo.getHoreteg();
				switch (mezo.getId()) {
				case 1:
					System.out.print("SJ " + nev + " (" + horeteg + ") - object: "); 
					break;
				case 2:
					System.out.print("ISJ " + nev + " (" + horeteg + ") - object: ");
					break;
				case 3:
					System.out.print("L " + nev + " (" + horeteg + ") - object: ");
					break;
				}
				if (horeteg > 0)
					System.out.print("?\n");
				else if (mezo.getTargy() != null)
					entities.forEach((name, obj) -> System.out.print(obj.equals(mezo) ? name : ""));
				else System.out.print("x\n");
				System.out.print("\tneighbours: [");
				int i = 0;
				for (Entry<Integer, Mezo> neighbor : mezo.getSzomszedos_mezok().entrySet()) {
					System.out.print("(" + neighbor.getKey() + ",");
					entities.forEach((name, obj) -> System.out.print(obj.equals(neighbor.getValue()) ? name + ")" : ""));
					i++;
					if (i != mezo.getSzomszedos_mezok().size()) System.out.print(", ");
				}
				System.out.print("]\n");
			}
		}
		System.out.println("\nBuildings:");
		for (Entry<String, Object> entry : entities.entrySet()) {
			Object maybeEpitmeny = entry.getValue();
			if (buildings.contains(maybeEpitmeny)) {
				Epitmeny epitmeny = (Epitmeny)maybeEpitmeny;
				System.out.print(epitmeny.toString() + " " +  entry.getKey() + " on ");
				entities.forEach((name, obj) -> System.out.print(obj.equals(epitmeny.getMezo()) ? name + "\n" : ""));
			}
		}
		System.out.println("\nActors:");
		for (Entry<String, Object> entry : entities.entrySet()) {
			Object maybeSzereplo = entry.getValue();
			if (actors.contains(maybeSzereplo)) {
				Szereplo szereplo = (Szereplo)maybeSzereplo;
				System.out.print("> " + szereplo.toString() + " " + entry.getKey() + " (heat: " + szereplo.getTestho() + ") on ");
				entities.forEach((name, obj) -> System.out.print(obj.equals(szereplo.getKurrensMezo()) ? name + "\n" : ""));
				System.out.print("  Inventory: [");
				int i = 0;
				for (Targy targy : szereplo.getTargyak()) {
					entities.forEach((name, obj) -> System.out.print(obj.equals(targy) ? name : ""));
					i++;
					if (i != szereplo.getTargyak().size()) System.out.print(", ");
				}
				System.out.print("]\n");
			}
		}
	}
}
