package creational;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class CSVBookMetadataFormatter implements BookMetadataFormatter {

    private StringWriter writer;
    private CSVPrinter csvPrinter;

    //if run Constructor, it will go to method reset();
    public CSVBookMetadataFormatter() throws IOException {
        reset();
    }

    public BookMetadataFormatter reset() { //return this class , I think reset() is like an initiate of metaData string
        writer = new StringWriter();
        try {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            Stream<String> headers = Arrays.stream(Book.Metadata.values()).map(Book.Metadata::getValue);
            csvPrinter.printRecord(headers.toList()); // Got it, Print some meta data first...
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) { // This is the main core of adding new book to list
        String authors = String.join("|", b.getAuthors());
        try {
            csvPrinter.printRecord(b.getISBN(), b.getTitle(), b.getPublisher(), authors); // YEAH! This is print in format csv!
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String getMetadataString() {
        return writer.toString();
    }
}
