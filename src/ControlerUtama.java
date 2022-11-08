import java.awt.event.ActionEvent;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControlerUtama {

    @FXML
    private TableView<ToDoModel> ColomnAll;

    @FXML
    private TableColumn<ToDoModel, String> columBarang;

    @FXML
    private TableColumn<ToDoModel, Integer> columId;

    @FXML
    private TableColumn<ToDoModel, Integer> columnHarga;

    @FXML
    private TableColumn<ToDoModel, String> columnJenis;

    @FXML
    private TableColumn<ToDoModel, Integer> columnStock;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldId;

    @FXML
    private TextField fieldJenis;

    @FXML
    private TextField fieldNama;

    @FXML
    private TextField fieldStok;

    private ObservableList<ToDoModel> ToDoData = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        columId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        columBarang.setCellValueFactory(cellData -> cellData.getValue().getNamaProperty());
        columnJenis.setCellValueFactory(cellData -> cellData.getValue().getJenisProperty());
        columnStock.setCellValueFactory(cellData -> cellData.getValue().getStokProperty().asObject());
        columnHarga.setCellValueFactory(cellData -> cellData.getValue().getHargaProperty().asObject());
    }

    public ControlerUtama() throws Exception {
        readDB();
    }

    public void readDB() throws Exception {
        String db = "select * from books";
        try (var stmt = conectorDB.con().prepareStatement(db)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nama = rs.getString(2);
                String jenis = rs.getString(3);
                int stok = rs.getInt(4);
                int harga = rs.getInt(5);
                ToDoData.add(new ToDoModel(id, nama, jenis, stok, harga));
            }
            stmt.close();
        }
    }

    public void setData() {
        ColomnAll.setItems(ToDoData);
    }

    @FXML
    public void BtnInsert() throws Exception {
        String db = "insert into books (id,nama,jenis,stok,harga) values (?,?,?,?,?)";
        PreparedStatement stmt = conectorDB.con().prepareStatement(db);

        stmt.setString(1, fieldId.getText());
        stmt.setString(2, fieldNama.getText());
        stmt.setString(3, fieldJenis.getText());
        stmt.setString(4, fieldStok.getText());
        stmt.setString(5, fieldHarga.getText());
        stmt.executeUpdate();
        stmt.close();// menghentikan stmt atau keluar dari database
        // System.out.println("adsasd");

        fieldId.clear();
        fieldNama.clear();
        fieldJenis.clear();
        fieldStok.clear();
        fieldHarga.clear();

        ColomnAll.getItems().clear();// digunakan untuk refresh table
        readDB();
    }

    @FXML
    void BtnEdit() throws Exception {

        String db = "UPDATE books set stok=? where id=? ";
        PreparedStatement stmt = conectorDB.con().prepareStatement(db);

        stmt.setString(2, fieldId.getText());
        stmt.setString(1, fieldStok.getText());

        fieldId.clear();
        fieldStok.clear();

        stmt.executeUpdate();
        stmt.close();
        ColomnAll.getItems().clear();// digunakan untuk refresh table
        readDB();

        // System.out.println("ada");
    }

    @FXML
    void BtnDelete() throws Exception {

        String db = "delete FROM books where id=?";
        PreparedStatement stmt = conectorDB.con().prepareStatement(db);

        stmt.setString(1, fieldId.getText());
        stmt.executeUpdate();

        fieldId.clear();
        ColomnAll.getItems().clear();// digunakan untuk refresh table
        readDB();

        // System.out.println("coba");
    }

}
