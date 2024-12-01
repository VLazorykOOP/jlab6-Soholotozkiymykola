import javax.swing.*;
import java.awt.*;

public class MovingBall extends JPanel {

    private int radius = 10; // Початковий радіус кулі
    private boolean expanding = true; // Чи збільшується куля

    public MovingBall() {
        Timer timer = new Timer(30, e -> {
            // Логіка зміни радіуса кулі
            if (expanding) {
                radius += 2;
                if (radius >= 100) {
                    expanding = false;
                }
            } else {
                radius -= 2;
                if (radius <= 10) {
                    expanding = true;
                }
            }
            repaint(); // Перемальовуємо фрейм
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Очищуємо фон
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Малюємо кулю
        g.setColor(Color.BLUE);
        int x = (getWidth() - radius * 2) / 2; // Центруємо кулю по X
        int y = (getHeight() - radius * 2) / 2; // Центруємо кулю по Y
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Наближається та віддаляється куля");
        MovingBall ballPanel = new MovingBall();

        // Налаштовуємо фрейм
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // Розмір вікна
        frame.setResizable(false); // Забороняємо змінювати розмір вікна
        frame.add(ballPanel);
        frame.setLocationRelativeTo(null); // Вікно посеред екрану
        frame.setVisible(true);
    }
}
