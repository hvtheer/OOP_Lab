package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "//Users//the//Documents//Lab_OOP//Lab03//OtherProjects//src//hust//soict//hedspi//garbage//test.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));

		startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (byte b : inputBytes) {
			sb.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}

