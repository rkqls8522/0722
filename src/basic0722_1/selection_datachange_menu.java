//데이터 추가, 삭제, 변환, 읽기, 끝내기 등 사용자에게 받은 입력에 따라 함수를 수행. 끝내기를 하기 전까지 계속 반복.
// 1) listAdd : 추가
// 2) listDel : 삭제
// 3) listChange : 값 변환
// 4) listSearch : 값 찾기
// 5) 원하는 만큼만 보기
// 6) 끝내기

package basic0722_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class selection_datachange_menu {
	
	public static void list_Q(List<String> list) {
		
		System.out.println("\n1 ~ 6 중에서 번호를 입력하세요.\n"
				+ "1. 추가 데이터 삽입\n"
				+ "2. 데이터 삭제\n"
				+ "3. 데이터 값 변환\n"
				+ "4. 원하는 값 찾기\n"
				+ "5. 원하는 양 만큼의 데이터만 보기\n"
				+ "6. 끝내기\n");
		System.out.print("실행할 번호 입력 : ");
		
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		
		System.out.println("-----------------------------");

		switch(num) {
		case 1: listAdd(list);break;
		case 2: listDel(list);break;
		case 3: listChange(list);break;
		case 4: listSearch(list);break;
		case 5: listSee(list);break;
		case 6: System.out.println("안녕히 가십시오.");break;
		default: System.out.println("다시 입력하세요.");	list_Q(list);break;
		}
		
		if(num != 6) {
		list_A(list);
		System.out.println("\n더 원하시는 일이 있습니까?");
		list_Q(list);
		}
		 
	}
	
	public static void list_A(List<String> list) {

		System.out.println("\n리스트 값입니다.");
		System.out.println(list);
		
	}
	
	public static void listAdd(List<String> list) {
		
		System.out.println("더할 문자열을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		list.add(sc.nextLine());
		 
	}
	
	public static void listDel(List<String> list) {
		
		System.out.println("삭제할 문자열을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr)) {
				sum ++;
			}
		}
		if(sum == 0)
			System.out.println("해당 데이터가 없습니다.");
		else {
			System.out.println(searchStr + " : " + sum + "개 있습니다.");
			
			int delete_data_number = 1;
			if(sum > 1) {
				System.out.println(sum + "개 중에서 몇 개를 삭제할까요?");
				delete_data_number = sc.nextInt();
			}
			if(delete_data_number > sum||delete_data_number <1)
				System.out.println("잘못 입력하셨습니다.");
			else {
				sum = 0;
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(searchStr)) {
						list.remove(i);
						i--;
						sum++;
						if(delete_data_number == sum)
							break;
					}
				}
			}
		}
	}
	
	public static void listChange(List<String> list) {
		
		System.out.println("변환할 문자열을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();

		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr))
				sum ++;
		}
		if(sum == 0)
			System.out.println(searchStr + " : 없습니다.");
		else{
			System.out.println(searchStr + " : " + sum + "개 있습니다.");
			System.out.println(searchStr + "를 무엇으로 바꾸시겠습니까?");
			String ChangeStr = sc.nextLine();
			
			int change_data_number = 1;
			if(sum > 1) {
				System.out.println(sum + "개 중에서 몇 개를 변환할까요?");
				change_data_number = sc.nextInt();
			}
			if(change_data_number > sum||change_data_number <1)
				System.out.println("잘못 입력하셨습니다.");
			else {
				sum = 0;
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(searchStr)) {
						list.remove(i);
						list.add(i, ChangeStr);
						sum++;
						if(change_data_number == sum)
							break;
					}
				}
			}
		}
	}
	
	public static void listSearch(List<String> list) {
		
		System.out.println("찾으시는 문자열을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr))
				sum ++;
		}
		if(sum == 0)
			System.out.println(searchStr + " : 없습니다.");
		else{
			System.out.println(searchStr + " : " + sum + "개 있습니다.");
		}
			
	}
	
	public static void listSee(List<String> list) {
		
		System.out.println("몇 번째 데이터부터 보시겠습니까?");
		Scanner sc = new Scanner(System.in);
		int data_num = sc.nextInt();
		
		System.out.println("몇 개의 데이터를 보시겠습니까?");
		int see_num = sc.nextInt();

		System.out.println(list.size());
		target : for(int i = 0; i < see_num; i++) {
			
			if(data_num + i>= list.size()) {
				System.out.println("입력하신 값이 범위를 넘어갔습니다.");
				break target;
			}
			else {
				System.out.println(list.get(data_num+i));
			}
		}
	}
	

	public static void main(String[] args) {
		
		
		String a = "dkdk";
		ArrayList<String> list = new ArrayList<String>();
		list.add(a+"  "+a);
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add("바");
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add("바");
		
		list_A(list);
		list_Q(list);
		
		
		
	}
	
	
	
	
}

