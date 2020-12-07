public class Testing {
	public boolean test(Integer[] subjects, int start, int groupSize) {
		int patient;
		int infectedNum = 0;
		int stop = start+groupSize;
		
		if(stop > subjects.length) {
			stop = subjects.length;
		}
		for(int t = start; t < stop; t++) {
			patient = subjects[t];
			if(patient == 1) { //if subject is infected
				return true; //even if one person is infected, whole group needs retesting
			}
		}//end for t
		return false;
	}//end test
}//end class Testing
