import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
	private TreeSet<String> animals;
	
	private static final List<String> UNIVERSAL_ZOO = Arrays.asList("elephant", "giraffe", "gorilla",
		"hippo", "kangaroo", "lion", "penguin", "rhino", "tiger", "zebra");
	
	/**
	 * Assigns our String animal to a TreeSet
	 */
	public Sets() {
		this.animals = new TreeSet<>();
	}
	
	/**
	 * Adds a String animal to our Sets class
	 * @param animal
	 */
	public void addAnimal(String animal) {
		String animalLowerCase = animal.toLowerCase();
		animals.add(animalLowerCase);
	}
	
	/**
	 * Performs the Union set operation on two sets
	 * @param otherSet
	 * @return
	 */
	public Sets combineSets(Sets otherSet) {
		Sets newZoo = new Sets();
		newZoo.animals.addAll(this.animals);
		newZoo.animals.addAll(otherSet.animals);
		return newZoo;
	}
	
	/**
	 * Performs the Intersection set operation on two sets
	 * @param otherSet
	 * @return
	 */
	public Sets keepOnlyCommon(Sets otherSet) {
		Sets newZoo = new Sets();
		newZoo.animals.addAll(this.animals);
		newZoo.animals.retainAll(otherSet.animals);
		return newZoo;
	}
	
	/**
	 * Performs the Difference set operation on two sets
	 * @param otherSet
	 * @return
	 */
	public Sets removeAnimalsFrom(Sets otherSet) {
		Sets newZoo = new Sets();
		newZoo.animals.addAll(this.animals);
		newZoo.animals.removeAll(otherSet.animals);
		return newZoo;
	}
	
	/**
	 * Displays the animals of a current Zoo
	 * @param otherSet
	 * @return
	 */
	public void displayAnimals() {
		System.out.println(animals);
	}
	
	/**
	 * Performs the Complement set operation in regard to
	 * a universal set of animals
	 * @param otherSet
	 * @return
	 */
	public static  Sets animalsNotInZoo(Sets otherset) {
		Sets newZoo = new Sets();
		TreeSet<String> complement = new TreeSet<String>(UNIVERSAL_ZOO);
		complement.removeAll(otherset.animals);
		newZoo.animals.addAll(complement);
		return newZoo;
	}
	
	/**
	 * Performs the Symmetric Difference set operation on two sets
	 * @param otherSet
	 * @return
	 */
	public Sets animalsInEitherZoo(Sets otherset) {
		Sets newZoo = new Sets();
		TreeSet<String> union = new TreeSet<>(this.animals);
		TreeSet<String> intersection = new TreeSet<>(this.animals);
		
		union.addAll(otherset.animals);
		intersection.retainAll(otherset.animals);
		union.removeAll(intersection);
		newZoo.animals = union;
		return newZoo;
	}
	
	/**
	 * Returns a binary string representation of a set of animals
	 * in regard to a universal set of animals
	 * @param otherSet
	 * @return
	 */
	public static String toBitString(TreeSet<String> zoo) {
		StringBuilder bitString = new StringBuilder();
		
		for (String animal: UNIVERSAL_ZOO) {
			if (zoo.contains(animal)){
				bitString.append("1");
			} else {
				bitString.append("0");
			}
		}
		
		return bitString.toString();
	}
	
	/**
	 * Converts an an object of the Sets class to a TreeSet object
	 * @param otherSet
	 * @return
	 */
	public TreeSet<String> toTreeSet() {
		return new TreeSet<String>(this.animals);
	}
	
	
	/**
	 * Tests our set operation methods and returns a bit string representation
	 * in regard to a universal set 
	 * @param args
	 */
	public static void main(String[] args) {
		Sets exhibitA = new Sets();
		Sets exhibitB = new Sets();
		Sets newZoo1 = new Sets();
		
		System.out.println("TESTING UNION OPERATION");
		System.out.println("-----------------------");
		exhibitA.addAnimal("lion");
		exhibitA.addAnimal("elephant");
		exhibitA.addAnimal("penguin");
		exhibitA.addAnimal("kangaroo");
		exhibitB.addAnimal("tiger");
		exhibitB.addAnimal("elephant");
		exhibitB.addAnimal("gorilla");
		exhibitB.addAnimal("rhino");
		;
		System.out.println();
		newZoo1 = exhibitA.combineSets(exhibitB);
		System.out.println("Expected: [" + "elephant, " + "gorrila, " + "kangaroo, " + "lion, " + "penguin, "
		+ "rhino, " + "tiger]");
		System.out.print("Actual: ");
		newZoo1.displayAnimals();
		System.out.println("Bit String Representation: " + toBitString(newZoo1.toTreeSet()));
		System.out.println();
		
		System.out.println("TESTING INTERSECTION OPERATION");
		System.out.println("------------------------------");
		System.out.println();
		newZoo1 = exhibitA.keepOnlyCommon(exhibitB);
		System.out.println("Expected: " + "[elephant]" );
		System.out.print("Actual: ");
		newZoo1.displayAnimals();
		System.out.println("Bit String Representation: " + toBitString(newZoo1.toTreeSet()));
		System.out.println();
		
		System.out.println("TESTING DIFFERENCE OPERATION");
		System.out.println("----------------------------");
		System.out.println();
		newZoo1 = exhibitA.removeAnimalsFrom(exhibitB);
		System.out.println("Expected: " + "[Kangaroo, Lion, penguin]");
		System.out.print("Actual: ");
		newZoo1.displayAnimals();
		System.out.println("Bit String Representation: " + toBitString(newZoo1.toTreeSet()));
		System.out.println();
		
		System.out.println("TESTING SYMMENTRIC DIFFERENCE OPERATION");
		System.out.println("---------------------------------------");
		System.out.println();
		newZoo1 = exhibitA.animalsInEitherZoo(exhibitB);
		System.out.println("Expected: " + "[gorilla, " + "kangaroo, " + "lion, " + "penguin, " +
		"rhino, " + "tiger]");
		System.out.print("Actual: ");
		newZoo1.displayAnimals();
		System.out.println("Bit String Representation: " + toBitString(newZoo1.toTreeSet()));
		System.out.println();
		
		System.out.println("TESTING COMPLEMENT OPERATION");
		System.out.println("----------------------------");
		newZoo1 = animalsNotInZoo(exhibitA);
		System.out.println();
		System.out.println("Expected: " + "[giraffe, " + "gorilla, " +
		"hippo, " + "rhino, " + "tiger, " + "zebra]");
		System.out.print("Actual: ");
		newZoo1.displayAnimals();
		System.out.println("Bit String Representation: " + toBitString(newZoo1.toTreeSet()));
		System.out.println();
		
	}

}
