package com.stegnography.imageService.imageServiceimpl.imageInImageStego;

import java.awt.image.BufferedImage;

import com.stegnography.imageService.imageServiceimpl.imageInImageStego.imageHandling.ImageHiderHandler;
import com.stegnography.imageService.imageServiceimpl.imageInImageStego.imageHandling.ImageRevealHandler;

public class ImageSteganography {

	private BufferedImage canvasImage;
	private BufferedImage secretImage;
	private ImageHiderHandler imgHideHandler;
	private ImageRevealHandler imgRevealHandler;
	public final static int METADATA_PIXELS = 2;

	public ImageSteganography() {
		this.imgHideHandler = new ImageHiderHandler();
		this.imgRevealHandler = new ImageRevealHandler();
	}

	public BufferedImage encode(BufferedImage canvasImage, BufferedImage secretImage) {
		this.canvasImage = canvasImage;
		this.secretImage = secretImage;
		this.checkHideImageDimensions();
		return this.imgHideHandler.hide(this.canvasImage, this.secretImage);

	}

	public BufferedImage decode(BufferedImage canvasImage) {
		this.canvasImage = canvasImage;
		this.checkImageRevealMetadata();
		return this.imgRevealHandler.reveal(this.canvasImage);
	}

	private void checkHideImageDimensions() {
		Messages.READING_IMAGE_FILES.println();
		int canvasArea = this.canvasImage.getHeight() * this.canvasImage.getWidth();
		int secretArea = this.secretImage.getHeight() * this.secretImage.getWidth();
		System.out.println(canvasArea +" , " + secretArea + ", " + 2 * secretArea + ImageSteganography.METADATA_PIXELS);
		if (canvasArea < (2 * secretArea + ImageSteganography.METADATA_PIXELS)) {
			Messages.CANVAS_TOO_SMALL.println();
			System.exit(1);
		}
	}

	private void checkImageRevealMetadata() {
		Messages.READING_IMAGE_FILES.println();
		int width = 0x00ffffff & this.canvasImage.getRGB(this.canvasImage.getWidth() - 1, this.canvasImage.getHeight() - 1);
		int height = 0x00ffffff	& this.canvasImage.getRGB(this.canvasImage.getWidth() - 1, this.canvasImage.getHeight() - 2);
		double secretArea = Math.abs(width * height);
		double canvasArea = this.canvasImage.getHeight() * this.canvasImage.getWidth();
		if ((2 * secretArea + ImageSteganography.METADATA_PIXELS) > canvasArea) {
			Messages.NO_HIDDEN_IMAGE.println();
			System.exit(1);
		}
	}

}
