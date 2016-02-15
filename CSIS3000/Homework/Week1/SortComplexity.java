package Week1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SortComplexity {
	public static void main(String[] args) {
		ArrayList<String[]> textList = new ArrayList<String[]>();
		textList.add(fileToStringArray("./51187-0.txt"));	//72 kb
		textList.add(fileToStringArray("./51199-0.txt"));	//189 kb
		textList.add(fileToStringArray("./51200-0.txt"));	//213 kb
		textList.add(fileToStringArray("./51197-0.txt"));	//329 kb
		textList.add(fileToStringArray("./51196-0.txt"));	//540 kb
		textList.add(fileToStringArray("./51191-0.txt"));	//997 kb

		System.out.println("Insertion Sort on 6 different texts");
		for (String[] text : textList) {
			long startTime = System.currentTimeMillis();
			insertionSort(text);
			long endTime = System.currentTimeMillis();
			System.out.println("Time to complete = " + (endTime - startTime) + "ms");
		}

		System.out.println("Heap Sort on 6 different texts");
		for (String[] text : textList) {
			long startTime = System.currentTimeMillis();
			heapSort(text);
			long endTime = System.currentTimeMillis();
			System.out.println("Time to complete = " + (endTime - startTime) + "ms");
		}

	}

	public static void insertionSort(String[] textArray) {
		String key;
		int i;

		for (int j = 1; j < textArray.length; j++) {
			key = textArray[j];
			i = j - 1;
			while (i >= 0 && textArray[i].compareTo(key) > 0) {
				textArray[i + 1] = textArray[i];
				i = i - 1;
			}
			textArray[i + 1] = key;
		}
	}

	public static void heapSort(Comparable[] pq) {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			sink(pq, k, N);
		while (N > 1) {
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(pq, j, j + 1))
				j++;
			if (!less(pq, k, j))
				break;
			exch(pq, k, j);
			k = j;
		}
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static String[] fileToStringArray(String filePath) {
		String stringArray[] = null;
		try {
			String str = new String(Files.readAllBytes(Paths.get(filePath)));
			stringArray = str.split("\\s+"); // Splits on all whitespace
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return stringArray;
		}
		return stringArray;
	}
}