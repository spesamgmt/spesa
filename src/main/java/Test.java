/* ImageCropper.java */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) {
		try {
			
			File[] files = new File("C:\\imagecutter\\ScanImages\\").listFiles();
			 for (File file : files) {
			        if (file.isDirectory()) {
			            System.out.println("Directory: " + file.getName());
			        } else {
			            System.out.println("File: " + file.getName());
			            generateCroppedImages(file);
			        }
			    }
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void generateCroppedImages(File file) throws IOException {
		BufferedImage originalImgage = ImageIO.read(file);

		System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());
		int rowWiseCount = 0;
		for(int j = 1; j<10;j=j+3){
			rowWiseCount++;
			int columnWiseCount = 0;
			for(int i =1 ; i<=5; i=i+2){
				columnWiseCount++;
				BigDecimal initialX =  new BigDecimal(i*0.14).multiply(new BigDecimal(originalImgage.getWidth())) ;
				BigDecimal initialY =  new BigDecimal(j*0.10).multiply(new BigDecimal(originalImgage.getHeight())) ;
				BufferedImage SubImgage = originalImgage.getSubimage(initialX.intValue(), initialY.intValue(), 400, 450);
				System.out.println("Cropped Image Dimension: "+initialX.intValue()+"x"+(initialY.intValue()));

				File outputfile = new File("C:\\imagecutter\\Photo\\"+file.getName()+rowWiseCount+"_"+columnWiseCount+".jpg");
				ImageIO.write(SubImgage, "jpg", outputfile);

				System.out.println("Image cropped successfully: "+outputfile.getPath());
			}
		}
		
		int  rowWiseCountSign = 0;
		for(double j = 1; j<=3;j=j+1){	
			rowWiseCountSign++;
			int columnWiseCount = 0;
			for(double i =1 ; i<=7; i=i+2.8){
				columnWiseCount++;
				BigDecimal initialX =  new BigDecimal(i*0.10).multiply(new BigDecimal(originalImgage.getWidth())) ;
				BigDecimal initialY =  new BigDecimal(j*0.28).multiply(new BigDecimal(originalImgage.getHeight())) ;
				BufferedImage SubImgage = originalImgage.getSubimage(initialX.intValue(), initialY.intValue(), 450, 150);
				System.out.println("Cropped Image Dimension: "+initialX.intValue()+"x"+initialY.intValue());

				File outputfile = new File("C:\\imagecutter\\Sign\\"+file.getName()+rowWiseCountSign+"_"+columnWiseCount+".jpg");
				ImageIO.write(SubImgage, "jpg", outputfile);

				System.out.println("Image cropped successfully: "+outputfile.getPath());
			}
		}

	}
}