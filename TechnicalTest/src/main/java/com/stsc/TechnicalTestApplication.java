package com.stsc;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stsc.controllers.service.MaxIntegerService;

@SpringBootApplication
public class TechnicalTestApplication {

	public static void main(String[] args) throws IOException {

		MaxIntegerService maxIntegerService = new MaxIntegerService();
		
		Scanner shell = new Scanner(System.in);
		
		if (args != null && args.length == 1) {
			int iterations = Integer.parseInt(args[0]);
			if (iterations >= 1 && iterations <= 50000) {
				for (int i = 0; i < iterations; i++) {
					int x = shell.nextInt();
					int y = shell.nextInt();
					int n = shell.nextInt();
					System.out.println(maxIntegerService.maxIntegerMod(x, y, n));
				}
			}
		} else
			SpringApplication.run(TechnicalTestApplication.class, args);
	}

}
