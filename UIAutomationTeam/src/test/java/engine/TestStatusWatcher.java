package engine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Supplier;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import helper.AllureAttachmentHelper;
import helper.SupportedImageTypes;
import io.qameta.allure.Allure;

/**
 * JUnit {@link TestWatcher} implementation responsible for reacting to
 * test execution outcomes and handling post-test artifacts.
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class TestStatusWatcher implements TestWatcher{

    private Supplier<Path> videoResult;
    private Supplier<Path> harResult;
    private Supplier<byte[]> screenshotResult;
    private Path updatedvideoPath;

    public TestStatusWatcher(
            Supplier<Path> videoResult,
            Supplier<Path> harResult,
            Supplier<byte[]> screenshotResult
    ) {
        this.videoResult = videoResult;
        this.harResult = harResult;
        this.screenshotResult = screenshotResult;
    }
	
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (videoResult.get() != null) {
        	updatedvideoPath = renameVideo(context, "FAILED", videoResult.get());
        	AllureAttachmentHelper.addVideoAttachment(context, updatedvideoPath);
        }
        if (harResult.get() != null) {
        	AllureAttachmentHelper.addFileAttachment("Network HAR","application/json",".har", harResult.get());
        }
        if (screenshotResult.get() != null) {
        	AllureAttachmentHelper.addImageAttachment(screenshotResult.get(), SupportedImageTypes.JPEG);
        }
        AllureAttachmentHelper.addTextAttachment("Failure Log", buildFailureLog(context, cause));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        if (videoResult.get() != null) {
        	updatedvideoPath = renameVideo(context, "SUCCESS", videoResult.get());
        	AllureAttachmentHelper.addVideoAttachment(context, updatedvideoPath);
        }
        if (screenshotResult.get() != null) {
        	AllureAttachmentHelper.addImageAttachment(screenshotResult.get(), SupportedImageTypes.JPEG);
        }
    }
    
    private Path renameVideo(ExtensionContext context, String status, Path videoPath) {
        try {
            Path target = Paths.get("target/videos", context.getDisplayName() + "_" + status + "_" + System.currentTimeMillis() + ".webm"
            );
            Files.createDirectories(target.getParent());
            Files.move(videoPath, target, StandardCopyOption.REPLACE_EXISTING);
            return target;
        } catch (Exception e) {
        	System.err.println("Error while processing video: " + e.getMessage());
            Allure.addAttachment("Video Processing Error",e.toString());
            return null;
        }
    }
    
    private String buildFailureLog(ExtensionContext context, Throwable cause) {
        StringBuilder sb = new StringBuilder();
        sb.append("Test: ")
          .append(context.getDisplayName())
          .append(System.lineSeparator());
        sb.append("Thread: ")
          .append(Thread.currentThread().getName())
          .append(System.lineSeparator());
        sb.append("Error: ")
          .append(cause.toString())
          .append(System.lineSeparator())
          .append(System.lineSeparator());
        for (StackTraceElement element : cause.getStackTrace()) {
            sb.append(element.toString())
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

}
