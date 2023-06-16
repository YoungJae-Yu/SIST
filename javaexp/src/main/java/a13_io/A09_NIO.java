package javaexp.a13_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A09_NIO {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# IO를 보다 효과적으로 처리하는 nio 패키지의 파일 관리 객체
		1. Path
			1) 파일객체 생성. Paths.get("파일명")
			2) 정보 가져오기.
				getFileName()
				getParent()
				getNameCount()
			3) 파일객체로 전환 처리
				toFile()
		2. Files
			1) 파일 삭제
				Files.delete(Path객체)
		
		 */
		String path1 = "C:\\Users\\user\\git\\-\\javaexp\\src\\javaexp\\a13_io\\";
		String fname1 = path1 + "z05_data.txt";
		File f01 = new File(fname1);
		try {
			if (!f01.exists())
					f01.createNewFile();
			// 새로운 파일을 처리하는 객체..
			Path filPath = Paths.get(fname1);
			File f02 = filPath.toFile();
			System.out.println(f02.getName());
			System.out.println(f02.getPath());
			System.out.println(f02.exists());
			System.out.println(f02.length());
			// ex) File객체를 f03으로 z06_data.txt로 만들고,
			//		이름 Path에 의해 객체로 만들었다가
			//		다시 f04를 참조값으로 하는 파일 객체로 만들고
			//		파일 정보와 경로 정보를 가져오세요.
			File f03 = new File(path1,"z06_data.txt");
			if(!f03.exists())f03.createNewFile();
			Path filPath2 = Paths.get(path1+"z06_data.txt");
			File f04 = filPath2.toFile();
			System.out.println(f04.getName());
			System.out.println(f04.getPath());
			// 파일 삭제 처리
			Files.delete(filPath2);
			// 복사할 원복 파일 : filPath
			// 복사할 대상 파일 : copPath
			Path copPath = Paths.get(path1+"z10_data.txt");
			// 복사처리
			Files.copy(filPath,  copPath, StandardCopyOption.REPLACE_EXISTING);
			//ex) 현재 폴드 하위에, a10_fold 폴드를 만들고,
			//		그 하위에 z10_data.txt를 복사한
			//		a01_data.txt ~ a09_data.txt를 만드세요.
			File newFold = new File(path1,"a10_fold");
			newFold.mkdir();
			for(int cnt=1;cnt<=9;cnt++) {
				Path newPath = Paths.get(path1+"a10_fold\\a0"+cnt+"_data.txt");
				Files.copy(copPath, newPath, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
