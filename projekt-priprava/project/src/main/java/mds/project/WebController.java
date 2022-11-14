package mds.project;


import mds.project.component.ProjectResourceComponent;
import mds.project.model.VideoLibrary;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.jcodec.api.JCodecException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

import static mds.project.FilePaths.*;

@Controller
public class WebController {
    private ProjectResourceComponent handler;

    @Autowired
    public WebController(ProjectResourceComponent handler) {
        this.handler = handler;
    }



    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "video", method = {RequestMethod.POST})
    public String video(@RequestParam(defaultValue = VIDEO_FROM_URL) String url,
                         @RequestParam(defaultValue = "1000") String width,
                         Model model) {

        model.addAttribute("url", url);
        model.addAttribute("width", width);
        return "video";
    }


    @RequestMapping(value = { "/dash/{stream}/{file}"}, method = RequestMethod.GET)
    public void streaming(
            @PathVariable("stream") String stream,
            @PathVariable("file") String file,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        File STREAM_FILE = null;
        STREAM_FILE = new File(DASH_DIRECTORY + stream + "\\" + file);

        request.setAttribute(ProjectResourceComponent.ATTR_FILE, STREAM_FILE);
        handler.handleRequest(request, response);
    }


    @GetMapping("/player/{stream}")
    public String player(Model model, @PathVariable("stream") String stream) {
        model.addAttribute("stream", stream);
        return "player";
    }


    private VideoLibrary library = null;

    @GetMapping("/videocollection")
    public String videoCollection(Model model) throws IOException, JCodecException {
        if (library == null) {
            library = new VideoLibrary(DASH_DIRECTORY, ".mpd");
        }
        model.addAttribute("libraryA", library);
        return "videocollection";
    }





}
