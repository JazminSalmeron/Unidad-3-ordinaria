package utng.edu.mx.orders1.model;

/**
 * Created by danie on 23/02/2017.
 */

public class OrderHeader {
    private String idOrderHeader;
    private String idCustomer;
    private String idMethodPayment;
    private String date;

    public OrderHeader(String idOrderHeader, String idCustomer, String idMethodPayment, String date) {
        this.idOrderHeader = idOrderHeader;
        this.idCustomer = idCustomer;
        this.idMethodPayment = idMethodPayment;
        this.date = date;
    }

    public OrderHeader(){this("","","","");}

    public String getIdOrderHeader() {
        return idOrderHeader;
    }

    public void setIdOrderHeader(String idOrderHeader) {
        this.idOrderHeader = idOrderHeader;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdMethodPayment() {
        return idMethodPayment;
    }

    public void setIdMethodPayment(String idMethodPayment) {
        this.idMethodPayment = idMethodPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "idOrderHeader='" + idOrderHeader + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idMethodPayment='" + idMethodPayment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
