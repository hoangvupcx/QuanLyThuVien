module com.nguyenhoangvu.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nguyenhoangvu.quanlythuvien to javafx.fxml;
    exports com.nguyenhoangvu.quanlythuvien;
}
