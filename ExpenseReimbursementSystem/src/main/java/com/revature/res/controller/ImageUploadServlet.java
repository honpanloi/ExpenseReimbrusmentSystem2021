package com.revature.res.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.revature.res.util.Tools;

/**
 * Servlet implementation class ImageUploadServlet
 */
@WebServlet("/api/upload")
@MultipartConfig(location = "C:\\Users\\honpa\\Documents\\java_examples\\")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1345234823L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting the part from the request
		Part filePart = request.getPart("photo");
		//rename the
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String newFileName = Tools.getPrintedCurrentDateForFiles()+fileName;
		
		//create a temperate file
		//File newfile = File.createTempFile("temp", ".png");
		File newfile = new File(fileName);
		
		//make a output stream and target the newfile
		FileOutputStream fileOutputStream = new FileOutputStream(newfile);
		
		//write the newfile with the input stream the i
		fileOutputStream.write(filePart.getInputStream().readAllBytes());
		
		//close the output stream
		fileOutputStream.close();

		
		
		//Uploading to the bucket
		String bucket_name = "honpan.images.bucket";
		System.out.format("Uploading %s to S3 bucket %s...\n",  fileName, bucket_name);
		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		try {
			s3.putObject(bucket_name, newFileName, newfile);
		} catch (AmazonServiceException e) {
			System.err.println(e.getErrorMessage());
			System.exit(1);
		} catch (AmazonClientException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Done!");

	}

}
