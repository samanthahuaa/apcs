public class Student {
	private String name;
	private int charms;
	private int potions;
	private int herbology;
	private int GPA;
	public Student() {
		name="Joe";
		charms = 98;
		potions = 65;
		herbology = 89;
	}

	public Student(String student, int c, int p, int h) {
		name = student;
		charms = c;
		potions = p;
		herbology = h;
	}

	public static void main (String[] args) {
		printStudentInfo();
		calcGPA();
		printStudentInfo();
		setCharms(100);
		printStudentInfo();

		bob = new Student("bob", 50,75,100);
		bob.calcGPA();
		bob.printStudentInfo();
		bob.setCharms(25);
		bob.calcGPA();
		bob.printStudentInfo();
	}

	public int setCharms (int updated) {
		int old = charms;
		charms = updated;
		return old;
	}

	public int calcGPA() {
		int average = (charms+potions+herbology)/3.0;
		GPA = average;
		return GPA;
	}

	public void printStudentInfo() {
		//not part of the exam question but needed for testing
		System.out.println(name);
		System.out.println(charms);
		System.out.println(potions);
		System.out.println(herbology);
		System.out.println(GPA);
	}
}
