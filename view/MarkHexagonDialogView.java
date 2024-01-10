package com.game.cryptid.view;

import com.game.cryptid.model.entity.Cube;
import com.game.cryptid.model.entity.Disc;
import com.game.cryptid.model.entity.PlayerToken;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 * This class design and implement the mark the hexagon dialog
 * window for user to mark a hexagon in map.
 */
public class MarkHexagonDialogView extends JDialog {

  /** PlayerToken marking the hexagon. */
  private String token;

  /**
   * Constructor that creates a new instance of class {@link MarkHexagonDialogView}.
   *
   * @param parent the parent JFrame of this dialog.
   */
  public MarkHexagonDialogView(JFrame parent) {
    super(parent, true);
    setLocationRelativeTo(parent);
    setSize(new Dimension(250, 150));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());
    JLabel msgLabel = new JLabel("Mark the Hexagon");
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    container.add(msgLabel, BorderLayout.CENTER);

    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p.setBorder(new EmptyBorder(5, 5, 5, 5));

    ImageIcon iconCube = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/com/game/cryptid/images/cube.png")));
    JButton btnCube = new JButton(iconCube);
    ImageIcon iconDisc = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/com/game/cryptid/images/disc.png")));
    Image originalImage = iconDisc.getImage();
    Image scaledImage = originalImage.getScaledInstance(iconCube.getIconWidth(), iconCube.getIconHeight(), Image.SCALE_SMOOTH);
    iconDisc = new ImageIcon(scaledImage);
    JButton btnDisc = new JButton(iconDisc);
    p.add(btnCube);
    p.add(btnDisc);
    btnCube.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        token = "cube";
        dispose();
      }
    });
    btnDisc.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        token = "disc";
        dispose();
      }
    });
    container.add(p, BorderLayout.SOUTH);
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
  }

  /**
   * Get the {@link PlayerToken} that was marked.
   *
   * @return the marking {@link PlayerToken}
   */
  public String getToken() {
    return token;
  }

}
