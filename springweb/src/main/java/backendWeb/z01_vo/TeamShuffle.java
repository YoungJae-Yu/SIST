package backendWeb.z01_vo;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;



public class TeamShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = {"1","2","3","4","5"};
		List<String> teams= Arrays.asList(arr) ;
		Collections.shuffle(teams);
		for(int idx=0;idx<teams.size();idx++) {
			System.out.println(idx+1+ ")"+teams.get(idx)+"조");
		}
	}

}
