package engine.helper;

public enum SupportedImageTypes {

	PNG("image/png", ".png"),
	JPG("image/jpeg", ".jpg"),
	JPEG("image/jpeg", ".jpeg"),
	WEBP("image/webp", ".webp");

	private final String mimeType;
	private final String extension;

	SupportedImageTypes(String mimeType, String extension) {
		this.mimeType = mimeType;
		this.extension = extension;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getExtension() {
		return extension;
	}
}
