package projlab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
		patterns.put(Pattern.compile("^create SJ ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+)$"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			Mezo mezo = new Stabil_Jegtabla(game, snowlayers);
			entities.put(args[0], mezo);
			fields.add(mezo);
		});
		
		// create ISJ <name> <snowlayers> <capacity>
		patterns.put(Pattern.compile("^create ISJ ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+) ([0-9]+)$"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			int capacity = Integer.parseInt(args[2]);
			Mezo mezo = new Instabil_Jegtabla(game, snowlayers, capacity);
			entities.put(args[0], mezo);
			fields.add(mezo);
		});

		// create L <name>
		patterns.put(Pattern.compile("^create L ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+)$"), args -> {
			int snowlayers = Integer.parseInt(args[1]);
			Mezo mezo = new Luk(game, snowlayers);
			entities.put(args[0], mezo);
			fields.add(mezo);
		});
		
		// addNeighbor <field1> <dir> <field2>
		patterns.put(Pattern.compile("^addNeighbor ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+) ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Mezo field1 = (Mezo)entities.get(args[0]);
			Mezo field2 = (Mezo)entities.get(args[2]);
			int irany = Integer.parseInt(args[1]);
			if (field1 == null | field2 == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			field1.setSzomszed(irany, field2);
		});
		
		// create <szereplo> <name> <field>
		patterns.put(Pattern.compile("^create (Eszkimo|Sarkkutato|Jegesmedve) ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z_]+[a-zA-z_0-9]*)$"), 
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
		patterns.put(Pattern.compile("^create (Iglu|FelepitettSator) ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*)$"), 
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
		patterns.put(Pattern.compile("^create (Buvarruha|Kotel|Etel|Lapat|TorekenyAso|Sator|RaketaAlkatresz) ([a-zA-z]+[a-zA-z_0-9]*) (player|field) ([a-zA-z]+[a-zA-z_0-9]*)$"), 
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
		patterns.put(Pattern.compile("^useskill ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			Mezo mezo = (Mezo)entities.get(args[1]);
			if (szereplo == null || mezo == null) { System.out.println("Nincs ilyen nevu mezo vagy szereplo."); return; }
			szereplo.kepessegHasznal(mezo);
		});
		
		// useobject <object> <player> [dir]
		patterns.put(Pattern.compile("^useobject ([a-zA-z]+[a-zA-z_0-9]*) ([a-zA-z]+[a-zA-z_0-9]*) ?([0-9]+)?$"), args -> {
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
		patterns.put(Pattern.compile("^move ([a-zA-z]+[a-zA-z_0-9]*) ([0-9]+)$"), args -> {
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
		patterns.put(Pattern.compile("^digobject ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.targyKiasas();
		});
		
		// cleansnow <player>
		patterns.put(Pattern.compile("^digobject ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.hoTakaritas(1);
		});
		
		// pass <player>
		patterns.put(Pattern.compile("^pass ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Szereplo szereplo = (Szereplo)entities.get(args[0]);
			if (szereplo == null) { System.out.println("Nincs ilyen nevu szereplo."); return; }
			szereplo.passz();
		});
		
		// snowstorm <field>
		patterns.put(Pattern.compile("^snowstorm ([a-zA-z]+[a-zA-z_0-9]*)$"), args -> {
			Mezo mezo = (Mezo)entities.get(args[0]);
			if (mezo == null) { System.out.println("Nincs ilyen nevu mezo."); return; }
			mezo.hovihar();
		});
		
		// getStatus
		patterns.put(Pattern.compile("^getStatus$"), __ -> {
			printGameStatus();
		});
		
		// runscript <filename>
		patterns.put(Pattern.compile("^runscript ([\\w,\\s-\\.]+)$"), args -> {
			File file = new File(System.getProperty("user.dir") + "\\tests\\" + args[0]);
			Scanner scanner;
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("Helytelen fajlnev vagy nem nyithato meg."); return;
			}
			while(scanner.hasNextLine()) {
				executeCommand(scanner.nextLine().strip());
			}
			scanner.close();
		});
		
		// runtest <testnumber>
		patterns.put(Pattern.compile("^runtest ([0-9]+)$"), args -> {
			startNewGame();
			executeCommand("runscript test" + args[0] + ".txt");
			ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(testOutput, true);
			PrintStream stdout = System.out;
			System.setOut(ps);
			executeCommand("getStatus");
			System.setOut(stdout);
			Path expectedPath = Paths.get(System.getProperty("user.dir") + "\\tests\\test" + args[0] + "_expected.txt");
			try {
				checkTestCase("Testeset " + args[0] , Files.readAllBytes(expectedPath), testOutput.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			startNewGame();
		});
		
		// runalltests
		patterns.put(Pattern.compile("^runalltests$"), __ -> {
			File config = new File("./tests/tests.config");
			Scanner configScanner;
			try {
				configScanner = new Scanner(config);
			} catch (FileNotFoundException e) {
				System.out.println("Helytelen fajlnev vagy nem nyithato meg."); return;
			}
			while(configScanner.hasNextLine()) {
				startNewGame();
				String[] tokens = configScanner.nextLine().split(" ");
				executeCommand("runscript " + tokens[1]);
				ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
				PrintStream ps = new PrintStream(testOutput, true);
				PrintStream stdout = System.out;
				System.setOut(ps);
				executeCommand("getStatus");
				System.setOut(stdout);
				Path expectedPath = Paths.get(System.getProperty("user.dir") + "\\tests\\" + tokens[2]);
				try {
					checkTestCase(tokens[0], Files.readAllBytes(expectedPath), testOutput.toByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			configScanner.close();
			startNewGame();
		});
		
		// help
		patterns.put(Pattern.compile("^help$"), __ -> {
			System.out.print("Az objektumok nevei kis- es nagybetuket es a _ karaktert tartalmazhatjak. Az elso karakter nem lehet szam.\n"
					+ "Hasznalhato parancsok:\n"
					+ "> create SJ <name:string> <snowlayers:int>\n"
					+ "> create ISJ <name:string> <snowlayers:int> <capacity:int>\n"
					+ "> create L <name:string> <snowlayers:int>\n"
					+ "> addNeighbor <field1:string> <dir:int> <field2:string>\n"
					+ "> create {Eszkimo|Sarkkutato|Jegesmedve} <name:string> <field:string>\n"
					+ "> create {Iglu|FelepitettSator} <name:string> <field:string>\n"
					+ "> create {Buvarruha|Kotel|Etel|Lapat|TorekenyAso|Sator|RaketaAlkatresz} <name:string> {player <name:string>|field <name:string>}\n"
					+ "> useskill <player:string> <field:string>\n"
					+ "> useobject <object:string> <player:string> [dir:int]\n"
					+ "> move <player:string> <dir:int>\n"
					+ "> digobject <player:string>\n"
					+ "> cleansnow <player:string>\n"
					+ "> pass <player:string>\n"
					+ "> snowstorm <field:string>\n"
					+ "> runscript <scriptname:string>"
					+ "> runalltests\n"
					+ "> getStatus\n"
					+ "> help\n");
		});
		
		// whitespace = NOOP
		patterns.put(Pattern.compile("^\\s*$"), __ -> {});
		
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
	 * A jatek aktualis allapotat irja ki a standard kimenetre
	 * a dokumentacioban megadott kimeneti nyelven.
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
					int kapacitas = ((Instabil_Jegtabla)mezo).getTeherbiras();
					System.out.print("ISJ " + nev + " (" + horeteg + ","+ kapacitas + ") - object: ");
					break;
				case 3:
					System.out.print("L " + nev + " (" + horeteg + ") - object: ");
					break;
				}
				if (horeteg > 0)
					System.out.print("?\n");
				else if (mezo.getTargy() != null)
					entities.forEach((name, obj) -> System.out.print(obj.equals(mezo.getTargy()) ? name + "\n" : ""));
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
			Object maybeMezo = entry.getValue();
			if (fields.contains(maybeMezo)) {
				Mezo mezo = (Mezo)maybeMezo;
				String tipus = mezo.getEpitmeny().toString();
				if (!tipus.equals("Uresepulet")) {
					System.out.println(tipus + " on " + entry.getKey());
				}
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
	/**
	 * Resets the game, allowing for running new tests
	 * in a blank environment.
	 */
	public void startNewGame() {
		this.game = new Jatek();
		entities.clear();
		buildings.clear();
		fields.clear();
		actors.clear();
	}
	
	/**
	 * Verifies whether a given test case produced the expected result
	 * and then prints the result to the standard output.
	 * @param testname Name of the test case shown in the output message
	 * @param expected The expected result text
	 * @param actual The actual result text
	 */
	private void checkTestCase(String testname, byte[] expected, byte[] actual) {
		ByteArrayInputStream expectedIS = new ByteArrayInputStream(expected);
		ByteArrayInputStream actualIS = new ByteArrayInputStream(actual);
		Scanner expectedS = new Scanner(expectedIS);
		Scanner actualS = new Scanner(actualIS);
		boolean matching = true;
		while(expectedS.hasNextLine()) {
			String actualLine = actualS.nextLine().strip();
			String expectedLine = expectedS.nextLine().strip();
			if (!actualLine.equals(expectedLine)) {
				matching = false;
				break;
			}
		}
		while(actualS.hasNext()) {
			if(!actualS.nextLine().equals("")) {
				matching = false;
				break;
			}
		}
		if (matching) 
			System.out.println("--> Test case " + testname + " - SUCCESS");
		else {			
			System.out.println("--> Test case " + testname + " - FAILED");
			System.out.println("_____________ Expected: _____________");
			System.out.println(new String(expected));
			System.out.println("_____________ Actual: _______________");
			System.out.println(new String(actual));
			System.out.println("_____________________________________");
		}
		expectedS.close();
		actualS.close();
	}
	
	
}
