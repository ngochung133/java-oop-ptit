import java.util.*;

public class Rectangle {
    double width;
    double height;
    String color;

    // Constructor mặc định
    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    // Constructor có tham số
    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Getter width
    public double getWidth() {
        return this.width;
    }

    // Setter width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter height
    public double getHeight() {
        return this.height;
    }

    // Setter height
    public void setHeight(double height) {
        this.height = height;
    }

    // Getter color
    public String getColor() {
        return this.color;
    }

    // Setter color
    public void setColor(String color) {
        this.color = color;
    }

    // Tính diện tích
    public double findArea() {
        return this.width * this.height;
    }

    // Tính chu vi
    public double findPerimeter() {
        return (this.width + this.height) * 2;
    }

    // Chuẩn hóa màu
    public String chuanHoa() {
        this.color = this.color.substring(0, 1).toUpperCase()
                + this.color.substring(1).toLowerCase();

        return this.color;
    }

    // Kiểm tra hình chữ nhật hợp lệ
    public boolean check() {
        if (this.width <= 0 || this.height <= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double width = sc.nextDouble();
        double height = sc.nextDouble();
        String color = sc.next();

        Rectangle hcn = new Rectangle(width, height, color);

        if (hcn.check()) {
            System.out.println(
                hcn.findPerimeter() + " "
                + hcn.findArea() + " "
                + hcn.chuanHoa()
            );
        } else {
            System.out.println("INVALID");
        }

        sc.close();
    }
}