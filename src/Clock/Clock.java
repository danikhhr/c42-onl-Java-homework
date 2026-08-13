package Clock;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Clock extends JFrame {

    private JLabel dateLabel;
    private JLabel timeLabel;
    private DateTimeFormatter timeFormatter;
    private DateTimeFormatter dateFormatter;
    private String time;
    private String date;

    public Clock() {
        this.setSize(500, 400);
        this.setTitle("Clock");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 65));
        timeLabel.setForeground(new Color(0xFF00FF));
        timeLabel.setBackground(new Color(0x0D0D0D));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x00FFFF), 2),
                BorderFactory.createEmptyBorder(15, 30, 15, 30)
        ));

        dateFormatter = DateTimeFormatter.ofPattern("EEE");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        dateLabel.setForeground(new Color(0x00FF41));
        dateLabel.setBackground(new Color(0x0D0D0D));
        dateLabel.setOpaque(true);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x00FF41), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        this.add(timeLabel);
        this.add(dateLabel);

        setDateTime();
    }

    private void setDateTime() {
        while(true) {
            time = timeFormatter.format(LocalDateTime.now());
            timeLabel.setText(time);

            date = dateFormatter.format(LocalDateTime.now());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
