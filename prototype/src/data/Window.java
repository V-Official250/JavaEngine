package data;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

public class Window {
    private int width;
    private int height;
    private String title;

    private long window;

    public Window(int p_width, int p_height, String p_title) {
        this.width = p_width;
        this.height = p_height;
        this.title = p_title;

        Init();
    }

    private void Init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("unable to load GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        window = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (window == NULL) {
            throw new IllegalStateException("unalbe t create GLFW Window");
        }

        glfwMakeContextCurrent(window);
        glfwSwapBuffers(window);
        glfwShowWindow(window);

        GL.createCapabilities();
        glEnable(GL_TEXTURE_2D);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, this.width, this.height, 0, -1, 1);
    }
    
    public void clear(float red,float green,float blue,float alpha) {
        glClear(GL_COLOR_BUFFER_BIT);
        glClearColor(red, green, blue, alpha);
    }
    
    public Boolean isClosed() {
        return glfwWindowShouldClose(window);
    }

    public void pollEvents() {
        glfwPollEvents();
    }
    
    public void update() {
        glMatrixMode(GL_MODELVIEW);
        glfwSwapBuffers(window);
    }

    public void makeCurrent() {
        glfwMakeContextCurrent(window);
    }
}