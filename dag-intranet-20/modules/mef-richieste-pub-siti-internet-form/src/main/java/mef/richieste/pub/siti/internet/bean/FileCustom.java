package mef.richieste.pub.siti.internet.bean;

import java.io.File;

public class FileCustom {
	private File file;
	private String mimeType;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
