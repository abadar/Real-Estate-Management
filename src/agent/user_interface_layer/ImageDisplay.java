package agent.user_interface_layer;

import agent.business_logic_layer.ImageObj;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class ImageDisplay {

    JFrame f;
    JPanel panelCenter;
    ImageObj ImageObj1;
    String imgFile = "CBF.png";  //image link

    public ImageDisplay(String link) {
        imgFile = link;
        createImage();
    }

    //This function creates the Image GUI.
    void createImage() {
        f = new JFrame("Property Image");
        f.setSize(350, 250);
        Container contTopFrame = f.getContentPane();

        JPanel panelCenter = new JPanel();
        ImageObj1 = new ImageObj(imgFile);

        panelCenter.add(ImageObj1);
        contTopFrame.add(panelCenter, BorderLayout.CENTER);

        f.setSize(800, 600);
        f.pack();
        f.setVisible(true);
    } //CreateImage() ends here
}
