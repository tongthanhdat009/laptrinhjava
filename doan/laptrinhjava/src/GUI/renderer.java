package GUI;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class renderer extends DefaultTableCellRenderer  {
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel imageLabel = new JLabel();
        if (value != null) {
            String imageUrl = value.toString();
            ImageIcon icon = new ImageIcon(imageUrl);
            // Đảm bảo rằng hình ảnh có kích thước được điều chỉnh và thiết lập nó cho JLabel
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        }
        return imageLabel;
    }
}
