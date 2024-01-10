package com.game.cryptid.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 * This class design and implement the Ask or Search dialog
 * window for user to select between Ask or Search.
 */
public class AskOrSearchDialogView extends JDialog implements ActionListener {

  /** button for ask. */
  private JButton btnAsk;

  /** button for search. */
  private JButton btnSearch;

  /** enum constant for choice. */
  public enum AskOrSearch { ASK, SEARCH }

  /** selection choice of Ask or Search. */
  private AskOrSearch askOrSearchChoice;

  /**
   * Class constructor that creates a new instance of class {@link AskOrSearchDialogView}.
   *
   * @param parent the parent JFrame of this dialog.
   */
  public AskOrSearchDialogView(JFrame parent) {
    super(parent, true);
    setLocationRelativeTo(parent);
    setSize(new Dimension(300, 150));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    initGui();
  }


  private void initGui() {
    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());
    JLabel msgLabel = new JLabel("Do you want to Ask or Search?");
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    container.add(msgLabel, BorderLayout.CENTER);
    JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    p.setBorder(new EmptyBorder(5, 5, 5, 5));
    btnAsk = new JButton("Ask");
    btnSearch = new JButton("Search");
    btnAsk.addActionListener(this);
    btnSearch.addActionListener(this);
    p.add(btnAsk);
    p.add(btnSearch);
    container.add(p, BorderLayout.SOUTH);
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
  }

  /**
   * Get the Ask or Search choice selected by user.
   *
   * @return ASK or SEARCH
   */
  public AskOrSearch getAskOrSearchChoice() {
    return askOrSearchChoice;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == btnAsk) {
      askOrSearchChoice = AskOrSearch.ASK;
    }
    if (src == btnSearch) {
      askOrSearchChoice = AskOrSearch.SEARCH;
    }
    this.dispose();
  }
}
