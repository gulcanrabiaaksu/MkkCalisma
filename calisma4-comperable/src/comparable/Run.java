package comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Run {

	
	/*
	 * Bildirimi: public interface Comparable<T> Bu arayuz kendisini kullanan her sinifin nnesneleri üzerine bir siralama kurar. Bu siralamaya sinifin dogal siralamasi denir.
	 * compareTo() metoduna dogal siralama metodu denir.
	 * Bu arayuzu kurgulayan listeler ve arrayler sirasiyla Collections.sort()ve Arrays. sort()
	 * Comparable arayuzunun metodu int compareTo(T o)
	 * Verilen nesneyi parametredeki nesne ile mukayese eder.
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<People> arr= new ArrayList <People>();
		
		People p1=new People("Ali",42);
		People p2=new People("Arda", 56);
		People p3=new People("Mehmet", 62);
		People p4=new People("Serkan",23);
		People p5=new People("Kemal",14);
		
		arr.add(p1);
		arr.add(p2);
		arr.add(p3);
		arr.add(p4);
		arr.add(p5);
		
		System.out.println("Before sorting:" + arr.toString());
		
		Collections.sort(arr);
		
		System.out.println("After sorting:" + arr.toString());
		
		
		
	}

}
