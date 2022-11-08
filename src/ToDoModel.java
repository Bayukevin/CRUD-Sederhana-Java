import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ToDoModel {
    private IntegerProperty id;
    private StringProperty nama;
    private StringProperty jenis;
    private IntegerProperty stok;
    private IntegerProperty harga;

    public ToDoModel(int id, String nama, String jenis, int stok, int harga) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.jenis = new SimpleStringProperty(jenis);
        this.stok = new SimpleIntegerProperty(stok);
        this.harga = new SimpleIntegerProperty(harga);
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public StringProperty getJenisProperty() {
        return jenis;
    }

    public IntegerProperty getStokProperty() {
        return stok;
    }

    public IntegerProperty getHargaProperty() {
        return harga;
    }

}
