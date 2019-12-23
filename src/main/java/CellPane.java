import javax.swing.*;
import java.awt.*;

public class CellPane extends JPanel {
    public CellPane() {

    }

    public void setColor() {
        setBackground(Color.RED);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}