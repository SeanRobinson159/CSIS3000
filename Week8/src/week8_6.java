import java.util.ArrayList;
import java.util.Scanner;


public class week8_6 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter n");
		int n = input.nextInt();
		input.close();
		ArrayList<Integer> permutations = new ArrayList<Integer>();
		while(permutations.size() != n){
			int i = (int)(Math.random()*n)+1;
			if(!permutations.contains(i)){
				permutations.add(i);
			}
		}
	System.out.println(permutations);
	}
}
