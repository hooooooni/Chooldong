package chooldong.frame;

import chooldong.component.ChooldongImgLabel;
import chooldong.component.ChooldongBtn;
import chooldong.request.Request;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListWindowFrame extends ChooldongFrame{
    public String token;
    public JList<String> cl;
    public ChooldongBtn btnOne;
    public ChooldongBtn btnTwo;
    public JPanel btnPanel;
    protected ChooldongImgLabel middleLabel;
    protected JLabel upperLabel;
    protected JLabel lowerLabel;
    protected JPanel middlePanel;

    public ListWindowFrame(String[] listArray, String token) {
        this.cp.setLayout(new GridLayout());
        this.token = token;

        this.cl = new JList<>();
        cl.setListData(listArray);
        this.cp.add(cl);

        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(new GridLayout(2,1));
        this.cp.add(btnPanel);

        this.btnOne = new ChooldongBtn("출석");
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnOneClicked();
            }
        });
        this.btnTwo = new ChooldongBtn("조회");
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnTwoClicked();
            }
        });
        this.btnPanel.add(btnOne);
        this.btnPanel.add(btnTwo);
        btnOne.setEnabled(false);
        btnTwo.setEnabled(false);

        JLabel gridFilerLabel = new JLabel();
        this.cp.add(gridFilerLabel);
        cl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                onValueChanged();
            }
        });

        // middle panel
        this.middlePanel = new JPanel();
        this.middlePanel.setLayout(new GridLayout(3,1));
        this.middlePanel.setOpaque(false);
        this.middlePanel.setVisible(true);

        // upper
        this.upperLabel = new JLabel();
        this.upperLabel.setHorizontalAlignment(JLabel.CENTER);


        // middle
        this.middleLabel = new ChooldongImgLabel();
//        SimpleAttributeSet attribs = new SimpleAttributeSet();
//        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
//        this.middleLabel.setParagraphAttributes(attribs, true);
//        this.middleLabel.setOpaque(false);

        // lower
        this.lowerLabel = new JLabel();

        this.middlePanel.add(this.upperLabel);
        this.middlePanel.add(this.middleLabel);
        this.middlePanel.add(this.lowerLabel);

        this.cp.add(middlePanel);
        this.cp.add(new JLabel());

        this.setDefault();
    }

    protected void setBtnEnable() {
            btnOne.setEnabled(true);
            btnTwo.setEnabled(true);
    }

    public void onValueChanged() {
        setBtnEnable();
    }

    public void onBtnOneClicked() {
    }

    public void onBtnTwoClicked() {
    }

}
