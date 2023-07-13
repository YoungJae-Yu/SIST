package backendWeb.a01_dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import backendWeb.z01_vo.Emp;
import backendWeb.z01_vo.Person;

public class Z01_UtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		// 객체 ==> json데이터 변환
		Person p01 = new Person("홍길동",25,"서울");
		String jsonData = gson.toJson(p01);
		System.out.println(jsonData);
		A04_PreparedDao dao = new A04_PreparedDao();
		List<Emp> empList = dao.getEmpList();
		System.out.println(gson.toJson(empList));

		List<String> teams = Arrays.asList(new String[]{"1조","2조","3조","4조","5조"});
		Collections.shuffle(teams);
		for(int idx=0;idx<teams.size();idx++) {
			System.out.println(idx+1+") "+teams.get(idx));
			
		}
		
	}

}
