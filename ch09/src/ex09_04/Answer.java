package ex09_04;

public class Answer {

	/*
	 *3 << 2L - 1											:o, int, 6
	 *(3L << 2) - 1											:o, long, 11
	 *10 < 12 == 6 > 17										:x
	 *10 << 12 == 6 >> 17									:x
	 *13.5e-1 % Float.POSITIVE_INFINITY						:o, double, 13.5e-1
	 *Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY	:o, double, NaN
	 *Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY	:o, double, Double.POSITIVE_INFINITY
	 *0.0 / -0.0 == -0.0 / 0.0								:x
	 *Integer.MAX_VALUE + Integer.MIN_VALUE					:o, int, -1
	 *Long.MAX_VALUE + 5									:o, long, - (2 ^ 63 - 4)
	 *(short)5 * (byte)10									:o, int, 50
	 *i < 15 ? 1.72e3f : 0									:o, float, 1.72e3f
	 *i++ + i++ + --i										:o, int, 11
	 */
}
