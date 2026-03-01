package engine.helper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import org.junit.jupiter.api.extension.ExtensionContext;

import io.qameta.allure.Allure;

/**
 * Utility class responsible for attaching different types of artifacts
 * to Allure reports.
 * <p>
 * This helper centralizes all interactions with the Allure API, preventing
 * the rest of the codebase from being directly coupled to Allure-specific
 * implementations.
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class AllureAttachmentHelper {

	private AllureAttachmentHelper() {}

	public static void addVideoAttachment(ExtensionContext context, Path videoPath) {
        if (videoPath == null || !Files.exists(videoPath)) return;
		try (InputStream is = Files.newInputStream(videoPath)) {
			Allure.addAttachment(context.getDisplayName() + "_" + LocalDateTime.now(), "video/webm", is, ".webm");
		} catch (Exception e) {
			System.err.println("Error attaching video: " + e.getMessage());
		}
	}

	public static void addImageAttachment(byte[] image, SupportedImageTypes imageType) {
        if (image == null || image.length == 0) return;
		Allure.addAttachment(
				"Screenshot", 
				imageType.getMimeType(), 
				new ByteArrayInputStream(image),
				imageType.getExtension());
	}
	
    public static void addTextAttachment(String name, String content) {
        if (content == null || content.isBlank()) return;
        Allure.addAttachment(
            name,
            "text/plain",
            content
        );
    }

    public static void addFileAttachment(String name, String mimeType, String extension, Path filePath) {
        if (filePath == null || !Files.exists(filePath)) return;
        try (InputStream is = Files.newInputStream(filePath)) {
            Allure.addAttachment(name, mimeType, is, extension);
        } catch (Exception e) {
            System.err.println("Error attaching file: " + e.getMessage());
        }
    }
}
