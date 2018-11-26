package com.javacreed.examples.crypto;

import java.io.BufferedInputStream;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Formatter;

public class Example {
  public static void main(final String[] args) throws Exception {

    final URL link = new URL("http://www.javacreed.com/");
    try (DigestInputStream in = new DigestInputStream(new BufferedInputStream(link.openStream()),
                                                      MessageDigest.getInstance("SHA-1"))) {
      // Read the stream and do nothing with it
      while (in.read() != -1) {}

      // Get the digest and finialise the computation
      final MessageDigest md = in.getMessageDigest();
      final byte[] digest = md.digest();

      // Format as HEX
      try (Formatter formatter = new Formatter()) {
        for (final byte b : digest) {
          formatter.format("%02x", b);
        }

        final String sha1 = formatter.toString();
        System.out.println(sha1);
      }
    }
  }
}
