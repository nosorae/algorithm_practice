package sort;
import java.util.*;

public class Sort_Custom {

	public static void main(String[] args) {
		Student[] arr = new Student[10];
		arr[0] = new Student(3, "sdf");
		arr[1] = new Student(5, "asdf");
		arr[2] = new Student(7, "csdf");
		arr[3] = new Student(7, "bsdf");
		arr[4] = new Student(7, "asdf");
		arr[5] = new Student(3, "asdf");
		arr[6] = new Student(2, "asdf");
		arr[7] = new Student(1, "zsdf");
		arr[8] = new Student(2, "zsdf");
		arr[9] = new Student(3, "asdf");
		//sort(arr, 0, 9);
		Arrays.sort(arr, new StudentComp());
		
		
		for(Student s : arr) {
			System.out.println(s.id +" "+s.name);
		}
		

	}
	void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
	
	// 5 1 2 [3] 4 6 2
	static void sort(Student[] a, int left, int right){
        int pl = left;
        int pr = right;
        Student x = a[(pl+pr)/2];

        do{
            while(a[pl].compareTo(x) == -1) pl++;
            while(compare(a[pr], x) == 1) pr--;
            if(pl <= pr){
                Student temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
	
	
	public static int compare(Student a, Student b) {
		if(a.id > b.id)
			return 1;
		else if(a.id == b.id)
			return a.name.compareTo(b.name);
		else
			return -1;
	}
}
class StudentComp implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.id > o2.id)
			return 1;
		else if(o1.id == o2.id)
			return o1.name.compareTo(o2.name);
		else
			return -1;
	}
}

class Student {
	int id;
	String name;
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int compareTo(Student b) {
		if(this.id > b.id)
			return 1;
		else if(this.id == b.id)
			return this.name.compareTo(b.name);
		else
			return -1;
	}

}
