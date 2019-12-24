import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellPane extends JPanel {
    CellPane() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(AStar.makeBorder)
                    setBackground(Color.BLACK);
            }
        });
    }

    void setColor(Color c) {
        setBackground(c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}