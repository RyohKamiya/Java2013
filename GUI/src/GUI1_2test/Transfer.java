package GUI1_2test;

import java.awt.Color;
import java.awt.Font;

public class Transfer {
        private Font font;
        private int fontSize;
        private Color charColor;
        private Color bgColor;

        private int height;
        private int width;

        public Transfer() {
                this.font = new Font("arial", Font.BOLD, 50);
                this.fontSize = 50;
                this.charColor = Color.BLACK;
                this.bgColor = Color.WHITE;
                this.height = 50;
                this.width = 200;
        }

        public Font getFont() {
                return font;
        }
        public void setFont(Font font) {
                this.font = font;
        }
        public int getFontSize() {
                return fontSize;
        }
        public void setFontSize(int fontSize) {
                this.fontSize = fontSize;
        }
        public Color getCharColor() {
                return charColor;
        }
        public void setCharColor(Color charColor) {
                this.charColor = charColor;
        }
        public Color getBgColor() {
                return bgColor;
        }
        public void setBgColor(Color bgColor) {
                this.bgColor = bgColor;
        }
        public void setWidthAndHeight(int fontSize){
                this.height = fontSize;
                this.width = this.height * 4;
        }
        public int getWidth() {
                return this.width;
        }
        public int getHeight() {
                return this.height;
        }
}
