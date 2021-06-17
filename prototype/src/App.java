import data.Window;
import data.Renderer;
import data.Texture;

public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window(800,600,"prototype");
        Texture tex = new Texture("./res/grid.png");

        while (!window.isClosed()) {
            window.pollEvents();
            window.clear(0.0f, 0.0f, 0.0f, 1.0f);

            tex.bind();
            Renderer.image(100.0f, 100.0f, 200.0f, 200.0f);

            window.update();
        }
    }
}