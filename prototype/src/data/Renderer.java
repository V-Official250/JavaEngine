package data;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    public static void rect(float x, float y, float width, float height) {
        glBegin(GL_QUADS);

        glVertex2f(x ,y);
        glVertex2f(x+width ,y);
        glVertex2f(x+width ,y+height);
        glVertex2f(x ,y+height);

        glEnd();
    }

    public static void image(float x, float y, float width, float height) {
        glBegin(GL_QUADS);

        glVertex2f(x ,y);
        glTexCoord2f(0, 0);

        glVertex2f(x+width ,y);
        glTexCoord2f(1, 0);

        glVertex2f(x+width ,y+height);
        glTexCoord2f(1, 1);

        glVertex2f(x ,y+height);
        glTexCoord2f(0, 1);

        glEnd();
    }
}
