import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		/*
		 * List of normalized job titles
		 */
		ArrayList<String> jobs = new ArrayList<String>();
		jobs.add("Architect");
		jobs.add("Software engineer");
		jobs.add("Accountant");
		jobs.add("Quantity surveyor");

		/*
		 * User input
		 */
		System.out.print("Enter with your job position: ");
		String jobTitle = scn.nextLine();
		String normalizedJob = matchStrings(jobTitle, jobs);

		System.out.print("Normalized title: " + normalizedJob);

		scn.close();

	}

	/**/
	public static String matchStrings(String jt, ArrayList<String> jobs) {
		String n = null;
		Integer param = Integer.MAX_VALUE;
		for (String job : jobs) {
			int value = calculateDistanceStrings(jt, job);
			if (value < param) {
				param = value;
				n = job;
			}
		}

		return n;
	}

	/*
	 * method to calculate de distance between 2 strings if the both of strings are
	 * empty the distance will become 0 if one of the strings are empty de distance
	 * is the length of other string
	 */
	public static int calculateDistanceStrings(String x, String y) {
		int[][] dp = new int[x.length() + 1][y.length() + 1];

		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
							dp[i - 1][j] + 1,
							dp[i][j - 1] + 1);
				}
			}
		}

		return dp[x.length()][y.length()];
	}

	public static int costOfSubstitution(char a, char b) {
		return a == b ? 0 : 1;
	}

	public static int min(int... numbers) {
		return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
	}
}