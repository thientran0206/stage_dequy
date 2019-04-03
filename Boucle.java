package deQuy;

import java.util.Arrays;
import java.util.Stack;

public class Boucle {

	static int giaiThua(int n) {
		int s = 1;
		for (int i = 1; i <= n; i++)
			s = s * i;
		return s;
	}

	// uoc chung lon nhat
	static int ucln(int a, int b) {

		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	// cac so nguyen tu 0 toi n
	static void soNguyen(int n) {
		int est_premier = 0;
		if (n < 2)
			return;

		for (int i = 2; i < n; i++) {
			for (int j = 2; j <= i - 1; j++) {
				if (i % j == 0) {
					est_premier = 1;
				}
			}
			if (est_premier == 0)
				System.out.print(i + ", ");
			est_premier = 0;
		}
	}

	// S(n) = 1 + 1.2 + 1.2.3 + .... + 1.2.3....n
	static int exo4(int n) {
		int s = 0;
		for (int i = 1; i <= n; i++)
			s = s + giaiThua(i);
		return s;
	}

	// Reverse a stack
	public static Stack<Integer> revert(Stack<Integer> s) {
		Stack<Integer> reverse = new Stack<Integer>();
		while (!s.isEmpty()) {

			reverse.addElement(s.pop());	//ajouter l'element qui est enlevé par s
		}
		return reverse;
	}

	// tong cac phan tu trong array
	public static int sommeArray(int tab[]) {
		int somme = 0;
		for (int i = 0; i < tab.length; i++)
			somme += tab[i];
		return somme;
	}

	// buble sort
	public static void sort(int a[]) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (a[j - 1] > a[j]) {
					int b = a[j - 1];
					a[j - 1] = a[j];
					a[j] = b;
				}
			}
		}
	}

	// dem nguyen am
	public static int nguyenAm(String s) {
		int nb = 0;

		for (int i = 0; i < s.length(); i++) {			//parcourir la chaine s'il y a une voyelle nb++
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'y') {
				nb++;
			}
		}
		return nb;
	}

	// binaire to decimal
	public static int biToDe(String s) {
		int nb = 0;
		for (int i = 0; i < s.length(); i++) {
			nb = nb + Character.getNumericValue(s.charAt(i)) * (int) Math.pow(2, s.length() - (i + 1));    //i*2^(length-1)
		}
		return nb;
	}

	// fibinacci
	static int fibo(int n) {
		int s = 0;
		int a = 0, b = 1;
		for (int i = 2; i < n; i++) {
			s = a + b;
			a = b;
			b = s;
		}
		return s;
	}

	// subset sum pb
	public static boolean subSetSum(int tab[], int n, int som) {
		boolean subset[][] = new boolean[som + 1][n + 1];	// crée un tableau 2 dim. col: tous les valeurs de 0 a som,ligne: tous les valeurs de 0 a n
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;          // le tableau est vrai si la col est 0
		for (int i = 1; i <= som; i++)
			subset[i][0] = false;		// si n=0 mais somme !=0	faux
		for (int i = 1; i <= som; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];	
				if (i >= tab[j - 1])			//si la somme > la valeur dans table tab a l'indice j-1
					subset[i][j] = subset[i][j] || subset[i - tab[j - 1]][j - 1]; 	// soit subset[i][j] est vrai soit on doit diminuer la somme
			}
		}
		return subset[som][n];
	}

	// Tong cua chuoi 1^1+2^2+...+n^n
	public static int somChuoi(int n) {
		int somme = 0;
		for (int i = 1; i <= n; i++) {
			somme = somme + (int) Math.pow(i, i);
		}
		return somme;
	}

	// dao nguoc 1 so nguyen
	public static int reverse(int n) {
		int nb = 0;
		while (n != 0) {

			nb = nb + (n % 10) * (int) Math.pow(10, compter(n) - 1);			// prendre le dernier chiffre et multiplie par la 10^(n-1)
			n = n / 10;			//diminuer la longguer d'un entier pour prendre le dernier chiffre qui suite

		}
		return nb;
	}

	// trong chu so cua 1 so nguyen
	public static int compter(int n) {
		int count = 0;
		while (n != 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	// tinh T(x,n)=x^n
	public static int tinhT(int x, int n) {
		int t = 1;
		if (n == 0 || x == 1)
			return 1;
		if (x == 0 && n > 0)
			return 0;
		for (int i = 1; i <= n; i++) {
			t = t * x;
		}
		return t;
	}

	// P(n)=1.3.5...(2n+1)
	private static int tinhP(int n) {
		int s = 1;
		for (int i = 1; i <= n; i++) {
			s = s * (2 * i + 1);
		}
		return s;
	}

	// tinh S(n)
	private static double tinhS(int n) {
		double p = 0;
		for (int i = 1; i <= n; i++) {
			p = Math.sqrt(p) + i;
		}
		return Math.sqrt(p);
	}

	public static void main(String[] args) {

		// ex1
		System.out.println("Q1: " + giaiThua(5));

		// ex2
		System.out.println("Q2: " + ucln(10, 4));

		// ex3
		System.out.print("Q3: ");
		soNguyen(100);
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
		s = revert(s);
		System.out.println(s);

		// exo6
		int a6[] = { 1, 2, 5, 4 };
		System.out.println("Q6: " + sommeArray(a6));

		// exo7
		int a7[] = { 6, 4, 3, 5, 9, 8 };
		sort(a7);
		System.out.println("Q7: " + Arrays.toString(a7));

		// exo 8
		String s8 = "helolo ae";
		System.out.println("Q8: " + nguyenAm(s8));

		// exo9
		String bi = "11010";
		System.out.println("Q9: " + biToDe(bi));

		// exo10
		System.out.println("Q10: " + fibo(5));

		// exo 11
		int tab[] = { 3, 7, 6, 5, 2 };
		System.out.println("Q11: " + subSetSum(tab, tab.length, 6));

		// exo12
		System.out.println("Q12: " + somChuoi(3));

		// exo13
		System.out.println("Q13: " + reverse(12345));

		// exo14
		System.out.println("Q14: " + compter(123));

		// exo15
		System.out.println("Q15: " + tinhT(3, 3));

		// exo16
		System.out.println("Q16: " + tinhP(3));

		// exo17
		System.out.println("Q17: " + tinhS(3));
	}

}
