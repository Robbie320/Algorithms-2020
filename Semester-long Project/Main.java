import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.lang.Integer.parseInt;

public class Main {
	public static void main(String[] args) {
		Scanner totalPop = new Scanner(System.in);
		Random random = new Random();
		Testing testing = new Testing();
		
		//Get input for Total Population Size
		System.out.print("sim "); //Run the simulation
		final int totalPopSize = Integer.parseInt(totalPop.nextLine());
		//Initialize array to hold total population
		Integer[] totalPopulation = new Integer[totalPopSize]; //check if group is infected
		
		//Make testing groups
		int groupNum = (int)Math.ceil(totalPopulation.length/8);
		int groupSize = 8;
		Integer[] subjects = new Integer[totalPopSize];
		int totalInfected = 0;
		double infectionRate = 0.02;
		double uninfectedRate = 0.98;
		double myInfectionRate = 0.00;
		double myUninfectedRate = 0.00;
		
		//Initialize
		for(int i= 0; i < totalPopSize; i++) {
			subjects[i] = 0;
		}
		
		//Populate subjects array
		for(int g = 0; g < totalPopSize; g++) {
			//Is patient infected or not
			int patient = random.nextInt(100);
			if(patient <= 2) {//infection rate
				patient = 1;//infected
				totalInfected++;
			} else if(patient >= 3 && patient < 100) {
				patient = 0;// not infected
			}//end if
			//Add patient to group
			subjects[g] = patient;
		}//end for
		
		//print out groups
		for(int p = 0; p < totalPopSize; p++) {
			if(p % 8 == 0) {
				System.out.println("\n----------------");
			}
			System.out.print(subjects[p] + " ");
		}//end for n
		
		//Test groups in search of infected person denoted by 1
		int infectedNum = 0;
		int totTestNum = 0;
		
		int myCaseOne = 0;
		int caseOneTestNum = 0;
		
		int myCaseTwo = 0;
		int caseTwoTestNum = 0;
		
		int myCaseThree = 0;
		int caseThreeTestNum = 0;
		
		for(int start = 0; start < totalPopSize; start+=groupSize) {
			infectedNum = testing.test(subjects, start, groupNum, groupSize); //test that group number
			if(infectedNum == 0) {
				myCaseOne += 1;
				caseOneTestNum++;
				totTestNum += 1;
			} else if(infectedNum == 1) {
				myCaseTwo++;
				caseTwoTestNum +=7;
				totTestNum += 7;
			} else if(infectedNum >= 2) {
				myCaseThree++;
				caseThreeTestNum += 11;
				totTestNum += 11;
			}else {
				System.out.println("I don't know, something went wrong.");
			}
		}//end for y
		
		//MY RESULTS//
		System.out.println("\n");
		System.out.println("My Results:");
		System.out.printf("Case (1): " + groupNum + " x 0.8500" + " = " + myCaseOne + " instances requiring " + caseOneTestNum + " tests (there are no partial tests)\n");
		System.out.printf("Case (2): " + groupNum + " x 0.1496" + " =  " + myCaseTwo + " instances requiring " + caseTwoTestNum + " tests\n");
		System.out.printf("Case (3): " + groupNum + " x 0.0004" + " =   " + myCaseThree + " round up to 1 instance requiring " + caseThreeTestNum + " tests");
		
		//EXPECTED RESULT VALUES//
		myInfectionRate = (double)totalInfected/(double)totalPopSize;
		myUninfectedRate = ((double)totalPopSize-(double)totalInfected)/(double)totalPopSize;
		//System.out.println(myInfectionRate + " " + myUninfectedRate); //check my infection rate and uninfected rate
		
		//Handle Case 1 Numbers
		double caseOne = Math.pow(myUninfectedRate, groupSize);
		String caseOneStr = String.format("%.4f", caseOne);
		caseOne = Double.valueOf(caseOneStr);
		double caseOneAns = groupNum * caseOne;
		String caseOneStrAns = String.format("%.2f", caseOneAns);
		caseOneAns = Double.valueOf(caseOneStrAns);
		
		//Handle Case 3 Numbers
		double caseThree = Math.pow(myInfectionRate, 2);
		String caseThreeStr = String.format("%.4f", caseThree);
		caseThree = Double.valueOf(caseThreeStr);
		double caseThreeAns = groupNum * caseThree;
		String caseThreeStrAns = String.format("%.2f", caseThreeAns);
		//caseThreeStr = df2.format(caseThreeAns);
		caseThreeAns = Double.valueOf(caseThreeStrAns);
		
		//Handle Case 2 Numbers
		double caseTwo = 1 - (caseOne + caseThree);
		String caseTwoStr = String.format("%.4f", caseTwo);
		caseTwo = Double.valueOf(caseTwoStr);
		double caseTwoAns = groupNum * caseTwo;
		String caseTwoStrAns = String.format("%.2f", caseTwoAns);
		caseTwoAns = Double.valueOf(caseTwoStrAns);
		
		//Print out Case Output
		System.out.println("\n");
		System.out.println("Expected Results Based on Simulation:");
		System.out.printf("Case (1): " + groupNum + " x " + caseOneStr + " = " + caseOneStrAns + " instances requiring 107 tests (there are no partial tests)\n");
		System.out.printf("Case (2): " + groupNum + " x " + caseTwoStr + " =  " + caseTwoStrAns + " instances requiring 131 tests\n");
		System.out.printf("Case (3): " + groupNum + " x " + caseThreeStr + " =   " + caseThreeStrAns + " round up to 1 instance requiring 11 tests");
	}//end main
}//end Main Class
