package com.puke.getter.input;

import com.puke.getter.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


/**
 * @author zijiao
 * @version 16/9/30
 */
public class SwingFactory implements InputFactory, Input {

    @Override
    public Input createInput() {
        return this;
    }

    @Override
    public void pull(final Getter getter) {
        SwingUtilities.invokeLater(() -> new SwingInputImpl(getter));
    }

    private static class SwingInputImpl extends JFrame {

        private static final int CELL_HEIGHT = 65;
        private static final int WINDOW_WIDTH = 400;

        private JPanel contentPanel;
        private GridBagLayout layout;
        private Getter getter;
        private List<Form> forms = new ArrayList<>();

        private interface Form {
            boolean pass();
        }

        SwingInputImpl(Getter getter) {
            this.getter = getter;
            initLayout();
        }

        //提交表单
        private void commit() {
            for (Form form : forms) {
                if (!form.pass()) {
                    return;
                }
            }
            dispose();
            if (getter.callback != null) {
                getter.callback.onResult(null);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void fillComponent() {
            List<Getter> getters = new ArrayList<>();
            if (getter instanceof GetterGroup) {
                getters.addAll(((GetterGroup) getter).getters);
            } else {
                getters.add(getter);
            }

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;
            constraints.gridwidth = 0;
            final int size = getters.size();
            setSize(WINDOW_WIDTH, size * CELL_HEIGHT + 100);
            for (int i = 0; i < size; i++) {
                Component component = getPanel(i, getters.get(i));
                component.setPreferredSize(new Dimension(getWidth(), CELL_HEIGHT));
                contentPanel.add(component);
                layout.setConstraints(component, constraints);
            }
        }

        private void initLayout() {
            setResizable(false);
//            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setTitle("输入信息");
            setBackground(Color.WHITE);

            contentPanel = new JPanel();
            contentPanel.setLayout(layout = new GridBagLayout());
            JScrollPane scrollPane = new JScrollPane(contentPanel);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBar(null);
            add(scrollPane, BorderLayout.CENTER);

            JPanel operation = new JPanel();
            operation.setPreferredSize(new Dimension(getWidth(), CELL_HEIGHT));
            operation.setLayout(new GridLayout(1, 2));
            JButton cancel = new JButton("取消");
//            cancel.addActionListener(e -> dispose());
            cancel.addActionListener(e -> System.exit(0));
            operation.add(cancel);
            JButton ok = new JButton("确定");
            ok.addActionListener(e -> {
                commit();
            });
            operation.add(ok);
            add(operation, BorderLayout.SOUTH);

            fillComponent();
            setLocationRelativeTo(getOwner());
            setVisible(true);
        }

        private JPanel getPanel(int i, Getter getter) {
            JPanel panel = new JPanel();
            GridBagLayout layout = new GridBagLayout();
            panel.setLayout(layout);
            panel.setBackground(i % 2 == 0 ? Color.WHITE : Color.decode("#efefef"));
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.BOTH;

            JLabel name = new JLabel(getter.name);
            panel.add(name);
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            layout.setConstraints(name, constraints);

            final JTextField input = new JTextField();
            final JLabel errorInfo = new JLabel();
            panel.add(input);
            constraints.gridwidth = 0;
            constraints.weightx = 1;
            layout.setConstraints(input, constraints);
            input.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    getter.result = input.getText().trim();
                    String error = Validators.validate(getter);
                    if (error == null) {
                        errorInfo.setText("");
                        getter.callback.onResult(getter.result);
                    } else {
                        errorInfo.setText(error);
                    }
                }
            });

            JLabel description = new JLabel(getter.description);
            panel.add(description);
            constraints.gridwidth = 0;
            constraints.weightx = 1;
            layout.setConstraints(description, constraints);

            errorInfo.setForeground(Color.RED);
            panel.add(errorInfo);
            constraints.gridwidth = 0;
            constraints.weightx = 1;
            layout.setConstraints(errorInfo, constraints);

            forms.add(() -> {
                getter.result = input.getText().trim();
                String error = Validators.validate(getter);
                if (error == null) {
                    getter.callback.onResult(getter.result);
                    errorInfo.setText("");
                    return true;
                } else {
                    errorInfo.setText(error);
                    return false;
                }
            });

            return panel;
        }

        public static void show(String s) {
            JOptionPane.showMessageDialog(null, s);
        }

    }

}
