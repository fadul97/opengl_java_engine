import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main {

    public static void main(String[] args) {

        if(!glfwInit())
            System.out.println("Failed to initialize GLFW.");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        // Create glfwWindow object
        long glfwWindow = glfwCreateWindow(800, 600, "LearnOpenGL Java Engine", NULL, NULL);

        if(glfwWindow == NULL){
            System.out.println("Failed to create glfwWindow.");
            glfwTerminate();
        }

        glfwMakeContextCurrent(glfwWindow);
        glfwShowWindow(glfwWindow);

        // Init glad(?)
        GL.createCapabilities();

        while (!glfwWindowShouldClose(glfwWindow)){
            glfwPollEvents();

            glClearColor(0.0f, 0.6f, 1.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);
        }

        glfwTerminate();
    }
}
