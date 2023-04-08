package service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadService {

	public String upload(HttpServletRequest request, String param) {
		try {

			Part part = request.getPart(param);
//			String fileNameRanDom = UUID.randomUUID()
			String fileName = part.getSubmittedFileName();
			String uploadFile = "/upload/" + fileName;
			String realPath = request.getRealPath(uploadFile);
			if(fileName.equalsIgnoreCase("")) {
				return null;
			}
			part.write(realPath);
			return fileName;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "user.png";

	}
}
