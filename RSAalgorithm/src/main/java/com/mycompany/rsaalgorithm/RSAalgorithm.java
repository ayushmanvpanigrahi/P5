package com.mycompany.rsaalgorithm;

import java.math.*;
import java.util.*;

public class RSAalgorithm {

    public static void main(String[] args) {
        int p, q, n, phi, d = 0, e, i;
        int msg = 10;
        double c;
        BigInteger msgback;
        p = 7;
        q = 17;
        n = p * q;
        phi = (p - 1) * (q - 1);
        System.out.println("The value of z = " + phi);
        for (e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) {
                break;
            }
        }
        System.out.println("The value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * phi);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : " + msgback);
    }

    static int gcd(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return gcd(z % e, e);
        }
    }
}