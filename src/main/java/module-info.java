module org.example.actividadfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens org.example.actividadfinal to javafx.fxml;
    exports org.example.actividadfinal;
}