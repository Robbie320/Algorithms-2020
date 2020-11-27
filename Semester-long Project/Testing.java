public class Testing {
	public int test(Integer[] subjects, int start, int groupNumber, int groupSize) {
		int patient;
		int infectedNum = 0;
		for(int t = start; t < (start+groupSize); t++) {
			patient = subjects[t];
			if(patient == 1) { //if subject is infected
				infectedNum++;
			}
		}//end for t
		return infectedNum;
	}//end test
}//end class Testing
