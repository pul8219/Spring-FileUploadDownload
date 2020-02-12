package egovframework.example.sample.yrtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/*import java.util.List;
import java.util.Map;*/

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/*import org.apache.log4j.Logger;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController implements ApplicationContextAware{
	private WebApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = (WebApplicationContext)arg0;	
	}
	
	@RequestMapping(value="/filedownload.do")
	public ModelAndView download(@RequestParam("path") String path, @RequestParam("fileName") String fileName){
		String fullPath = path + fileName;
		File file = new File(fullPath);
		//dispatcher-servlet.xml 파일에 download 라는 빈을 추가했었는데 이걸 이용해서 클래스를 뷰처럼 사용할 것
		//"download" 뷰페이지(servlet의 download에 매핑된 view Class로 간다)로 downloadFile이라는 이름으로 파일을 삽입시켜 리턴한다.
		return new ModelAndView("download", "downloadFile", file);
	}
	
	

}
