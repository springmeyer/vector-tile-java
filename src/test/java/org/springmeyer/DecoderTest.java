package org.springmeyer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

public class DecoderTest {
  @Test
  public void decode() throws IOException {
    Path fixturesDir = Path.of("./fixtures");
    Files.walk(fixturesDir)
        .filter(
            path ->
                Files.isRegularFile(path)
                    && (path.toString().endsWith(".mvt") || path.toString().endsWith(".pbf")))
        .forEach(this::parseFile);
  }

  private void parseFile(Path filePath) {
    try {
      System.err.println("Parsing file: " + filePath);
      byte[] buf = Files.readAllBytes(filePath);
      Pbf pbf = new Pbf(buf);
      VectorTile vectorTile = new VectorTile(pbf, pbf.length);
      for (VectorTileLayer layer : vectorTile.layers.values()) {
        System.out.println("Layer: " + layer.name);
        for (int i = 0; i < layer.length; i++) {
          VectorTileFeature feature = layer.feature(i);
          feature.loadGeometry();
          // System.out.println("  Feature: " + feature.id);
          // System.out.println("    Properties: " + feature.properties);
          // System.out.println("    Type: " + VectorTileFeature.types[feature.type]);
          // System.out.println("Geometry: " + feature.loadGeometry());
        }
      }
    } catch (IOException e) {
      System.err.println("Failed to parse file: " + filePath);
      e.printStackTrace();
    }
  }
}
