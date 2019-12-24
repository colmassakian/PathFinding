import javax.swing.*;
import java.awt.*;

public class CellPane extends JPanel {
    CellPane() {

    }

    void setColor(Color c) {
        setBackground(c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}