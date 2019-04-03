package deQuy;

import java.util.Stack;
import java.util.Arrays;

public class Recursive {

	// tinh n!
	public static int giaithua(int n) {

		if (n == 1)
			return 1;
		else
			return (n * giaithua(n - 1));
	}

	// tim uoc chung lon nhat giua a va b
	public static int exo2(int a, int b) {

		if (b == 0)
			return a;
		if (a == 0)
			return b;
		if (b > a)
			return exo2(a, b % a);
		return exo2(b, a % b);

	}

	// tim cac so nguyen to tu 0 den n
	public static void exo3(int n) {
		if (n == 1)
			return;
		if (est_premier(n, 2))
			System.out.print(n + ", ");
		exo3(n - 1);
	}

	public static boolean est_premier(int n, int i) {
		if (i == n)
			return true;
		if (n % i == 0)
			return false;
		return est_premier(n, i + 1);
	}

	// tinh S(n)
	public static int exo4(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return (exo4(n - 1) + giaithua(n));
	}

	// Reverse a stack
	public static void revert(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		else {
			Integer a = s.pop();
			revert(s);
			coller(s, a);
		}
	}

	private static void coller(Stack<Integer> s, Integer a) {
		if (s.isEmpty()) {
			s.push(a);
		} else {
			Integer o = s.pop();
			coller(s, a);
			s.push(o);
		}
	}

	// somme dans array
	public static int sommeArray(int[] a) {

		if (a.length == 0)
			return 0;
		else {
			return a[0] + sommeArray(Arrays.copyOfRange(a, 1, a.length));

		}
	}

	// bubble sort
	public static void sort(int[] a, int n) {
		if (n == 1)
			return;
		a = echange(a, n);
		sort(a, n - 1);
	}

	public static int[] echange(int a[], int n) {
		if (n == 0)
			return a;
		else {
			if (a[n] < a[n - 1]) {
				int b = a[n];
				a[n] = a[n - 1];
				a[n - 1] = b;
			}

		}
		return echange(a, n - 1);
	}

	// nguyen am

	public static int nguyenAm(String s) {
		if (s.length() == 0)
			return 0;
		else {
			if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o'
					|| s.charAt(0) == 'u' || s.charAt(0) == 'y') {
				// System.out.println(s.charAt(0));
				return 1 + nguyenAm(s.substring(1));
			} else
				return 0 + nguyenAm(s.substring(1));
		}
	}

	// binaire en decimal
	public static int biToDe(String nb) {
		if (nb.length() == 0)
			return 0;
		else {
			return Character.getNumericValue(nb.charAt(0)) * (int) Math.pow(2, nb.length() - 1)
					+ biToDe(nb.substring(1));
		}
	}

	// fibonacci
	public static int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibo(n - 1) + fibo(n - 2);

	}

	// subset Sum Pb
	public static boolean subSetSum(int tab[], int n, int som,boolean init) {
		if (som == 0) {
			if(init)			// pour eviter sil la valeur som au debut =0
				return false;
			return true;
		}
			
		if (som != 0 && n == 0)
			return false;

		return (subSetSum(tab, n - 1, som,false) || subSetSum(tab, n - 1, som - tab[n - 1],false));		//soit on passe a l'indice suivant soit on prendre cette valleur et diminue la somme 

	}

	// Tong cua chuoi 1^1+2^2+...+n^n
	public static int somChuoi(int n) {
		if (n == 0)
			return 0;
		return (int) Math.pow(n, n) + somChuoi(n - 1);
	}

	// dao nguoc 1 so nguyen
	public static int reverse(int n) {
		if (n == 0)			//si la longuer de cet entier ==0
			return n;
		return (n % 10) * (int) Math.pow(10, lengthInt(n) - 1) + reverse(n / 10);
	}

	// tinh so chu so cua 1 so nguyen
	public static int lengthInt(int n) {
		if (n == 0)
			return 0;
		return 1 + lengthInt(n / 10);
	}

	// T(x,n)=x^n
	public static int tinhT(int x, int n) {
		if (n == 0 || x == 1)
			return 1;
		if (x == 0 && n > 0)
			return 0;
		return x * tinhT(x, n - 1);
	}

	// P(n)=1.3.5...(2n+1)
	public static int tinhP(int n) {
		if (n == 0)
			return 1;
		return (2 * n + 1) * tinhP(n - 1);
	}

	// s(n)
	public static double tinhS(int n) {
		if (n == 0)
			return 0;
		return Math.sqrt(n + tinhS(n - 1));
	}

	public static void main(String[] args) {

		// ex1
		System.out.println("Q1: " + giaithua(5));

		// ex2
		System.out.println("Q2: " + exo2(5, 10));

		// ex3
		System.out.print("Q3: ");
		exo3(100);
		System.out.println();

		// ex4
		System.out.println("Q4: " + exo4(3));

		// ex5
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println("Q5: " + s);
		revert(s);
		System.out.println(s);

		// exo6
		int a6[] = { 1, 2, 5, 4 };
		System.out.println("Q6: " + sommeArray(a6));

		// exo7
		int a7[] = { 6, 4, 3, 5, 9, 8 };
		sort(a7, a7.length - 1);
		System.out.println("Q7: " + Arrays.toString(a7));

		// exo 8
		String s8 = "helolo ae";
		System.out.println("Q8: " + nguyenAm(s8));

		// exo9
		String bi = "1100";
		System.out.println("Q9: " + biToDe(bi));

		// exo10
		System.out.println("Q10: " + fibo(5));

		// exo11
		int tab[] = { -3, -7, 8, 5 };
		System.out.println("Q11: " + subSetSum(tab, tab.length, 3,true));

		// exo12
		System.out.println("Q12: " + somChuoi(3));

		// exo13
		System.out.println("Q13: " + reverse(12345));

		// exo14
		System.out.println("Q14: " + lengthInt(123));

		// exo15
		System.out.println("Q15: " + tinhT(3, 3));

		// exo16
		System.out.println("Q16: " + tinhP(3));

		// exo17
		System.out.println("Q17: " + tinhS(3));
	}
}
