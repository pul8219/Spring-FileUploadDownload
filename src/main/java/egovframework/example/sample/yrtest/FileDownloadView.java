package egovframework.example.sample.yrtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
 
public class FileDownloadView extends AbstractView {
 
    public void Download(){
        setContentType("application/download; utf-8");
    }
         
	//파일 다운로드
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        
        File file = (File)model.get("downloadFile");
        System.out.println("DownloadView --> file.getPath() : " + file.getPath());
        System.out.println("DownloadView --> file.getName() : " + file.getName());
        //여기서의 getPath()를 나중에 DB에 파일 경로 넣을 때 사용하면 됨
        
        response.setContentType(getContentType());
        response.setContentLength((int)file.length());
         
        String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;
        String fileName = null;
         
        if(ie){
            fileName = URLEncoder.encode(file.getName(), "utf-8");               
        }
        else {   
            fileName = new String(file.getName().getBytes("utf-8")); 
        }// end if;
 
         
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
         
        OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
         
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);     
        }
        catch(Exception e){
            e.printStackTrace();     
        }
        finally{
            if(fis != null){ 
                try{
                    fis.close();
                }
                catch(Exception e){}
            }     
        }// try end;
         
        out.flush();
		
	}
	
}