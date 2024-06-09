package com.example.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 14);
			contentStream.beginText();
			contentStream.newLineAtOffset(50, 720);
			contentStream.showText("Hello! This is my first pdf file generated with Java!");
			contentStream.endText();
			contentStream.close();

			document.save("myFirstPdfWithJava.pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

