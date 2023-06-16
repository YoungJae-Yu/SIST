package javaexp.a12_collection;

public class A00_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 컬랙션 프레임워크
		1. 컬렉션 : 사전적 의미로 요소(객체)를 수집해 저장하는 것
		2. 배열의 문제점
			1) 저장할 수 있는 객체 수가 배열을 생성할 때 결정
				==> 불특정 다수의 객체를 저장하는 문제
			2) 객체 삭제했을 때, 객체를 저장하는 문제 발생
				==> 삭제하면 낱알 빠진 옥수수 처럼 해당 내용만null로 처리된다.
				==> 추가하지 못하는 단점
			3) 객체들을 효율적으로 동적으로 추가, 삭제, 검색할 수 있음
			4) 인터페이스를 통해서 정형화된 방법으로 다양한 컬렉션 클래스 사용 및 확장성 있게 활용가능.
				ex) List<Person> plist = new ArrayList<Person>();
			# 컬렉션 프레임워크의 주요 인터페이스
			1. 인터페이스와 실제 객체들
				1) *List - ArrayList, Vector, LinkedList
					인터페이스를 상속받아서 사용자 정의 실제 클래스를 정의가 가능하다.
				2) Set - HashSet, TreeSet
				3) *Map - HashMap, Hashtable, TreeMap, Propertie
			2. 인터페이스별 주요 특징
				1) List : 순서를 유지하고 저장 중복 저장 가능
				2) Set : 순서를 유지하지 않고 저장 중복저장 불가능
				3) Map : 키와 값의 쌍으로 저장 키는 중복 저장 안됨.
		 */
	}

}
