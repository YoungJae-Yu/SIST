package javaexp.a13_io;

import java.io.File;

public class A05_DirFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 공통 경로
		String path = "C:\\Users\\user\\git\\web2\\javaexp\\src\\javaexp\\a13_io\\a01_fold\\";
		for(int cnt=1;cnt<=9;cnt++) {
			// 추가 경로 설정
			File f = new File(path+"a0"+cnt);
			f.mkdir();
		}
	}

}
