package engine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import engine.helper.AllureAttachmentHelper;
import engine.helper.SupportedImageTypes;
import io.qameta.allure.Allure;

/**
 * JUnit {@link TestWatcher} implementation responsible for reacting to
 * test execution outcomes and handling post-test artifacts.
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class TestStatusWatcher implements TestWatcher{

    private Supplier<Path> videoOfTetResult;
    private Supplier<byte[]> screenshotOfTestResult;
    private Path updatedvideoPath;

    public TestStatusWatcher(
            Supplier<Path> videoOfTetResult,
            Supplier<byte[]> screenshotOfTestResult
    ) {
        this.videoOfTetResult = videoOfTetResult;
        this.screenshotOfTestResult = screenshotOfTestResult;
    }

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		TestWatcher.super.testDisabled(context, reason);
	}

	@Override
	public void testAborted(ExtensionContext context, @Nullable Throwable cause) {
		TestWatcher.super.testAborted(context, cause);
	}
	
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (videoOfTetResult.get() != null) {
        	updatedvideoPath = renameVideo(context, "FAILED", videoOfTetResult.get());
        	AllureAttachmentHelper.addVideoAttachment(context, updatedvideoPath);
        }
        if (screenshotOfTestResult.get() != null) {
        	AllureAttachmentHelper.addImageAttachment(screenshotOfTestResult.get(), SupportedImageTypes.JPEG);
        }
        AllureAttachmentHelper.addTextAttachment("Failure Log", buildFailureLog(context, cause));
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        if (videoOfTetResult.get() != null) {
        	updatedvideoPath = renameVideo(context, "PASSED", videoOfTetResult.get());
        	AllureAttachmentHelper.addVideoAttachment(context, updatedvideoPath);
        }
        if (screenshotOfTestResult.get() != null) {
        	AllureAttachmentHelper.addImageAttachment(screenshotOfTestResult.get(), SupportedImageTypes.JPEG);
        }
    }
    
    private Path renameVideo(ExtensionContext context, String status, Path videoPath) {
        try {
            Path target = Paths.get(
            		"target/videos",
            		context.getDisplayName() + "_" + status + "_" + System.currentTimeMillis() + ".webm"
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
