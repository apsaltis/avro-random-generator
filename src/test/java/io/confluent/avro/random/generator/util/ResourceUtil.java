package io.confluent.avro.random.generator.util;

import io.confluent.avro.random.generator.GeneratorTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


public final class ResourceUtil {

  private ResourceUtil() {
  }

  /**
   * Load file contents from classpath as string.
   * @param filePath the relative resource path.
   * @return the file contents.
   */
  public static String loadContent(final String filePath) {
    final InputStream testDir =
        GeneratorTest.class.getClassLoader().getResourceAsStream(filePath);

    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(testDir, StandardCharsets.UTF_8))) {

      return reader.lines().collect(Collectors.joining("\n"));
    } catch (final IOException ioe) {
      throw new RuntimeException("failed to find test test-schema " + filePath, ioe);
    }
  }
}
