package javaexp.a06_memory;

public class A03_ArrayUsing {

	public static void main(String[] args) {
		/*		
		# 배열의 활용
		1. 배열은 선언과 동시에 원하는 데이터를 아래와 같이 할당할 수 있다		
		*/
		int arry[];
		arry = new int[] {1000,2000,3000};
		System.out.println("배열의 크기:"+arry.length);
		String arry2[] = {"사과","딸기","오렌지"};
//		new String[]을 생략할 수 있다.
		/*
		2. index가 같은 배열의 경우 연관관계로 반복문을 통해 출력할 수 있다.
		 */
		int[] bCnts = {3,5,2};
		for(int idx=0;idx<arry.length;idx++) {
			System.out.print(idx+1+") ");
			System.out.print(arry2[idx]+"\t");
			System.out.print(arry[idx]+"\t");
			System.out.print(bCnts[idx]+"\n");
		}
//		한국시리즈 팀순위 검색하여
//		구단과 승률을 배열로 선언할당하고,
//		반복문을 통하여 리스트 처리하세요
		String[] teams = {"KIA타이거즈","키움히어로즈","SSG랜더스 "};
		double[] records = {0.694,0.608,0.560};
		for(int idx=0;idx<teams.length;idx++) {
			System.out.print(idx+1+"위\t");
			System.out.print(teams[idx]+"\t");
			System.out.print(records[idx]+"\n");
		}	
	}

}
