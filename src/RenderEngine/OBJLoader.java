package RenderEngine;

import Models.RawModel;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class OBJLoader {

    public static RawModel loadOBJModel(String fileName, Loader loader) {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("res/" + fileName + ".obj"));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't load file.");
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(fr);
        String line;
        List<Vector3f> vertices = new ArrayList<>();
        List<Vector2f> textures = new ArrayList<>();
        List<Vector3f> normals = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        float[] verticesArray = null;
        float[] texturesArray = null;
        float[] normalsArray = null;
        float[] indicesArray = null;
        try {
            while (true) {
                line = reader.readLine();
                String[] currentLine = line.split(" ");
                if (line.startsWith("v ")) {
                    Vector3f vertex = new Vector3f
                            (Float.parseFloat(currentLine[1]),
                                    Float.parseFloat(currentLine[2]),
                                    Float.parseFloat(currentLine[3]));
                    vertices.add(vertex);
                } else if (line.startsWith("vt ")) {
                    Vector2f texture = new Vector2f
                            (Float.parseFloat(currentLine[1]),
                                    Float.parseFloat(currentLine[2]));
                    textures.add(texture);
                } else if (line.startsWith("vn ")) {
                    Vector3f normal = new Vector3f
                            (Float.parseFloat(currentLine[1]),
                                    Float.parseFloat(currentLine[2]),
                                    Float.parseFloat(currentLine[3]));
                    normals.add(normal);
                } else if (line.startsWith("f ")) {
                    verticesArray = new float[vertices.size() * 3];
                    texturesArray = new float[textures.size() * 2];
                    normalsArray = new float[normals.size() * 3];
                    break;
                }
            }

            while (line != null) {
                if (!line.startsWith("f ")) {
                    line = reader.readLine();
                    continue;
                }
                String[] currentLine = line.split(" ");
                String[] vertex1 = currentLine[1].split("/");
                String[] vertex2 = currentLine[2].split("/");
                String[] vertex3 = currentLine[3].split("/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processVertex(String[] vertexData, List<Integ>)
}
