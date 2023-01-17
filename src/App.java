import java.util.Scanner;

import exercicioFeefo.services.NormalizerService;

public class App {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		/*
		 * User input
		 */
		System.out.print("Enter with your job position: ");
		String jobTitle = scn.nextLine();
		NormalizerService n = new NormalizerService();
		String normalizedJob = n.matchStrings(jobTitle);

		System.out.print("Normalized title: " + normalizedJob);

		scn.close();

	}
}