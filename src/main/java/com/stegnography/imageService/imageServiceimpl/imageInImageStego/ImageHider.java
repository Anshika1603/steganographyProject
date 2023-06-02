package com.stegnography.imageService.imageServiceimpl.imageInImageStego;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class ImageHider {

	private ImageWriteReader imgWriteReader;
	private ImageSteganography steganographer;

	public ImageHider() {
		this.imgWriteReader = new ImageWriteReader();
		this.steganographer = new ImageSteganography();
	}

	public String hide(String canvasImageUrl, String secretImageUrl, String outputUrl) {
		this.imgWriteReader.writeImage(this.steganographer.encode(
				this.imgWriteReader.readImage(canvasImageUrl),
				this.imgWriteReader.readImage(secretImageUrl)),
				outputUrl);
		Messages.IMAGE_HIDDEN_SUCCESSFULLY.println();
		String password = UUID.randomUUID().toString();
		return password;
	}

	public void reveal(String canvasImageUrl, String outputUrl) {
		this.imgWriteReader.writeImage(this.steganographer.decode(
				this.imgWriteReader.readImage(canvasImageUrl)),
				outputUrl);
		Messages.IMAGE_EXTRACTED_SUCCESSFULLY.println();
	}

}
