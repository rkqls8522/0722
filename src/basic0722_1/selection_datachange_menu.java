//������ �߰�, ����, ��ȯ, �б�, ������ �� ����ڿ��� ���� �Է¿� ���� �Լ��� ����. �����⸦ �ϱ� ������ ��� �ݺ�.
// 1) listAdd : �߰�
// 2) listDel : ����
// 3) listChange : �� ��ȯ
// 4) listSearch : �� ã��
// 5) ���ϴ� ��ŭ�� ����
// 6) ������

package basic0722_1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class selection_datachange_menu {
	
	public static void list_Q(List<String> list) {
		
		System.out.println("\n1 ~ 6 �߿��� ��ȣ�� �Է��ϼ���.\n"
				+ "1. �߰� ������ ����\n"
				+ "2. ������ ����\n"
				+ "3. ������ �� ��ȯ\n"
				+ "4. ���ϴ� �� ã��\n"
				+ "5. ���ϴ� �� ��ŭ�� �����͸� ����\n"
				+ "6. ������\n");
		System.out.print("������ ��ȣ �Է� : ");
		
		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		
		System.out.println("-----------------------------");

		switch(num) {
		case 1: listAdd(list);break;
		case 2: listDel(list);break;
		case 3: listChange(list);break;
		case 4: listSearch(list);break;
		case 5: listSee(list);break;
		case 6: System.out.println("�ȳ��� ���ʽÿ�.");break;
		default: System.out.println("�ٽ� �Է��ϼ���.");	list_Q(list);break;
		}
		
		if(num != 6) {
		list_A(list);
		System.out.println("\n�� ���Ͻô� ���� �ֽ��ϱ�?");
		list_Q(list);
		}
		 
	}
	
	public static void list_A(List<String> list) {

		System.out.println("\n����Ʈ ���Դϴ�.");
		System.out.println(list);
		
	}
	
	public static void listAdd(List<String> list) {
		
		System.out.println("���� ���ڿ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		list.add(sc.nextLine());
		 
	}
	
	public static void listDel(List<String> list) {
		
		System.out.println("������ ���ڿ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr)) {
				sum ++;
			}
		}
		if(sum == 0)
			System.out.println("�ش� �����Ͱ� �����ϴ�.");
		else {
			System.out.println(searchStr + " : " + sum + "�� �ֽ��ϴ�.");
			
			int delete_data_number = 1;
			if(sum > 1) {
				System.out.println(sum + "�� �߿��� �� ���� �����ұ��?");
				delete_data_number = sc.nextInt();
			}
			if(delete_data_number > sum||delete_data_number <1)
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
		
		System.out.println("��ȯ�� ���ڿ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();

		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr))
				sum ++;
		}
		if(sum == 0)
			System.out.println(searchStr + " : �����ϴ�.");
		else{
			System.out.println(searchStr + " : " + sum + "�� �ֽ��ϴ�.");
			System.out.println(searchStr + "�� �������� �ٲٽðڽ��ϱ�?");
			String ChangeStr = sc.nextLine();
			
			int change_data_number = 1;
			if(sum > 1) {
				System.out.println(sum + "�� �߿��� �� ���� ��ȯ�ұ��?");
				change_data_number = sc.nextInt();
			}
			if(change_data_number > sum||change_data_number <1)
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
		
		System.out.println("ã���ô� ���ڿ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String searchStr = sc.nextLine();
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(searchStr))
				sum ++;
		}
		if(sum == 0)
			System.out.println(searchStr + " : �����ϴ�.");
		else{
			System.out.println(searchStr + " : " + sum + "�� �ֽ��ϴ�.");
		}
			
	}
	
	public static void listSee(List<String> list) {
		
		System.out.println("�� ��° �����ͺ��� ���ðڽ��ϱ�?");
		Scanner sc = new Scanner(System.in);
		int data_num = sc.nextInt();
		
		System.out.println("�� ���� �����͸� ���ðڽ��ϱ�?");
		int see_num = sc.nextInt();

		System.out.println(list.size());
		target : for(int i = 0; i < see_num; i++) {
			
			if(data_num + i>= list.size()) {
				System.out.println("�Է��Ͻ� ���� ������ �Ѿ���ϴ�.");
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
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		
		list_A(list);
		list_Q(list);
		
		
		
	}
	
	
	
	
}

