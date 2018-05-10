import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the node");
		Scanner scan = new Scanner(System.in);

		int[][] matrix = new int[5][5];
		int[] distance = new int[5];
		int[] visited = new int[5];
		int[] preD = new int[5];
		int min;
		int nextNode = 0;

		for (int i = 0; i < 5; i++) {
			visited[i] = 0;
			preD[i] = 0;
			for (int j = 0; j < 5; j++) {
				matrix[i][j] = scan.nextInt();

				if (matrix[i][j] == 0) {
					matrix[i][j] = 999;
				}
			}

		}

		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;

		for (int i = 0; i < 5; i++) {
			min = 999;
			for (int j = 0; j < 5; j++) {
				if (min < distance[j] && visited[j] == 1) {
					min = distance[j];

				}
			}
		}
	}

}
