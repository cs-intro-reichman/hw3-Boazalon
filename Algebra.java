// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, -4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, -3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		if (x2 < 0) {

			for (int i = 0; i > x2; i--) {
				sum--;

			}
			return sum;
		}

		for (int i = 0; i < x2; i++) {
			sum++;

		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;

		if (x2 < 0) {

			for (int i = 0; i > x2; i--) {
				sum++;

			}
			return sum;
		}

		for (int i = 0; i < x2; i++) {
			sum--;

		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int sum = 0;

		if (x1 >= 0) {
			if (x2 < 0) {

				for (int i = 0; i > x2; i--) {
					sum = minus(sum, x1);
				}
				return sum;
			}

			for (int i = 0; i < x2; i++) {
				sum = plus(sum, x1);
			}
		} else {
			if (x2 < 0) {
				for (int i = 0; i > x2; i--) {
					sum = minus(sum, x1);
				}
				return sum;
			}

			for (int i = 0; i < x2; i++) {
				sum = plus(sum, x1);
			}
		}

		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		if (n == 0) {
			return 1;
		}

		int sum = x;

		for (int i = 1; i < n; i++) {
			sum = times(sum, x);

		}

		return sum;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int sum = 0;
		boolean n1 = false;
		boolean n2 = false;

		
		if (x2 < 0) {
			x2 = times(x2, -1);
			n2 = true;
		}
		if (x1 < 0) {
			x1 = times(x1, -1);
			n1 = true;
		}

		for (int i = 0; i < x1; i++) {
			sum++;
			if (times(sum, x2) + x2 > x1) {
				break;
			}
		}
		if ((n1 == true && n2 == false) || (n2 == true && n1 == false)) {
			return (times(sum, -1));
		}  
			return sum;

		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1 - times(div(x1, x2), x2);
		return sum;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		// Replace the following statement with your code
		if (x == 1) {
			return 1;

		}
		double epsilon = 0.01;
		double g = x / 2;
		while (Math.abs(g * g - x) > epsilon) {
			g = g - (g * g - x) / (2 * g);
		}
		int intg = (int) g;
		return intg;
	}
}