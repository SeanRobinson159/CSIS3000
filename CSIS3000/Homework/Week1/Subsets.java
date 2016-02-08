package Week1;

public class Subsets {

	public static void main(String[] args) {
		int N = 3;
		int totalSubsets = (int)Math.pow(2, N); //2^N subsets
		for (int i = 0; i < totalSubsets; i++)
		{
			System.out.print("{ ");
		    for (int j = 0; j < N; j++){
		        if ((i & (1 << j)) > 0)	//if it is not 0, grab the number
		           System.out.print((j + 1) + " ");
		    }
		    System.out.println("}");
		}
	}

}
