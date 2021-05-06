package com.VTI.backend;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.VTI.ultis.ScannerUltis;

public class Exercise2 {
	private static Scanner sc;
	public void question1() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào số phần tử của mảng");
		int n = ScannerUltis.inputInt2();
		float[] arr = new float[n];
		System.out.println("Nhập các phần tử của mảng");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = sc.nextFloat();
		}
		Map<Float, Float> map = new TreeMap<Float, Float>();
		for (int i = 0; i < n; i++) {
			addElement(map, arr[i]);
		}
		System.out.println("Các phần tử xuất hiện 1 lần: ");
		for (float key : map.keySet()) {
			if (map.get(key) == 1) {
				System.out.println(key + "");
			}
		}
	}
	private void addElement(Map<Float, Float> map, float f) {
		if (map.containsKey(f)) {
			float count = map.get(f) + 1;
			map.put(f, count);
		}else {
			map.put(f, (float) 1);
		}		
	}
	public void question2() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào số phần tử của mảng");
		int n = ScannerUltis.inputInt2();
		float[] arr = new float[n];
		System.out.println("Nhập các phần tử của mảng");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = sc.nextFloat();
		}
		Map<Float, Float> map = new TreeMap<Float, Float>();
		for (int i = 0; i < n; i++) {
			addElement(map, arr[i]);
		}
		System.out.println("Các phần tử xuất hiện 2 lần: ");
		for (float key : map.keySet()) {
			if (map.get(key) == 2) {
				System.out.println(key + "");
			}
		}
	}
	public void question3() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào số phần tử của mảng");
		int n = ScannerUltis.inputInt2();
		float[] arr = new float[n];
		System.out.println("Nhập các phần tử của mảng");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = sc.nextFloat();
		}
		Map<Float, Float> map = new TreeMap<Float, Float>();
		for (int i = 0; i < n; i++) {
			addElement(map, arr[i]);
		}
		System.out.println("Số lần xuất hiện của các phần tử: ");
		for (float key : map.keySet()) {
				System.out.printf("%d xuất hiện %d lần.\n", key, map.get(key));
			
		}
	}
	public void question4() {
		sc = new Scanner(System.in);
		System.out.println("Mời nhập vào số phần tử của mảng");
		int n = ScannerUltis.inputInt2();
		int [] arr = new int[n];
		System.out.println("Nhập vào các phần tử của mảng");
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = sc.nextInt();		
			
		}		
	}
}
