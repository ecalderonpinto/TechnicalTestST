package com.stsc.controllers.service;

import org.springframework.stereotype.Service;

@Service
public class MaxIntegerService {

	/**
	 * Method that given three integers x, y and n find the maximum integer k such
	 * that 0 <= k <= n that k mod x = y.
	 * 
	 * @param x
	 * @param y
	 * @param n
	 * @return k (max integer <= n that k mod x = y)
	 */
	public Integer maxIntegerMod(Integer x, Integer y, Integer n) {

		Integer result = null;

		if (checkParams(x, y, n)) {
			for (int k = 0; k <= n; k++) {

				if (k % x == y) {
					result = k;
				}
			}
		}

		return result;
	}

	private boolean checkParams(Integer x, Integer y, Integer n) {

		boolean result = false;

		if (x != null && y != null && n != null)
			if (x >= 2 && x <= 1000000000)
				if (y >= 0 && y < x)
					if (n >= y && n <= 1000000000)
						result = true;

		return result;
	}

}
