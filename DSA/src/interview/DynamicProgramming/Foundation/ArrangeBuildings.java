package interview.DynamicProgramming.Foundation;

public class ArrangeBuildings {

	public static void main(String[] args) {
		int n = 6; //Input 
		int building = 1; 
		int space = 1;
		for (int i = 2; i <= n; i++) {
			int new_building = space;
			int new_space = space + building;

			building = new_building;
			space = new_space;
		}
		int totalBuildings = building + space;
		int totalBuildings_BothSides = totalBuildings * totalBuildings;
		System.out.println(totalBuildings_BothSides);

	}

}
