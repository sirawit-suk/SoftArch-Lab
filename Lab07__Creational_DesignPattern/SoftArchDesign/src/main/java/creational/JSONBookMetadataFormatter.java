package creational;

// Use json-simple-1.1.1.jar that sensei provided
// Reference: https://mkyong.com/java/json-simple-example-read-and-write-json/
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.StringWriter;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    JSONObject bookObj;
    JSONArray bookList;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookObj = new JSONObject();
        bookList = new JSONArray();
        bookObj.put(Book.class.getSimpleName()+"s", bookList);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject newBookObj = new JSONObject();
        JSONArray newAuthorsList = new JSONArray();
        for(String author : b.getAuthors()){
            newAuthorsList.add(author);
        }

        newBookObj.put(Book.Metadata.ISBN.value,b.getISBN());
        newBookObj.put(Book.Metadata.AUTHORS.value, newAuthorsList);
        newBookObj.put(Book.Metadata.TITLE.value,b.getTitle());
        newBookObj.put(Book.Metadata.PUBLISHER.value,b.getPublisher());

        bookList.add(newBookObj);
        return this;
    }

    @Override
    public String getMetadataString() {
        return bookObj.toString();
    }
}
