package Shaders;

import Entities.Camera;
import ToolBox.Maths;
import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/shaders/vertexShader.glsl";
    private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.glsl";

    private static int location_transformationMatrix;
    private static int location_projectionMatrix;
    private static int location_viewMatrix;


    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
        location_viewMatrix = super.getUniformLocation("viewMatrix");
    }

    public void loadViewMatrix(Camera camera) {
        super.loadMatrix(location_viewMatrix, Maths.createViewMatrix(camera));
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(location_transformationMatrix, matrix);
    }

    public void loadProjectionMatrix(Matrix4f matrix) {
        super.loadMatrix(location_projectionMatrix, matrix);
    }
}
