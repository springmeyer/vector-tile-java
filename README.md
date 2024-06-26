# vector-tile-java

A Java library for efficient reading of Mapbox Vector Tiles.

This libraries is modeled after these high-performance Javascript libraries:

- https://github.com/mapbox/vector-tile-js
- https://github.com/mapbox/pbf

## Usage

This library has no external dependencies.

Use it as follows:

```java
    // Where `buf` is a `byte[]` representing an uncompressed Mapbox Vector Tile
    Pbf pbf = new Pbf(buf);
    VectorTile vectorTile = new VectorTile(pbf, pbf.length);
    for (VectorTileLayer layer : vectorTile.layers.values()) {
      System.out.println("Layer: " + layer.name);
      for (int i = 0; i < layer.length; i++) {
        VectorTileFeature feature = layer.feature(i);
        System.out.println("Feature: " + feature.id);
        System.out.println("Properties: " + feature.properties);
        System.out.println("Type: " + VectorTileFeature.types[feature.type]);
        System.out.println("Geometry: " + feature.loadGeometry());
      }
    }
```

## Developing

Run the tests as follows:

```bash
gradle test
```
