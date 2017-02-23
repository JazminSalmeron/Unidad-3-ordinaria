package utng.edu.mx.orders1.model;

/**
 * Created by danie on 23/02/2017.
 */

public class Quote {
    private  String idQuote;
    private String text;
    private String meaning;

    public Quote(String idQuote, String text, String meaning) {
        this.idQuote = idQuote;
        this.text = text;
        this.meaning = meaning;
    }
    public Quote(){this("","","");
    }

    public String getIdQuote() {
        return idQuote;
    }

    public void setIdQuote(String idQuote) {
        this.idQuote = idQuote;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }


    @Override
    public String toString() {
        return "Quote{" +
                "idQuote='" + idQuote + '\'' +
                ", text='" + text + '\'' +
                ", meaning=" + meaning +
                '}';
    }
}
