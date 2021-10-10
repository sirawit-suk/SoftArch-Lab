package creational;

public class JSONBookMetadataExporter extends BookMetadataExporter{

    @Override
    public BookMetadataFormatter createBookExport() {
        return new JSONBookMetadataFormatter();
    }
}
