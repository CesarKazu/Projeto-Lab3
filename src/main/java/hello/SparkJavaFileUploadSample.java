package hello;

import static spark.Spark.*;
import spark.utils.IOUtils;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SparkJavaFileUploadSample {

    public void teste(){
    	post("/api/upload", (req, res) -> {
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/img"));
            Part filePart = req.raw().getPart("myfile");

            try (InputStream inputStream = filePart.getInputStream()) {
                OutputStream outputStream = new FileOutputStream("img/" + filePart.getSubmittedFileName());
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
            }

            return "File uploaded and saved.";
        });
    }
}