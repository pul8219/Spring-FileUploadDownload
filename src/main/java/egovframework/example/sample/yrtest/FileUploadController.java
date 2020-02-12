package egovframework.example.sample.yrtest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/*import java.util.List;
import java.util.Map;*/

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

/*import org.apache.log4j.Logger;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FileUploadController {
	
	@RequestMapping(value="/fileuploadpage.do")
	public String pageload(){
		return "sample/fileUpload";
	}
	
	
	//private static final String SAVE_PATH = "c:/tmp/";
	private static final String SAVE_PATH = "C:/Users/R/eGovFrameDev-3.7.0-64bit/workspace/board/src/main/webapp/file/";
	
	
	@RequestMapping(value="/fileupload.do")
	public ModelAndView upload(HttpServletRequest request, @RequestParam("filename") MultipartFile file) throws IllegalStateException, IOException{
		//RequestParam 을 통해 View단에서 업로드한 파일을 MultipartFile 타입 변수에 담음
		
		String originalFileName = file.getOriginalFilename();
		String saveFileName = System.currentTimeMillis() + originalFileName;
		long fileSize = file.getSize();
		
		//Console 확인
		System.out.println("원본 파일명 : " + originalFileName);
		System.out.println("새로운 파일명 : " + saveFileName);
		System.out.println("파일 크기 : " + fileSize);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sample/uploadSuccess"); //보여줄 페이지
    	mv.addObject("file_name", saveFileName); //key, value를 담을 수 있는 메서드
    	mv.addObject("file_path", SAVE_PATH);
		
//        try{
        	// 맥일 경우 
            //FileOutputStream fos = new FileOutputStream("/tmp/" + file.getOriginalFilename());
            // 윈도우일 경우
            /*
        	FileOutputStream fos = new FileOutputStream("C:/tmp/" + file.getOriginalFilename());
            InputStream is = file.getInputStream();
        	    int readCount = 0;
        	    byte[] buffer = new byte[1024];
            while((readCount = is.read(buffer)) != -1){
                fos.write(buffer,0,readCount);
                
        		}
        		*/
        	
        	// void transferTo(File dest) 업로드한 파일의 데이터를 저장
        	// 위에서 지정한 SAVE_PATH 경로에 새로운 파일명(파일생성시간+원본파일명)으로 파일 데이터 저장
        	file.transferTo(new File(SAVE_PATH + saveFileName));
        	
        	return mv;
        	
        	
        	
        	
//        }
//        catch(IllegalStateException | IOException e){
//            e.printStackTrace();
//        }
        
        
//		return "sample/uploadSuccess";
	}
	
	
}
