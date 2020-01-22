package View;

import model.Histogram;
import java.util.List;

public class MailHistogramBuilder {

    public MailHistogramBuilder(){}

    public Histogram<String> build (List<String> mails){
        Histogram<String> histogram = new Histogram();
        for (String mail : mails) {
            histogram.increment(mail);
        }
        return histogram;
    }
}