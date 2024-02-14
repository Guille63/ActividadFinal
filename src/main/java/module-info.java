module org.example.actividadfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.actividadfinal to javafx.fxml;
    exports org.example.actividadfinal;
}